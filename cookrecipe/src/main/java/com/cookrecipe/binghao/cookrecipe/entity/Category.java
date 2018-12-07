package com.cookrecipe.binghao.cookrecipe.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * @author Lim Bing Hao
 *
 */
@Entity
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * The integer value of category's id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cID;

	/**
	 * The title of category.
	 */
	@Column(name = "category_title")
	private String categoryTitle;

	// bi-directional many-to-many association to Recipe
	/**
	 * The List of Recipe object.
	 */
	@ManyToMany(mappedBy = "categories")
	private List<Recipe> recipes;

	public Category() {
	}

	/**
	 * 
	 * @return the category id
	 */
	public Integer getCID() {
		return this.cID;
	}

	/**
	 * This method is use to set the id for each Category
	 * @param cID the Category id to set
	 */
	public void setCID(Integer cID) {
		this.cID = cID;
	}

	/**
	 * 
	 * @return the categoryTitle
	 */
	public String getCategoryTitle() {
		return this.categoryTitle;
	}

	/**
	 * This method is use to set the category title for each category
	 * @param categoryTitle the categoryTitle to set
	 */
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	/**
	 * 
	 * @return the recipes
	 */
	public List<Recipe> getRecipes() {
		return this.recipes;
	}

	/**
	 * This method is use to set the recipes
	 * @param recipes the recipes to set
	 */
	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

}