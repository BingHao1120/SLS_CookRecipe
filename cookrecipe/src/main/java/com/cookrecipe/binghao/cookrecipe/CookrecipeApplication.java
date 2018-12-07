package com.cookrecipe.binghao.cookrecipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Date: 6th December 2018
 * 
 * This is a application for user to create and manage their food recipe.
 * User allow to  create a new recipe under the category the chosen.\
 * They also allow to manage thier recipe by edit and delete it.
 * 
 * @author Lim Bing Hao
 * @version 1.0
 */
@SpringBootApplication
public class CookrecipeApplication {

	
	/**
	 * The main method of cookrecipe application.
	 * @param args array of string arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(CookrecipeApplication.class, args);
	}
}