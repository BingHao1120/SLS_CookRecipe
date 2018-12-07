package com.cookrecipe.binghao.cookrecipe.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cookrecipe.binghao.cookrecipe.entity.Recipe;

/**
 * @author Lim Bing Hao
 * 
 */
public class IngredientDTO {
	/**
	 * Integer value of ingredient id.
	 */
	private Integer iID;

	/**
	 * String value of ingredient's.
	 */
	private String ingredientName;

	/**
	 * Object of Recipe.
	 */
	private Recipe recipe;

	/**
	 * @return the iID
	 */
	public Integer getiID() {
		return iID;
	}

	/**
	 * This method is use to set the id for the created recipe's ingredient.
	 * @param iID the iID to set
	 */
	public void setiID(Integer iID) {
		this.iID = iID;
	}

	/**
	 * @return the ingredientName
	 */
	public String getIngredientName() {
		return ingredientName;
	}

	/**
	 * This method is use to set the name of the created recipe's ingredient.
	 * @param ingredientName the ingredientName to set
	 */
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	/**
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * @param recipe the parameter of setRecipe method.
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}
