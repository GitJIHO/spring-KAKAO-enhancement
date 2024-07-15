package gift.service;

import gift.dto.ProductRequest;
import gift.entity.Category;
import gift.entity.Product;
import gift.exception.CategoryNotFoundException;
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

    public ProductService(ProductRepository productRepository,
        CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("해당 id를 가지고있는 Product 객체가 없습니다."));
    }

    public Product saveProduct(ProductRequest productRequest) {
        Category category = categoryRepository.findById(productRequest.getCategory_id())
            .orElseThrow(() -> new CategoryNotFoundException("category id에 해당하는 카테고리가 없습니다."));
        Product product = new Product(productRequest.getName(), productRequest.getPrice(),
            productRequest.getImg(), category);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductRequest productRequest) {
        Category category = categoryRepository.findById(productRequest.getCategory_id())
            .orElseThrow(() -> new CategoryNotFoundException("category id에 해당하는 카테고리가 없습니다."));
        Product product = new Product(id, productRequest.getName(), productRequest.getPrice(),
            productRequest.getImg(), category);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
