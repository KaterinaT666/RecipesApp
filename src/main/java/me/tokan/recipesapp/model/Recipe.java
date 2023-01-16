package me.tokan.recipesapp.model;

import java.util.List;

public class Recipe {

	private int cookingTime;
	private String title;
	private List<Ingredient> ingredients;
	private List<String> steps;

	public Recipe() {
	}

	public Recipe(int cookingTime,
				  String title,
				  List<Ingredient> ingredients,
				  List<String> steps) {
		this.cookingTime = cookingTime;
		this.title = title;
		this.ingredients = ingredients;
		this.steps = steps;
	}

	public int getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}
}
