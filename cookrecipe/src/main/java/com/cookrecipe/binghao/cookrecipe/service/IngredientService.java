package com.cookrecipe.binghao.cookrecipe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookrecipe.binghao.cookrecipe.dto.IngredientDTO;
import com.cookrecipe.binghao.cookrecipe.entity.Ingredient;
import com.cookrecipe.binghao.cookrecipe.repository.IngredientRepository;

/**
 * The class of ingredient services.
 * @author Lim Bing Hao
 *
 */
@Service
public class IngredientService {

	/**
	 * Autowired the ingredient repository from ingredientRepository.java
	 */
	@Autowired
	IngredientRepository ingredientRepository;

	/**
	 * This service is design to get all the ingredients of recipe from repository.
	 * ingredientList has been created to add all the ingredients from repository.
	 * and all of these ingredient will be pass into the ingredientdtoList for the use of 
	 * transfer data between software application subsystems.
	 * @return the ingredientdtoList.
	 */
	public List<IngredientDTO> getAllIngredients() {

		List<Ingredient> ingredientList = new ArrayList<>();
		ingredientRepository.findAll().forEach(ingredientList::add);

		List<IngredientDTO> ingredientdtoList = new ArrayList<>();
		for (Ingredient ingredient : ingredientList) {
			IngredientDTO ingredientdto = new IngredientDTO();

			ingredientdto.setiID(ingredient.getIID());
			ingredientdto.setIngredientName(ingredient.getIngredientName());

			ingredientdtoList.add(ingredientdto);
		}

		return ingredientdtoList;

	}

	/**
	 * This service is use to delete the ingredient inside repository
	 * based on the ingredient iid pass in from front end application by user.
	 * @param iid the parameter of deleteIngredient service.
	 */
	public void deleteIngredient(int iid) {
		ingredientRepository.delete(iid);
	}

}
