package com.cookrecipe.binghao.cookrecipe.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ingredient database table.
 * @author Lim Bing Hao
 * 
 */
@Entity
@NamedQuery(name = "Ingredient.findAll", query = "SELECT i FROM Ingredient i")
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * The integer value of ingredient id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iID;

	/**
	 * The name of ingredient.
	 */
	@Column(name = "ingredient_name")
	private String ingredientName;

	// bi-directional many-to-one association to Recipe
	/**
	 * The recipe object.
	 */
	@ManyToOne
	@JoinColumn(name = "recipe_id")
	private Recipe recipe;

	public Ingredient() {
	}

	/**
	 * @return the iID
	 */
	public Integer getIID() {
		return this.iID;
	}

	/**
	 * This method is to set the id for created ingredient.
	 * @param iID The parameter of set ingredient id method.
	 */
	public void setIID(Integer iID) {
		this.iID = iID;
	}

	/**
	 * @return the ingredientName
	 */
	public String getIngredientName() {
		return this.ingredientName;
	}

	/**
	 * This method is use to set the ingredient name of ingredient.
	 * @param ingredientName The parameter of set ingredient name method.
	 */
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	/**
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		return this.recipe;
	}

	/**
	 * This method is use to set the recipe.
	 * @param recipe The parameter of setRecipe method.
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}