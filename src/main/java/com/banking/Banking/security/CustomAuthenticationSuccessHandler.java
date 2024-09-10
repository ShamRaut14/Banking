//package com.banking.Banking.security;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//
//import java.io.IOException;
//
//@Component
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException, ServletException {
//        String role = authentication.getAuthorities().iterator().next().getAuthority();
//        switch (role) {
//            case "ROLE_ADMIN":
//                response.sendRedirect("/dashboard");
//                break;
//            case "ROLE_SUB_ADMIN":
//                response.sendRedirect("/subadmin/home");
//                break;
//            case "ROLE_CUSTOMER":
//                response.sendRedirect("/customer/home");
//                break;
//            default:
//                response.sendRedirect("/login?error");
//                break;
//        }
//    }
//}
//
