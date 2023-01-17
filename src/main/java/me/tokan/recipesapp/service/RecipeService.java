package me.tokan.recipesapp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.tokan.recipesapp.model.Recipe;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service

public class RecipeService {

	private Map<Long, Recipe> recipes = new HashMap<>();
	private long idGenerator =1;

	final private FilesService filesService;

	public RecipeService(FilesService filesService) {
		this.filesService = filesService;
	}

	@PostConstruct
	private void init(){
		readFromFile();
	}


	public Recipe add(Recipe recipe){
		recipes.put(idGenerator ++, recipe);
		saveToFile();
		return recipe;
	}

	@Nullable
	public Optional<Recipe> get(long id){
		return Optional.ofNullable(recipes.get(id));
	}

	public Optional<Recipe> update(long id, Recipe recipe) {
		saveToFile();
		return Optional.ofNullable(recipes.replace(id, recipe));
	}

	public Optional<Recipe> delete(long id) {
		return Optional.ofNullable(recipes.remove(id));
	}

	public Map<Long, Recipe> getAll() {
		return new HashMap<>(recipes);
	}


	private void saveToFile(){
		try {
			String json = new ObjectMapper().writeValueAsString(recipes);
			filesService.saveToFile(json);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	private void readFromFile(){
		try {
			String json = filesService.readFromFile();
			recipes = new ObjectMapper().readValue(json, new TypeReference<HashMap<Long,Recipe>>() {
			});
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
