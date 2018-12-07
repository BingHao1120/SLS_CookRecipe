package com.cookrecipe.binghao.cookrecipe.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cookrecipe.binghao.cookrecipe.entity.Recipe;


/**
 * @author Lim Bing Hao
 *
 */
public class StepDTO {
	/**
	 * Integer value of recipe's step id.
	 */
	private Integer sID;

	/**
	 * Description of the step.
	 */
	private String stepDescription;

	/**
	 * Object of Recipe.
	 */
	private Recipe recipe;

	/**
	 * @return the sID
	 */
	public Integer getsID() {
		return sID;
	}

	/**
	 * This method is use to set the step id for the created step of recipe.
	 * @param sID the sID to set
	 */
	public void setsID(Integer sID) {
		this.sID = sID;
	}

	/**
	 * @return the stepDescription
	 */
	public String getStepDescription() {
		return stepDescription;
	}

	/**
	 * This method is use to set the description of created step of recipe.
	 * @param stepDescription the stepDescription to set
	 */
	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}

	/**
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * @param recipe the recipe to set
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
