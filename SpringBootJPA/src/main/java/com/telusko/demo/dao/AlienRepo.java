package com.telusko.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.telusko.demo.Model.Alien;

public interface AlienRepo extends CrudRepository<Alien,Integer>
{

	
	List<Alien> findByAid(int aid); 

	List<Alien> findByaname(String aname);
}

