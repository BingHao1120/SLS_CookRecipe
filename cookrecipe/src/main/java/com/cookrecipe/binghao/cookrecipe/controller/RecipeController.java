package com.cookrecipe.binghao.cookrecipe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cookrecipe.binghao.cookrecipe.dto.CategoryDTO;
import com.cookrecipe.binghao.cookrecipe.dto.RecipeDTO;
import com.cookrecipe.binghao.cookrecipe.entity.Category;
import com.cookrecipe.binghao.cookrecipe.entity.Recipe;
import com.cookrecipe.binghao.cookrecipe.service.CategoryService;
import com.cookrecipe.binghao.cookrecipe.service.IngredientService;
import com.cookrecipe.binghao.cookrecipe.service.RecipeService;
import com.cookrecipe.binghao.cookrecipe.service.StepService;

/**
 * 
 * This class is to create the controller to control the services of this application.
 * 
 * @author Lim Bing Hao
 * @version 1.0
 */
@RestController
@RequestMapping(path = "/cookrecipe")
public class RecipeController {

	/**
	 * Autowired the recipe services from recipeService.java
	 */
	@Autowired
	RecipeService recipeService;

	/**
	 * Autowired the category services from categoryService.java
	 */
	@Autowired
	CategoryService categoryService;

	/**
	 * Autowired the ingredient services from ingredientService.java
	 */
	@Autowired
	IngredientService ingredientService;

	/**
	 * Autowired the step services from stepService.java
	 */
	@Autowired
	StepService stepService;

	// return user in list
	/**
	 * This is the GET request to retreive all the Recipes inside the database when user send it.
	 * @return returning all the Recipes from repository.
	 */
	@GetMapping(path = "/recipe")
	public List<RecipeDTO> getAllRecipes() {
		return recipeService.getAllRecipes();
	}

	/**
	 * This is the GET request to retreive all the Categories and Recipes inside the database when user send it.
	 * @return returning all the Categories and Recipes inside from repository.
	 */
	@GetMapping(path = "/category")
	public List<CategoryDTO> getAllCatogory() {
		return categoryService.getAllCategory();
	}

	/**
	 * This is the request to allow user to create new Recipe in application.
	 * The data that user pass in will go to recipedto and then store into actual database.
	 * @param recipedto Data transfer objects of Recipe
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/recipe")
	public void addRecipe(@RequestBody RecipeDTO recipedto) {
		recipeService.addRecipe(recipedto);
	}

	/**
	 * This is the request to allow user to update the Recipe in application.
	 * The data that user overwrite the recipedto's data and then store into actual database.
	 * @param recipedto recipedto Data transfer objects of Recipe
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/recipe")
	public void updateRecipe(@RequestBody RecipeDTO recipedto) {
		recipeService.updateRecipe(recipedto);
	}

	/**
	 * This is the request to allow user to delete the Recipe in application.
	 * The id will be pass into the recipeService, 
	 * based on the recipe id, 
	 * the recipe which have same id in repository will be delete.
	 * @param id Recipe id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/recipe/{id}")
	public void deleteRecipe(@PathVariable("id") int id) {
		recipeService.deleteRecipe(id);
	}

	/**
	 * This is the request to allow user to delete the ingredients of recipe in application.
	 * The id will be pass into the ingredientService, 
	 * based on the ingredient id, 
	 * the ingredient which have same id in repository will be delete.
	 * @param iid Recipe's ingredient id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/recipe/ingredient/{iid}")
	public void deleteIngredient(@PathVariable("iid") int iid) {
		ingredientService.deleteIngredient(iid);
	}

	/**
	 * This is the request to allow user to delete the steps of recipe in application.
	 * The id will be pass into the stepService, 
	 * based on the step id, 
	 * the step which have same id in repository will be delete.
	 * @param sid Recipe's step id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/recipe/step/{sid}")
	public void deleteStep(@PathVariable("sid") int sid) {
		stepService.deleteStep(sid);
	}
}
