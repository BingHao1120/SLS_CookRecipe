package com.cookrecipe.binghao.cookrecipe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cookrecipe.binghao.cookrecipe.entity.Ingredient;


/**
 * central place to store and maintain the data of ingredients.
 * @author Lim Bing Hao
 *
 */
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

}
