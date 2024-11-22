package com.example.backend.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data //cung cấp hàm getter setter lombok
@Setter
@Getter
@AllArgsConstructor //hàm khởi tạo tất cả đối tượng
@NoArgsConstructor //hàm khởi tạo mặc định không có tham số
@Builder
public class ProductDTO {
    @NotBlank(message = "title is required")
    @Size(min = 3, max = 200, message = "title must be between 3 and 200 character")
    private String name;

    @Min(value = 0, message = "price must be greater than or equal to 0")
    private Float price;

    private String thumbnail;

    private String description;

    @JsonProperty("category_id") //nếu khác tên với database
    private Long categoryId;
}
