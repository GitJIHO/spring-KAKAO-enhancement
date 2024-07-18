package gift.service;

import gift.dto.ProductRequest;
import gift.entity.Category;
import gift.entity.Product;
import gift.exception.CategoryNotFoundException;
import gift.exception.MinimumOptionException;
import gift.exception.ProductNotFoundException;
import gift.repository.CategoryRepository;
import gift.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private Boolean skipOptionCheck = false;

    public ProductService(ProductRepository productRepository,
        CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public void setSkipOptionCheck(boolean skip) {
        skipOptionCheck = skip;
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        products.forEach(this::checkMinimumOption);
        return products;
    }

    public Product getProductById(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("해당 id를 가지고있는 Product 객체가 없습니다."));
        checkMinimumOption(product);
        return product;
    }

    public Product saveProduct(ProductRequest productRequest) {
        Category category = categoryRepository.findById(productRequest.getCategoryId())
            .orElseThrow(() -> new CategoryNotFoundException("category id에 해당하는 카테고리가 없습니다."));
        Product product = new Product(productRequest.getName(), productRequest.getPrice(),
            productRequest.getImg(), category);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductRequest productRequest) {
        Category category = categoryRepository.findById(productRequest.getCategoryId())
            .orElseThrow(() -> new CategoryNotFoundException("category id에 해당하는 카테고리가 없습니다."));
        productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("해당 id를 가지고있는 Product 객체가 없습니다."));
        Product product = new Product(id, productRequest.getName(), productRequest.getPrice(),
            productRequest.getImg(), category);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.findById(id).ifPresentOrElse(
            product -> productRepository.deleteById(id),
            () -> { throw new ProductNotFoundException("해당 id를 가지고있는 Product 객체가 없습니다."); }
        );
    }

    private void checkMinimumOption(Product product) {
        if (!skipOptionCheck && (product.getOptions() == null || product.getOptions()
            .isEmpty())) {
            throw new MinimumOptionException(
                "[상품 ID: " + product.getId() + "]의 옵션이 없습니다. 옵션을 추가해주세요.");
        }
    }
}
