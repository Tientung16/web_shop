package com.example.backend.repository;

import com.example.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //sản phẩm với tên có tồn tại hay không
    boolean existsByName(String name);

    //phân trang
    Page<Product> findAll(Pageable pageable); //truyền vào Pageable lấy ra số lượng phần tử từng trang
}
