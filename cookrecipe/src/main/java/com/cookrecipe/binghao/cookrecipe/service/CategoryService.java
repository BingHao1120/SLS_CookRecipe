package com.cookrecipe.binghao.cookrecipe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookrecipe.binghao.cookrecipe.dto.CategoryDTO;
import com.cookrecipe.binghao.cookrecipe.dto.IngredientDTO;
import com.cookrecipe.binghao.cookrecipe.dto.RecipeDTO;
import com.cookrecipe.binghao.cookrecipe.dto.StepDTO;
import com.cookrecipe.binghao.cookrecipe.entity.Category;
import com.cookrecipe.binghao.cookrecipe.entity.Ingredient;
import com.cookrecipe.binghao.cookrecipe.entity.Recipe;
import com.cookrecipe.binghao.cookrecipe.entity.Step;
import com.cookrecipe.binghao.cookrecipe.repository.CategoryRepository;

/**
 * The class of category services.
 * @author Lim Bing Hao
 *
 */
@Service
public class CategoryService {
	/**
	 * Autowired the category repository from categoryRepository.java
	 */
	@Autowired
	CategoryRepository categoryRepository;

	/**
	 * <p>This service is to get all the categories
	 * and the all recipes under each categories from repository.</p>
	 * <p>At first, all the steps and ingredients is get from the actual modules and put into the dtoList
	 * and add into recipedto.</p>
	 * <P>And next, the each recipedto will be add into the recipedto list and finally add into the categorydto
	 * and put into categorydto list.</p>
	 * 
	 * @return the categorydto list.
	 */
	public List<CategoryDTO> getAllCategory() {

		List<Category> categoryList = new ArrayList<>();
		categoryRepository.findAll().forEach(categoryList::add);

		List<CategoryDTO> categorydtoList = new ArrayList<>();
		for (Category category : categoryList) {
			CategoryDTO categorydto = new CategoryDTO();

			categorydto.setcID(category.getCID());
			categorydto.setCategoryTitle(category.getCategoryTitle());

			List<RecipeDTO> recipedtoList = new ArrayList<>();
			for (Recipe recipe : category.getRecipes()) {
				RecipeDTO recipedto = new RecipeDTO();

				recipedto.setCategoryTitle(categorydto.getCategoryTitle());
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

			categorydto.setRecipes(recipedtoList);

			categorydtoList.add(categorydto);
		}

		return categorydtoList;
	}

}
