package com.simplilearn.phase4.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.phase4.project.common.FoodCategory;
import com.simplilearn.phase4.project.model.Fooditem;

@Repository
public interface FoodcourtRepository extends JpaRepository<Fooditem, Long> {
  public List<Fooditem> findByCategory(FoodCategory category);
  public Fooditem findByNameContaining (String name);

}
