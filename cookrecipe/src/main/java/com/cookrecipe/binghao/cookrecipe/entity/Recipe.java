package com.cookrecipe.binghao.cookrecipe.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the recipe database table.
 * @author Lim Bing Hao
 * 
 */
@Entity
@NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r")
public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * The integer value of recipe id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rID;

	/**
	 * The integer value of the time needed in cooking for the recipe.
	 */
	@Column(name = "cook_time")
	private Integer cookTime;

	/**
	 * The description of recipe.
	 */
	private String description;

	/**
	 * The title of the recipe.
	 */
	@Column(name = "recipe_title")
	private String recipeTitle;

	// bi-directional many-to-one association to Ingredient
	/**
	 * The list of recipe's ingredients.
	 */
	@OneToMany(mappedBy = "recipe")
	private List<Ingredient> ingredients;

	// bi-directional many-to-many association to Category
	/**
	 * The list of recipe's categories.
	 */
	@ManyToMany
	@JoinTable(name = "recipe_category", joinColumns = { @JoinColumn(name = "recipe_id") }, inverseJoinColumns = {
			@JoinColumn(name = "category_id") })
	private List<Category> categories;

	// bi-directional many-to-one association to Step
	/**
	 * The list of recipe's steps.
	 */
	@OneToMany(mappedBy = "recipe")
	private List<Step> steps;

	public Recipe() {
	}

	/**
	 * return the recipe id of recipe
	 * @return the rID
	 */
	public Integer getRID() {
		return this.rID;
	}

	/**
	 * method to set the new id for recipe
	 * @param rID the rID to set
	 */
	public void setRID(Integer rID) {
		this.rID = rID;
	}

	/**
	 * return the time that needed for cook the dishes in mins
	 * @return the cookTime
	 */
	public Integer getCookTime() {
		return this.cookTime;
	}

	/**
	 * method to set the time that needed for cook the dishes in mins
	 * @param cookTime the cookTime to set
	 */
	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}

	/**
	 * return the description of recipe
	 * @return the description of recipe
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * method that set the description of recipe
	 * @param description this is parameter of description to setDescription method
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the recipeTitle
	 */
	public String getRecipeTitle() {
		return this.recipeTitle;
	}

	/**
	 * This method is useto set the title for the recipe.
	 * @param recipeTitle this is the parameter of recipeTitle to setRecipeTitle method
	 */
	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}

	/**
	 * @return the ingredients
	 */
	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	/**
	 * This method is to set ingredients include in the recipe to a ingredient lsit.
	 * @param ingredients the parameter of the ingredients list
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @param ingredient the ingredient that want to add into recipe.
	 * @return the ingredient of the recipe
	 */
	public Ingredient addIngredient(Ingredient ingredient) {
		getIngredients().add(ingredient);
		ingredient.setRecipe(this);

		return ingredient;
	}

	/**
	 * @param ingredient the ingredient that want to remove from recipe.
	 * @return the ingredient of recipe.
	 */
	public Ingredient removeIngredient(Ingredient ingredient) {
		getIngredients().remove(ingredient);
		ingredient.setRecipe(null);

		return ingredient;
	}

	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return this.categories;
	}

	/**
	 * This method is use to set the category of categories list.
	 * @param categories the parameter of the categories list.
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	/**
	 * @return the steps
	 */
	public List<Step> getSteps() {
		return this.steps;
	}

	/**
	 * @param steps the parameter of the steps list
	 */
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	/**
	 * @param step the step that want to add into recipe.
	 * @return the step
	 */
	public Step addStep(Step step) {
		getSteps().add(step);
		step.setRecipe(this);

		return step;
	}

	/**
	 * @param step the step that want to remove from recipe.
	 * @return the step
	 */
	public Step removeStep(Step step) {
		getSteps().remove(step);
		step.setRecipe(null);

		return step;
	}

}