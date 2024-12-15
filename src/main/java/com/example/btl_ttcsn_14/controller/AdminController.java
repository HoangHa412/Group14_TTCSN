package com.example.btl_ttcsn_14.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@GetMapping("/admin/")
	public String index() {
		return "redirect:/admin/";
	}

	@GetMapping("")
	public String adminPage(@CookieValue(value = "username", defaultValue = "") String username,
							@CookieValue(value = "password", defaultValue = "") String password
							) {
		// Kiểm tra thông tin đăng nhập
		if ("admin".equals(username) && "admin".equals(password)) {
			return "admin/index"; // Trả về trang quản trị
		}
		return "redirect:/admin/logon"; // Chuyển hướng đến trang đăng nhập
	}

	@GetMapping("/login")
    public String quanLySinhVien() {
        return "admin/logon";
    }

	@PostMapping("/login")
	public String login(@RequestParam String username,
						@RequestParam String password,
						HttpServletResponse response,
						RedirectAttributes redirectAttributes) {
		if ("admin".equals(username) && "admin".equals(password)) {
			// Tạo cookie với thời gian hết hạn
			Cookie usernameCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("password", password);

			// Đặt thời gian sống cho cookie (tính bằng giây)
			int expiryTimeInSeconds = 60 * 60 * 2; // 2 giờ
			usernameCookie.setMaxAge(expiryTimeInSeconds);
			passwordCookie.setMaxAge(expiryTimeInSeconds);

			// Đặt HttpOnly và đường dẫn cookie
			usernameCookie.setHttpOnly(true);
			passwordCookie.setHttpOnly(true);
			usernameCookie.setPath("/");
			passwordCookie.setPath("/");

			// Thêm cookie vào phản hồi
			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);

			return "redirect:/admin"; // Chuyển hướng đến trang quản trị
		}
		redirectAttributes.addAttribute("error", true);
		return "redirect:/admin/login"; // Chuyển hướng về trang đăng nhập
	}


}
