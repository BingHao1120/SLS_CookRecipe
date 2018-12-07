package com.cookrecipe.binghao.cookrecipe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cookrecipe.binghao.cookrecipe.entity.Category;

/**
 * central place to store and maintain the data of categories.
 * @author Lim Bing Hao
 *
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {


	/**
	 * This method is use to find the category based on the category title.
	 * @param categoryTitle the parameter of findByCategoryTitle function.
	 * @return the category title
	 */
	Category findByCategoryTitle(String categoryTitle);

}
