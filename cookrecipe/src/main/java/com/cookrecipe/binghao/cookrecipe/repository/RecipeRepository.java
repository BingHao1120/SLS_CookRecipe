package com.cookrecipe.binghao.cookrecipe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cookrecipe.binghao.cookrecipe.entity.Recipe;


/**
 * central place to store and maintain the data of recipes.
 * @author Lim Bing Hao
 *
 */
@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer>{

	/**
	 * This method is use to find the recipe based on the recipe id.
	 * @param getrID the parameter of findByrID function.
	 * @return the recipe rID.
	 */
	Recipe findByrID(Integer getrID);



	

}
