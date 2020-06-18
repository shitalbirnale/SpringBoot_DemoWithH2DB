package com.telusko.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.Model.Alien;
import com.telusko.demo.dao.AlienRepo;

@RestController
public class AlienController 
{
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		
		System.out.println("in home method");
		return "home.jsp";
	}
	
	@PostMapping("/alien")
	public Alien AddAlien(Alien alien )
	{
		repo.save(alien);
		
		
		return alien;
	}
	
/*	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid )
	{
		ModelAndView mv=new ModelAndView("ShowAlien.jsp");
		
		Alien alien=repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		
		System.out.println(repo.findByAid(1));
		
		System.out.println(repo.findByaname("ak"));
		
		
		
		return mv;
	}*/
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien>  getAlien(@PathVariable("aid") int aid)
	{
		System.out.println("in rest");
		
		return repo.findById(aid);
	}
	

}
