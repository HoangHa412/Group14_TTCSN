package com.example.btl_ttcsn_14.controller;

import com.example.btl_ttcsn_14.entity.TaiKhoan;
import com.example.btl_ttcsn_14.repository.TaiKhoanRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private TaiKhoanRepository repository;

	@GetMapping("")
	public String adminPage(@CookieValue(value = "username", required = false) String username,
							@CookieValue(value = "password", required = false) String password) {
		if (username != null && password != null ) {
			return "admin/index";
		}
		return "redirect:/admin/login";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "admin/logon";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username,
						@RequestParam String password,
						HttpServletResponse response,
						RedirectAttributes redirectAttributes) {
		Optional<TaiKhoan> taiKhoan = repository.findByUsernameAndPassword(username, password);
		if (taiKhoan.isPresent()) {
			Cookie usernameCookie = new Cookie("username", username);
			Cookie passwordCookie = new Cookie("password", password);

			int expiryTimeInSeconds = 60 * 60 * 2;
			usernameCookie.setMaxAge(expiryTimeInSeconds);
			passwordCookie.setMaxAge(expiryTimeInSeconds);

			usernameCookie.setHttpOnly(true);
			usernameCookie.setSecure(true);
			usernameCookie.setPath("/");
			passwordCookie.setHttpOnly(true);
			passwordCookie.setSecure(true);
			passwordCookie.setPath("/");

			response.addCookie(usernameCookie);
			response.addCookie(passwordCookie);

			return "redirect:/admin";
		}
		redirectAttributes.addFlashAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
		return "redirect:/admin/login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletResponse response) {
		Cookie usernameCookie = new Cookie("username", null);
		Cookie passwordCookie = new Cookie("password", null);

		usernameCookie.setMaxAge(0);
		passwordCookie.setMaxAge(0);

		usernameCookie.setPath("/");
		passwordCookie.setPath("/");

		response.addCookie(usernameCookie);
		response.addCookie(passwordCookie);

		return "redirect:/admin/login";
	}
}
