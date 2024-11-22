package com.example.backend.controller;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.entity.Category;
import com.example.backend.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${api.prefix}/categories")
//@Validated //khai báo validated nghĩa là chưa vào hàm đã validate
//Dependency Injection
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("")
    //nếu tham số truyền vào là 1 đối tượng object
    //truyền vào data transfer object = request object
    // @valid gọi ra validated
    //bindingResult hiện ra validated
    public ResponseEntity<?> createCategory(
            @Valid @RequestBody CategoryDTO categoryDTO,
            BindingResult result) {
        if (result.hasErrors()) {
            // Lấy danh sách lỗi
            List<String> errorMessages = result.getFieldErrors() // Dùng getFieldErrors()
                    .stream()  //chuyển sang danh sách string messeage,
                    .map(FieldError::getDefaultMessage) //sử dụng stream duyệt qua và ánh xạ sang mảng khác
                    .toList();
            return ResponseEntity.badRequest().body(errorMessages); //lấy ra lỗi
        }

        categoryService.createCategory(categoryDTO);

        return ResponseEntity.ok("Insert category successfully" + categoryDTO);
    }

    //Hiện tất cả các category
    @GetMapping("")
    public ResponseEntity<List<Category>> getCategories(
            @RequestParam ("page") int page,
            @RequestParam ("limit") int limit
    ){
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategories(
            @PathVariable Long id,
            @Valid @RequestBody CategoryDTO categoryDTO){
        categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok("Update category successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategories(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Delete category with id: " +id+ " successfully");
    }

}

