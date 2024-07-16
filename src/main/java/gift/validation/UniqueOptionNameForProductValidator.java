package gift.validation;

import gift.dto.OptionRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueOptionNameForProductValidator implements
    ConstraintValidator<UniqueOptionNameForProduct, List<OptionRequest>> {

    @Override
    public boolean isValid(List<OptionRequest> optionRequests, ConstraintValidatorContext context) {
        if (optionRequests == null) {
            return true;
        }

        return hasUniqueNames(optionRequests, context);
    }

    private boolean hasUniqueNames(List<OptionRequest> optionRequests,
        ConstraintValidatorContext context) {
        Set<String> seenNames = new HashSet<>();
        for (OptionRequest optionRequest : optionRequests) {
            if (!isUnique(optionRequest, seenNames)) {
                addViolation(context, "name");
                return false;
            }
        }
        return true;
    }

    private boolean isUnique(OptionRequest optionRequest, Set<String> seenNames) {
        String uniqueKey = optionRequest.getProductId() + ":" + optionRequest.getName();
        return seenNames.add(uniqueKey);
    }

    private void addViolation(ConstraintValidatorContext context, String property) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
            .addPropertyNode(property)
            .addConstraintViolation();
    }
}
