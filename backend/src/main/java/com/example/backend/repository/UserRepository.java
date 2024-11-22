package com.example.backend.repository;


import com.example.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    //số đt có tồn tại không
    boolean existsByPhoneNumber(String phoneNumber);
    //trả về kết quả tránh lỗi null
    Optional<User> findByPhoneNumber(String phoneNumber);
    //Select * from users where phonenumber=? tự động sinh ra
}

