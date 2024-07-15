package gift.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryTest {

    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category(1L, "음식", "testColor", "testImage.jpg", "TestDescription");
    }

    @Test
    @DisplayName("생성자 테스트")
    void CategoryConstructorTest() {
        Category newCategory = new Category(2L, "상품권", "testColor2", "testImage2.jpg", "TestDescription2");

        assertThat(newCategory).isNotNull();
        assertThat(newCategory.getId()).isEqualTo(2L);
        assertThat(newCategory.getName()).isEqualTo("상품권");
        assertThat(newCategory.getColor()).isEqualTo("testColor2");
        assertThat(newCategory.getImage_url()).isEqualTo("testImage2.jpg");
        assertThat(newCategory.getDescription()).isEqualTo("TestDescription2");
    }

    @Test
    @DisplayName("Getter 테스트")
    void CategoryGetterTest() {
        assertThat(category.getId()).isEqualTo(1L);
        assertThat(category.getName()).isEqualTo("음식");
        assertThat(category.getColor()).isEqualTo("testColor");
        assertThat(category.getImage_url()).isEqualTo("testImage.jpg");
        assertThat(category.getDescription()).isEqualTo("TestDescription");
    }
}
