package com.example.buoi8_sboot_jpa.service;

import com.example.buoi8_sboot_jpa.entity.User;
import com.example.buoi8_sboot_jpa.exception.BadRequestException;
import com.example.buoi8_sboot_jpa.exception.ResourceNotFoundException;
import com.example.buoi8_sboot_jpa.model.request.LoginRequest;
import com.example.buoi8_sboot_jpa.model.request.RegisterRequest;
import com.example.buoi8_sboot_jpa.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService { //lien quan toi dang ki dang nhap
    private  final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final HttpSession session;


    public void login(LoginRequest request) {
        //tim kiem user theo email
        //neu khong ton tai thi throw exception
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Email hoac password khong ton tai"));
        if(!bCryptPasswordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new BadRequestException("email hoac Mat khau khong dung");

        }

        //luu thong tin vso session
        session.setAttribute("currentUser", user); //luu thong tin cua user voi key la currentUser

    }
    public void register(RegisterRequest request) {
        // Kiểm tra xem email đã được sử dụng chưa
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email đã được sử dụng. Vui lòng chọn một email khác.");
        }

        // Kiểm tra xác nhận mật khẩu
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new BadRequestException("Mật khẩu xác nhận không khớp.");
        }

        // Tạo một đối tượng User từ thông tin đăng ký
        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        // Các thông tin khác có thể được thiết lập tại đây, chẳng hạn như địa chỉ, vv.

        // Lưu đối tượng User mới vào cơ sở dữ liệu
        userRepository.save(newUser);

        // Sau khi đăng ký thành công, bạn có thể lưu thông tin người dùng vào session
        session.setAttribute("currentUser", newUser);
    }
}


