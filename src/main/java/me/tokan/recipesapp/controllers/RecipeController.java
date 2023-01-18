package me.tokan.recipesapp.controllers;

import me.tokan.recipesapp.model.Recipe;
import me.tokan.recipesapp.service.RecipeService;
import me.tokan.recipesapp.service.ValidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

	private final RecipeService recipeService;
	private final ValidateService validateService;

	public RecipeController(RecipeService recipeService, ValidateService validateService) {
		this.recipeService = recipeService;
		this.validateService = validateService;

	}

	@PostMapping
	public ResponseEntity<Recipe> add(@RequestBody Recipe recipe){
		if (validateService.isNotValid(recipe)){
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(recipeService.add(recipe));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Recipe> get(@PathVariable long id){
		return ResponseEntity.of(Objects.requireNonNull(recipeService.get(id)));
	}

	@PutMapping ("/{id}")
	public ResponseEntity<Recipe> update(@PathVariable long id, @RequestBody Recipe recipe){
		if (validateService.isNotValid(recipe)){
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.of(recipeService.update(id, recipe));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Recipe> delete(@PathVariable long id){
		return ResponseEntity.of(recipeService.delete(id));
	}

	@GetMapping
	public Map<Long, Recipe> getAll(){
		return recipeService.getAll();
	}
}
