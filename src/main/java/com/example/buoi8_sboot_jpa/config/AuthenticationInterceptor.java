package com.example.buoi8_sboot_jpa.config;

import com.example.buoi8_sboot_jpa.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //lay thong tin nguoi dung tu trong session voi key currentUser
        User user = (User) request.getSession().getAttribute("currentUser");

        //neu currentUser khong ton tai hoac null thi baos loi 401: unauthorized hoawjc khong co quyen)
        if(user == null){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
              return false;
        }
        return true;
    }
}
