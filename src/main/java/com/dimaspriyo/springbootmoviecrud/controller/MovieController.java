package com.dimaspriyo.springbootmoviecrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dimaspriyo.springbootmoviecrud.model.Movie;
import com.dimaspriyo.springbootmoviecrud.repository.MovieRepository;

@Controller
@RequestMapping("")
public class MovieController {
	
	
	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("")
	public String index(Movie movie) {
		return "index";
	}
	
	@PostMapping("/insert")
	public String insert(@Valid Movie movie, BindingResult result, RedirectAttributes redirectAttributes) {
		
		System.out.println(movie.toString());

		if(result.hasErrors()) {
			return "index";
		}
		
		movieRepository.save(movie);
		redirectAttributes.addFlashAttribute("success","Success Insert " + movie.getName() + " Movie in the list");
		
		return "redirect:";
	}
}
