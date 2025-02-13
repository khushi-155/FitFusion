package com.CN.FitFusion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExerciseDto {
   String name;
   String description;
   int sets;
   int reps;
}
