package com.cookrecipe.binghao.cookrecipe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the step database table.
 * @author Lim Bing Hao
 * 
 */
@Entity
@NamedQuery(name = "Step.findAll", query = "SELECT s FROM Step s")
public class Step implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * The integer value of recipe's step id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sID;

	/**
	 * The description of the cooking step of the recipe.
	 */
	@Column(name = "step_description")
	private String stepDescription;

	// bi-directional many-to-one association to Recipe
	/**
	 * The object of recipe.
	 */
	@ManyToOne
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;

	public Step() {
	}

	/**
	 * @return the value of step id.
	 */
	public Integer getSID() {
		return this.sID;
	}

	/**
	 * This method is use to set the step id for the created step of recipe.
	 * @param sID the sID to set.
	 */
	public void setSID(Integer sID) {
		this.sID = sID;
	}

	/**
	 * @return the description of the step.
	 */
	public String getStepDescription() {
		return this.stepDescription;
	}

	/**
	 * This method is use to set the description of created step of recipe.
	 * @param stepDescription the description of the step to set.
	 */
	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}

	/**
	 * @return the recipe.
	 */
	public Recipe getRecipe() {
		return this.recipe;
	}

	/**
	 * @param recipe the recipe to set.
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}