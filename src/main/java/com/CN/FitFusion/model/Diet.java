package com.CN.FitFusion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="diets")
public class Diet {
   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	String name;
	
	String description;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonBackReference
	User user;
}
