package me.tokan.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Recipe {

	private int cookingTime;
	private String title;
	private List<Ingredient> ingredients;
	private List<String> steps;


}
