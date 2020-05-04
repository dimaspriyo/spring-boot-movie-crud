package com.dimaspriyo.springbootmoviecrud.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String index(Model model, Movie movie) {
		
		  System.out.println(movieRepository.findAll().toString());
		  model.addAttribute("movies",movieRepository.findAll()); 
		  return "index";
		  
		 

	}

	@PostMapping("/insert")
	public String insert(@Valid Movie movie, BindingResult result, RedirectAttributes redirectAttributes) {

		System.out.println(movie.toString());

		if (result.hasErrors()) {
			return "index";
		}

		movieRepository.save(movie);
		redirectAttributes.addFlashAttribute("success", "Success Insert " + movie.getName() + " Movie in the list");

		return "redirect:";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		
		 Optional<Movie> movie = movieRepository.findById(id);
		 if(Optional.empty() == null) {
			 System.out.println("movie not found");
			 redirectAttributes.addFlashAttribute("failed", "Movie  Not Found");
		 }else {
			 System.out.println("movie found");
			 redirectAttributes.addFlashAttribute("success", "Success Delete " + movie.get().getName());
			 movieRepository.deleteById(id);
		 }
		return "redirect:/";
		
		
	}
}
