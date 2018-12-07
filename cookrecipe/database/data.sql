DROP DATABASE IF EXISTS recipeDb;
CREATE DATABASE recipeDb;

USE recipeDb;

DROP TABLE IF EXISTS recipe;
CREATE TABLE recipe (
rID int NOT NULL AUTO_INCREMENT,
recipe_title varchar(30),
description varchar(255),
cook_time int,

PRIMARY KEY(rID)
);

DROP TABLE IF EXISTS category;
CREATE TABLE category (
cID int NOT NULL AUTO_INCREMENT,
category_title varchar(20),

PRIMARY KEY(cID)
);

DROP TABLE IF EXISTS recipe_category;
CREATE TABLE recipe_category (
recipe_id int,
category_id int,

PRIMARY KEY (recipe_id, category_id)
);

DROP TABLE IF EXISTS step;
CREATE TABLE step (
sID int NOT NULL AUTO_INCREMENT,
step_number int,
step_description varchar(255),
recipe_id int,

PRIMARY KEY(sID)
);


DROP TABLE IF EXISTS ingredient;
CREATE TABLE ingredient (
iID int NOT NULL AUTO_INCREMENT,
ingredient_name varchar(255),
recipe_id int,

PRIMARY KEY(iID)
);


ALTER TABLE recipe_category
ADD FOREIGN KEY (recipe_id) REFERENCES recipe(rID),
ADD FOREIGN KEY (category_id) REFERENCES category(cID);

ALTER TABLE step
ADD FOREIGN KEY (recipe_id) REFERENCES recipe(rID);

ALTER TABLE ingredient
ADD FOREIGN KEY (recipe_id) REFERENCES recipe(rID);