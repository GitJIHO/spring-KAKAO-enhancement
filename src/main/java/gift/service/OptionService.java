package gift.service;

import gift.dto.OptionRequest;
import gift.entity.Option;
import gift.entity.Product;
import gift.exception.DuplicateOptionNameException;
import gift.exception.MinimumOptionException;
import gift.exception.OptionNotFoundException;
import gift.exception.ProductNotFoundException;
import gift.repository.OptionRepository;
import gift.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OptionService {

    private final OptionRepository optionRepository;
    private final ProductRepository productRepository;

    public OptionService(OptionRepository optionRepository, ProductRepository productRepository) {
        this.optionRepository = optionRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Option addOption(Long productId, OptionRequest request) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ProductNotFoundException("Product ID에 해당하는 Product가 없습니다."));
        Option option = optionRepository.save(new Option(request.getName(), request.getQuantity(), product));

        checkDuplicateOptionName(product, request.getName(), null);

        return option;
    }

    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }

    public List<Option> getAllOptionsByProductId(Long productId) {
        return optionRepository.findAllByProductId(productId);
    }

    public Option getOneOptionById(Long id) {
        return optionRepository.findById(id).orElseThrow(
            () -> new OptionNotFoundException("ID에 해당하는 옵션이 없습니다."));
    }

    @Transactional
    public Option updateOption(Long productId, Long id, OptionRequest request) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ProductNotFoundException("Product ID에 해당하는 Product가 없습니다."));
        Option option = optionRepository.findById(id)
            .orElseThrow(() -> new OptionNotFoundException("ID에 해당하는 옵션이 없습니다."));

        if (!option.getName().equals(request.getName())) {
            checkDuplicateOptionName(product, request.getName(), id);
        }

        option.updateOption(request.getName(), request.getQuantity(), product);

        return option;
    }

    public void deleteOption(Long productId, Long id) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ProductNotFoundException("Product ID에 해당하는 Product가 없습니다."));
        Option option = optionRepository.findById(id)
            .orElseThrow(() -> new OptionNotFoundException("ID에 해당하는 옵션이 없습니다."));

        if (product.getOptions().size() <= 1) {
            throw new MinimumOptionException("상품의 옵션이 1개 이하인 경우 옵션을 삭제할 수 없습니다.");
        }

        product.getOptions().remove(option);
        productRepository.save(product);
        optionRepository.deleteById(id);
    }

    private void checkDuplicateOptionName(Product product, String optionName,
        Long excludeOptionId) {
        boolean duplicate = product.getOptions().stream()
            .anyMatch(option -> option.getName().equals(optionName) &&
                (excludeOptionId == null || !option.getId().equals(excludeOptionId)));

        if (duplicate) {
            throw new DuplicateOptionNameException("상품에 이미 동일한 옵션 이름이 존재합니다: " + optionName);
        }
    }

}
