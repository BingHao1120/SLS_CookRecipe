INSERT INTO `recipedb`.`category` (`cID`, `category_title`) VALUES ('1', 'Main Dishes');

INSERT INTO `recipedb`.`category` (`cID`, `category_title`) VALUES ('2', 'Deserts');

INSERT INTO `recipedb`.`category` (`cID`, `category_title`) VALUES ('3', 'Drinks');

INSERT INTO `recipedb`.`category` (`cID`, `category_title`) VALUES ('4', 'Soups');


ALTER TABLE `recipedb`.`step` 
DROP FOREIGN KEY `step_ibfk_1`;

ALTER TABLE `recipedb`.`step` 
ADD CONSTRAINT `step_ibfk_1`
  FOREIGN KEY (`recipe_id`)
  REFERENCES `recipedb`.`recipe` (`rID`)
  ON DELETE CASCADE;

ALTER TABLE `recipedb`.`ingredient` 
DROP FOREIGN KEY `ingredient_ibfk_1`;

ALTER TABLE `recipedb`.`ingredient` 
ADD CONSTRAINT `ingredient_ibfk_1`
  FOREIGN KEY (`recipe_id`)
  REFERENCES `recipedb`.`recipe` (`rID`)
  ON DELETE CASCADE;


ALTER TABLE `recipedb`.`recipe_category` 
DROP FOREIGN KEY `recipe_category_ibfk_1`,
DROP FOREIGN KEY `recipe_category_ibfk_2`;

ALTER TABLE `recipedb`.`recipe_category` 
ADD CONSTRAINT `recipe_category_ibfk_1`
  FOREIGN KEY (`recipe_id`)
  REFERENCES `recipedb`.`recipe` (`rID`)
  ON DELETE CASCADE,
ADD CONSTRAINT `recipe_category_ibfk_2`
  FOREIGN KEY (`category_id`)
  REFERENCES `recipedb`.`category` (`cID`)
  ON DELETE CASCADE;


