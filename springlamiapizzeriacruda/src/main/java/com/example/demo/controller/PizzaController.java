package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.example.demo.model.Pizza;
import com.example.demo.repo.Pizzarepo;



@Controller
@RequestMapping("/pizze")
public class PizzaController {
	@Autowired
	 Pizzarepo pizzarepo;
	
	@GetMapping
	public String index(Model model) {
		List<Pizza> listaPizze = pizzarepo.findAll();
		model.addAttribute("pizze", listaPizze);
		return "pizze";
	}
}
