CREATE TABLE recipes (
    id int PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE recipe_steps (
	id int PRIMARY KEY,
	recipe_id int,
	text varchar(1000),
	order_no int,
	FOREIGN KEY recipe_id REFERENCES recipes(id)
);

CREATE TABLE ingredients (
	id int PRIMARY KEY,
	name varchar(255)
);

CREATE TABLE measurements (
	id int PRIMARY KEY,
	name varchar(255)
);

CREATE TABLE recipe_ingredients(
	recipe_id int,
	ingredient_id int,
	quantity int,
	measurement_id int,
	PRIMARY KEY (recipe_id, ingredient_id)
	FOREIGN KEY recipe_id REFERENCES recipes(id),
	FOREIGN KEY ingredient_id REFERENCES ingredients(id),
	FOREIGN KEY measurement_id REFERENCES measurements(id)
);