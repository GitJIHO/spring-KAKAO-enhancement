package gift.dto;

import gift.validation.UniqueOptionNames;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;

public class ProductCreateRequest {

    @Size(max = 15, message = "상품 이름은 공백을 포함하여 최대 15자까지 입력할 수 있습니다.")
    @Pattern(regexp = "^[a-zA-Z0-9가-힣 ()\\[\\]+\\-&/_]*$", message = "(),[],+,-,&,/,_를 제외한 특수 문자 사용은 불가능합니다.")
    @Pattern(regexp = "^(?!.*카카오).*$", message = "카카오가 포함된 문구는 담당 MD와 협의한 경우에만 사용할 수 있습니다.")
    private String name;
    private Integer price;
    private String img;
    @NotNull(message = "상품에는 항상 하나의 카테고리가 있어야 합니다.")
    private Long categoryId;
    @NotNull(message = "상품의 옵션은 최소 1개가 있어야 합니다.")
    @Valid
    @UniqueOptionNames(message = "옵션 이름이 중복될 수 없습니다.")
    private List<OptionRequest> options;

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public List<OptionRequest> getOptions() {
        return options;
    }
}
