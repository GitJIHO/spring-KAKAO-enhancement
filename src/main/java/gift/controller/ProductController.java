package gift.controller;

import gift.dto.ProductCreateRequest;
import gift.dto.ProductRequest;
import gift.dto.ResponseMessage;
import gift.entity.Product;
import gift.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<Product> getProduct(
        @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return productService.getAllProducts(pageable);
    }

    @GetMapping("/{id}")
    public Product getOneProduct(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(
        @Valid @RequestBody ProductCreateRequest productCreateRequest) {
        Product product = productService.saveProduct(productCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> changeProduct(@PathVariable("id") Long id,
        @Valid @RequestBody ProductRequest productRequest) {
        Product product = productService.updateProduct(id, productRequest);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> removeProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        ResponseMessage responseMessage = new ResponseMessage("삭제되었습니다.");
        return ResponseEntity.ok(responseMessage);
    }
}
