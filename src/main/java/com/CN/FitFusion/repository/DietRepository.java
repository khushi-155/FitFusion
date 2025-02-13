package com.CN.FitFusion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CN.FitFusion.model.Diet;

@Repository
public interface DietRepository extends JpaRepository<Diet, Long>{
	public List<Diet> findByUserId(Long userId);

}
