package gift.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OptionTest {

    private Option option;

    @BeforeEach
    void setUp() {
        option = new Option( "옵션", 500, new Product());
    }

    @Test
    @DisplayName("생성자 테스트")
    void OptionConstructorTest() {
        Option newoption = new Option( "new 옵션", 1000, new Product());

        assertThat(newoption).isNotNull();
        assertThat(newoption.getName()).isEqualTo("new 옵션");
        assertThat(newoption.getQuantity()).isEqualTo(1000);
    }

    @Test
    @DisplayName("Getter 테스트")
    void ProductGetterTest() {
        assertThat(option.getName()).isEqualTo("옵션");
        assertThat(option.getQuantity()).isEqualTo(500);
    }

    @Test
    @DisplayName("updateOption 테스트")
    void updateOptionTest() {
        option.updateOption("업데이트 옵션", 101010, new Product());

        assertThat(option.getName()).isEqualTo("업데이트 옵션");
        assertThat(option.getQuantity()).isEqualTo(101010);
    }
}
