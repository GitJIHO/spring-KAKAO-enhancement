package gift.validation;

import gift.dto.OptionRequest;
import gift.entity.Product;
import gift.repository.ProductRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UniqueOptionNameForProductValidator implements ConstraintValidator<UniqueOptionNameForProduct, OptionRequest> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean isValid(OptionRequest optionRequest, ConstraintValidatorContext context) {
        if (optionRequest == null) {
            return true;
        }

        Product product = productRepository.findById(optionRequest.getProductId())
            .orElse(null);

        if (product == null) {
            return true;
        }

        Set<String> existingNames = new HashSet<>();
        product.getOptions().forEach(option -> existingNames.add(option.getName()));

        if (existingNames.contains(optionRequest.getName())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addPropertyNode("name")
                .addConstraintViolation();
            return false;
        }

        return true;
    }
}
