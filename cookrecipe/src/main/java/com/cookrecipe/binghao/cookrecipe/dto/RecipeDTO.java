package com.cookrecipe.binghao.cookrecipe.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.cookrecipe.binghao.cookrecipe.entity.Category;
import com.cookrecipe.binghao.cookrecipe.entity.Ingredient;
import com.cookrecipe.binghao.cookrecipe.entity.Step;

/**
 * @author Lim Bing Hao
 *
 */
public class RecipeDTO {
	/**
	 * Integer value of recipe id.
	 */
	private Integer rID;

	/**
	 * Value of cooking time needed
	 */
	private Integer cookTime;

	/**
	 * Description of recipe.
	 */
	private String description;

	/**
	 * Title of the recipe.
	 */
	private String recipeTitle;

	/**
	 * Title of recipe's category.
	 */
	private String categoryTitle;

	/**
	 * IngredientDTO list of Recipe's ingredients.
	 */
	private List<IngredientDTO> ingredients;

	/**
	 * StepDTO list of Recipe's steps.
	 */
	private List<StepDTO> steps;

	/**
	 * @return the categoryTitle
	 */
	public String getCategoryTitle() {
		return categoryTitle;
	}

	/**
	 * This method is to set the category title of recipe.
	 * @param categoryTitle the categoryTitle to set
	 */
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	/**
	 * @return the ingredients
	 */
	public List<IngredientDTO> getIngredients() {
		return ingredients;
	}

	/**
	 * This method is to set the ingredients include in the recipe.
	 * @param ingredientdtoList the ingredients to set
	 */
	public void setIngredients(List<IngredientDTO> ingredientdtoList) {
		this.ingredients = ingredientdtoList;
	}

	/**
	 * @return the steps
	 */
	public List<StepDTO> getSteps() {
		return steps;
	}


	/**
	 * This method is use to set the steps include in the recipe.
	 * @param stepdtoList the steps to set
	 */
	public void setSteps(List<StepDTO> stepdtoList) {
		this.steps = stepdtoList;
	}

	/**
	 * @return the rID
	 */
	public Integer getrID() {
		return rID;
	}

	/**
	 * This method is to set the id of created recipe.
	 * @param rID the rID to set
	 */
	public void setrID(Integer rID) {
		this.rID = rID;
	}

	/**
	 * @return the cookTime
	 */
	public Integer getCookTime() {
		return cookTime;
	}

	/**
	 * This is the method to set the cooking time needed for the recipe.
	 * @param cookTime the cookTime to set
	 */
	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}

	/**
	 * @return the description of recipe
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method is to set the description of the recipe.
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the recipeTitle
	 */
	public String getRecipeTitle() {
		return recipeTitle;
	}

	/**
	 * This method is to set the title of recipe.
	 * @param recipeTitle the recipeTitle to set
	 */
	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}

}
