package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("asd")
public class Sasd {

	@PostMapping("/asds")
	public String kar() {
		return "as";
	}
}
