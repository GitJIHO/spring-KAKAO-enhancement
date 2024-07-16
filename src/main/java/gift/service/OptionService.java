package gift.service;

import gift.dto.OptionRequest;
import gift.entity.Option;
import gift.entity.Product;
import gift.exception.MinimumOptionException;
import gift.exception.OptionNotFoundException;
import gift.exception.ProductNotFoundException;
import gift.repository.OptionRepository;
import gift.repository.ProductRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OptionService {

    private final OptionRepository optionRepository;
    private final ProductRepository productRepository;

    public OptionService(OptionRepository optionRepository, ProductRepository productRepository) {
        this.optionRepository = optionRepository;
        this.productRepository = productRepository;
    }

    public Option addOption(OptionRequest request) {
        Product product = productRepository.findById(request.getProductId())
            .orElseThrow(() -> new ProductNotFoundException("Product ID에 해당하는 Product가 없습니다."));
        Option option = new Option(request.getName(), request.getQuantity());

        product.getOptions().add(option);
        productRepository.save(product);

        return optionRepository.save(option);
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
    public Option updateOption(Long id, OptionRequest request) {
        Product product = productRepository.findById(request.getProductId())
            .orElseThrow(() -> new ProductNotFoundException("Product ID에 해당하는 Product가 없습니다."));
        Option oldOption = optionRepository.findById(id)
            .orElseThrow(() -> new OptionNotFoundException("ID에 해당하는 옵션이 없습니다."));
        product.getOptions().remove(oldOption);

        Option newOption = new Option(id, request.getName(), request.getQuantity());
        product.getOptions().add(newOption);
        productRepository.save(product);

        return optionRepository.save(newOption);
    }

    public void deleteOption(Long id) {
        Option option = optionRepository.findById(id)
            .orElseThrow(() -> new OptionNotFoundException("ID에 해당하는 옵션이 없습니다."));
        Product product = option.getProduct();

        if (product.getOptions().size() <= 1) {
            throw new MinimumOptionException("상품의 옵션이 1개 이하인 경우 옵션을 삭제할 수 없습니다.");
        }

        product.getOptions().remove(option);
        productRepository.save(product);
        optionRepository.deleteById(id);
    }

}
