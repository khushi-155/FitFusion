package com.CN.FitFusion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CN.FitFusion.model.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
	public List<Exercise> findByUserId(Long userId);
}
