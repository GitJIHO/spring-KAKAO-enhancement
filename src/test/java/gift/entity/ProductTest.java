package gift.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {

    private Category category;
    private Product product;

    @BeforeEach
    void setUp() {
        category = new Category(1L, "음식", "testColor", "testImage.jpg", "TestDescription");
        product = new Product(1L, "상품", 10000, "testImg.jpg", category);
    }

    @Test
    @DisplayName("생성자 테스트")
    void ProductConstructorTest() {
        Product newProduct = new Product(2L, "전자제품", 20000, "testImg2.jpg", category);

        assertThat(newProduct).isNotNull();
        assertThat(newProduct.getId()).isEqualTo(2L);
        assertThat(newProduct.getName()).isEqualTo("전자제품");
        assertThat(newProduct.getPrice()).isEqualTo(20000);
        assertThat(newProduct.getImg()).isEqualTo("testImg2.jpg");
        assertThat(newProduct.getCategory()).isEqualTo(category);
    }

    @Test
    @DisplayName("Getter 테스트")
    void ProductGetterTest() {
        assertThat(product.getId()).isEqualTo(1L);
        assertThat(product.getName()).isEqualTo("상품");
        assertThat(product.getPrice()).isEqualTo(10000);
        assertThat(product.getImg()).isEqualTo("testImg.jpg");
        assertThat(product.getCategory()).isEqualTo(category);
    }
}
