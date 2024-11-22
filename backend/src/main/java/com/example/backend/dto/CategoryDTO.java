package com.example.backend.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data //cung cấp hàm getter setter lombok
@Setter
@Getter
@AllArgsConstructor //hàm khởi tạo tất cả đối tượng
@NoArgsConstructor //hàm khởi tạo mặc định không có tham số
public class CategoryDTO {
    //tạo thông báo validated
    @NotEmpty(message = "category is name cannot be empty")
    private String name;
}

