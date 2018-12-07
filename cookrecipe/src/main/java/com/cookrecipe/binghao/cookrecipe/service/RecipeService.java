package com.cookrecipe.binghao.cookrecipe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cookrecipe.binghao.cookrecipe.dto.IngredientDTO;
import com.cookrecipe.binghao.cookrecipe.dto.RecipeDTO;
import com.cookrecipe.binghao.cookrecipe.dto.StepDTO;
import com.cookrecipe.binghao.cookrecipe.entity.Category;
import com.cookrecipe.binghao.cookrecipe.entity.Ingredient;
import com.cookrecipe.binghao.cookrecipe.entity.Recipe;
import com.cookrecipe.binghao.cookrecipe.entity.Step;
import com.cookrecipe.binghao.cookrecipe.repository.CategoryRepository;
import com.cookrecipe.binghao.cookrecipe.repository.IngredientRepository;
import com.cookrecipe.binghao.cookrecipe.repository.RecipeRepository;
import com.cookrecipe.binghao.cookrecipe.repository.StepRepository;

/**
 * The class of recipe services.
 * @author Lim Bing Hao
 *
 */
@Service
public class RecipeService {

	/**
	 * Autowired the category repository from categoryRepository.java
	 */
	@Autowired
	CategoryRepository categoryRepository;

	/**
	 * Autowired the recipe repository from recipeRepository.java
	 */
	@Autowired
	RecipeRepository recipeRepository;

	/**
	 * Autowired the ingredient repository from ingredientRepository.java
	 */
	@Autowired
	IngredientRepository ingredientRepository;

	/**
	 * Autowired the step repository from stepRepository.java
	 */
	@Autowired
	StepRepository stepRepository;



	/**
	 * <p>This service is to get all the recipes
	 * and the all steps and ingredients under each recipe from repository.</p>
	 * <p>At first, all the steps and ingredients is get from the actual modules and put into the dtoList
	 * and add into recipedto.</p>
	 * <p>At last, all the recipedto will be put into the recipedtoList.</p>
	 * @return the recipedtoList.
	 */
	public List<RecipeDTO> getAllRecipes() {

		List<Recipe> recipeList = new ArrayList<>();
		recipeRepository.findAll().forEach(recipeList::add);

		List<RecipeDTO> recipedtoList = new ArrayList<>();
		for (Recipe recipe : recipeList) {
			RecipeDTO recipedto = new RecipeDTO();

			recipedto.setrID(recipe.getRID());
			recipedto.setRecipeTitle(recipe.getRecipeTitle());
			recipedto.setDescription(recipe.getDescription());
			recipedto.setCookTime(recipe.getCookTime());

			List<IngredientDTO> ingredientdtoList = new ArrayList<>();
			for (Ingredient ingredient : recipe.getIngredients()) {
				IngredientDTO ingredientdto = new IngredientDTO();

				ingredientdto.setiID(ingredient.getIID());
				ingredientdto.setIngredientName(ingredient.getIngredientName());

				ingredientdtoList.add(ingredientdto);
			}

			List<StepDTO> stepdtoList = new ArrayList<>();
			for (Step step : recipe.getSteps()) {
				StepDTO stepdto = new StepDTO();

				stepdto.setsID(step.getSID());
				stepdto.setStepDescription(step.getStepDescription());

				stepdtoList.add(stepdto);
			}
			recipedto.setIngredients(ingredientdtoList);
			recipedto.setSteps(stepdtoList);

			recipedtoList.add(recipedto);
		}

		return recipedtoList;

	}

	/**
	 * This method is use to add new Recipe into the repository when
	 * user create a new recipe and pass in from front end application.
	 * In this method, the service will get the value from the dtoList and set to the modules.
	 * And then the services will save the modules to the repository to store the data.
	 * @param recipedto the parameter of addRecipe service.
	 */
	@Transactional
	public void addRecipe(RecipeDTO recipedto) {

		Category categoryTitle = categoryRepository.findByCategoryTitle(recipedto.getCategoryTitle());
		Recipe recipe = new Recipe();

		recipe.setRID(recipedto.getrID());
		recipe.setRecipeTitle(recipedto.getRecipeTitle());
		recipe.setDescription(recipedto.getDescription());
		recipe.setCookTime(recipedto.getCookTime());

		List categoryList = new ArrayList<>();
		categoryList.add(categoryTitle);

		recipe.setCategories(categoryList);

		Recipe savedRecipe = recipeRepository.save(recipe);

		List ingredientList = new ArrayList<>();
		for (IngredientDTO ingredientdto : recipedto.getIngredients()) {
			Ingredient ingredient = new Ingredient();

			ingredient.setIID(ingredientdto.getiID());
			ingredient.setIngredientName(ingredientdto.getIngredientName());
			ingredient.setRecipe(savedRecipe);

			ingredientList.add(ingredient);

		}

		List stepList = new ArrayList<>();
		for (StepDTO stepdto : recipedto.getSteps()) {
			Step step = new Step();

			step.setSID(stepdto.getsID());
			step.setStepDescription(stepdto.getStepDescription());
			step.setRecipe(savedRecipe);

			stepList.add(step);

		}

		ingredientRepository.save(ingredientList);
		stepRepository.save(stepList);
	}

	/**
	 * This method is use to overwrite the data of Recipe inside repository when
	 * user update the recipe and pass in the data from front end application.
	 * @param recipedto the parameter of updateRecipe service.
	 */
	public void updateRecipe(RecipeDTO recipedto) {
		Recipe recipe = recipeRepository.findByrID(recipedto.getrID());
		Category categoryTitle = categoryRepository.findByCategoryTitle(recipedto.getCategoryTitle());
		recipe.setRecipeTitle(recipedto.getRecipeTitle());
		recipe.setDescription(recipedto.getDescription());
		recipe.setCookTime(recipedto.getCookTime());

		List categoryList = new ArrayList<>();
		categoryList.add(categoryTitle);

		recipe.setCategories(categoryList);

		Recipe savedRecipe = recipeRepository.save(recipe);

		List ingredientList = new ArrayList<>();
		for (IngredientDTO ingredientdto : recipedto.getIngredients()) {
			Ingredient ingredient = new Ingredient();

			ingredient.setIID(ingredientdto.getiID());
			ingredient.setIngredientName(ingredientdto.getIngredientName());
			ingredient.setRecipe(savedRecipe);

			ingredientList.add(ingredient);

		}

		List stepList = new ArrayList<>();
		for (StepDTO stepdto : recipedto.getSteps()) {
			Step step = new Step();

			step.setSID(stepdto.getsID());
			step.setStepDescription(stepdto.getStepDescription());
			step.setRecipe(savedRecipe);

			stepList.add(step);

		}

		// recipe.setIngredients(ingredientList);
		// recipe.setSteps(stepList);

		ingredientRepository.save(ingredientList);
		stepRepository.save(stepList);

	}

	/**
	 * This service is use to delete the recipe inside repository
	 * based on the recipe id pass in from front end application by user.
	 * @param id the parameter of deleteRecipe service.
	 */
	public void deleteRecipe(int id) {

		recipeRepository.delete(id);
	}

}
