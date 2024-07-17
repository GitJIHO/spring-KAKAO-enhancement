package gift.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OptionTest {

    private Option option;

    @BeforeEach
    void setUp() {
        option = new Option(1L, "옵션", 500);
    }

    @Test
    @DisplayName("생성자 테스트")
    void OptionConstructorTest() {
        Option newoption = new Option(2L, "new 옵션", 1000);

        assertThat(newoption).isNotNull();
        assertThat(newoption.getId()).isEqualTo(2L);
        assertThat(newoption.getName()).isEqualTo("new 옵션");
        assertThat(newoption.getQuantity()).isEqualTo(1000);
    }

    @Test
    @DisplayName("Getter 테스트")
    void ProductGetterTest() {
        assertThat(option.getId()).isEqualTo(1L);
        assertThat(option.getName()).isEqualTo("옵션");
        assertThat(option.getQuantity()).isEqualTo(500);
    }
}
