package com.simplilearn.phase4.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.phase4.project.common.FoodCategory;
import com.simplilearn.phase4.project.exception.ResourceNotFoundException;
import com.simplilearn.phase4.project.model.Fooditem;
import com.simplilearn.phase4.project.repository.FoodcourtRepository;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/v1/")
public class FoodItemController {
	
	@Autowired
	private FoodcourtRepository fooditemRepository;
	
	@GetMapping("/fooditems")
	public List<Fooditem> getAllFooditem(){
		return fooditemRepository.findAll();
		
	}
    
	@GetMapping("/fooditems/category/{category}")
	public List<Fooditem> getAllFooditem(@PathVariable FoodCategory category){
		List<Fooditem> footitemList = fooditemRepository.findByCategory(category);
		if (footitemList==null || footitemList.isEmpty())
			throw new ResourceNotFoundException("Food item does not exsist with category " +category.name());
		return footitemList;
		
	}
	
	@GetMapping("/fooditems/{id}")
	public Optional<Fooditem> getFoodItemById(@PathVariable long id){
		Optional<Fooditem> footitem = fooditemRepository.findById(id);
		if (footitem==null)
			throw new ResourceNotFoundException("Food item does not exsist with id " +id);
		return footitem;
		
	}
	
	@GetMapping("/fooditems/search/{name}")
	public Fooditem getFoodItemById(@PathVariable String name){
		Fooditem footitem =  fooditemRepository.findByNameContaining(name);;
		if (footitem==null)
			throw new ResourceNotFoundException("Food item does not exsist with id " +name);
		return footitem;
		
	}

}
