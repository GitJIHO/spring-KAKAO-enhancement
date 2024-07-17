package gift.service;

import gift.dto.CategoryRequest;
import gift.entity.Category;
import gift.exception.CategoryHasProductsException;
import gift.exception.CategoryNotFoundException;
import gift.repository.CategoryRepository;
import gift.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryService(CategoryRepository categoryRepository,
        ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public Category addCategory(CategoryRequest request) {
        Category category = new Category(request.getName(), request.getColor(),
            request.getImageUrl(), request.getDescription());
        return categoryRepository.save(category);
    }

    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
            () -> new CategoryNotFoundException("id에 해당하는 카테고리가 없습니다."));
    }

    public Category updateCategory(Long id, CategoryRequest request) {
        Category category = new Category(id, request.getName(), request.getColor(),
            request.getImageUrl(), request.getDescription());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        if (!productRepository.findByCategoryId(id).isEmpty()) {
            throw new CategoryHasProductsException("해당 카테고리에 속한 상품이 있습니다.");
        }
        categoryRepository.deleteById(id);
    }
}
