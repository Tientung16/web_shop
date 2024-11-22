package com.example.backend.service;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.entity.Category;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.service.Impl.ImplCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //tư tạo constructor khi trong hàm có thuộc tính final
public class CategoryService implements ImplCategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category newCategory = Category.builder() //khởi tạo đối tượng rỗng rồi khởi tạo từng thành phần
                .name(categoryDTO.getName()) //gán getname của categoryDTO //covert categoryDTO sang category
                .build();
        return categoryRepository.save(newCategory);
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(
            Long categoryId,
            CategoryDTO categoryDTO) {
        Category existingCategory = getCategoryById(categoryId); //tìm category với id
        existingCategory.setName(categoryDTO.getName()); //sửa đổi
        categoryRepository.save(existingCategory);
        return existingCategory;
    }

    @Override
    public void deleteCategory(Long id) {
        //xóa xong
        categoryRepository.deleteById(id);
    }
}

