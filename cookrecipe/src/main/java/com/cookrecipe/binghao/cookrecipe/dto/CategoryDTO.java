package com.cookrecipe.binghao.cookrecipe.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToMany;

import com.cookrecipe.binghao.cookrecipe.entity.Recipe;


/**
 * @author Lim Bing Hao
 *
 */
public class CategoryDTO {
	/**
	 * Integer value of category id.
	 */
	private Integer cID;

	/**
	 * String value of category's title.
	 */
	private String categoryTitle;

	/**
	 * recipedtoList the recipes to set.
	 */
	private List<RecipeDTO> recipes;

	/**
	 * @return the cID
	 */
	public Integer getcID() {
		return cID;
	}

	/**
	 * @param cID the cID to set
	 */
	public void setcID(Integer cID) {
		this.cID = cID;
	}

	/**
	 * @return the categoryTitle
	 */
	public String getCategoryTitle() {
		return categoryTitle;
	}

	/**
	 * @param categoryTitle the categoryTitle to set
	 */
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	/**
	 * @return the recipes
	 */
	public List<RecipeDTO> getRecipes() {
		return recipes;
	}

	/**
	 * @param recipedtoList the recipes to set
	 */
	public void setRecipes(List<RecipeDTO> recipedtoList) {
		this.recipes = recipedtoList;
	}

}
