package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.example.demo.model.Pizza;
import com.example.demo.repo.Pizzarepo;



@Controller
@RequestMapping("/")
public class PizzaController {
	@Autowired
	 Pizzarepo pizzarepo;
	
	@GetMapping
	public String index(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
		List<Pizza> listaPizze;
		
		
		if(keyword == null) {
			listaPizze = pizzarepo.findAll();
		}else {
			listaPizze = pizzarepo.findByNameLike("%"+keyword+"%"); 
		}
		model.addAttribute("pizze", listaPizze);
		return "pizze";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable("id") Integer id,Model model) {
		Pizza pizza = pizzarepo.getReferenceById(id);
		model.addAttribute("pizza", pizza);
		return "details";
	}
}
