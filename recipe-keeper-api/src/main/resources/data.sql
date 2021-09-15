CREATE TABLE IF NOT EXISTS recipes (
    id int PRIMARY KEY,
    name varchar(255)
);
CREATE TABLE IF NOT EXISTS recipe_steps (
	id int PRIMARY KEY,
	recipe_id int,
	text varchar(1000),
	order_no int,
	FOREIGN KEY (recipe_id) REFERENCES recipes(id)
);
CREATE TABLE IF NOT EXISTS ingredients (
	id int PRIMARY KEY,
	name varchar(255)
);
CREATE TABLE IF NOT EXISTS measurements (
	id int PRIMARY KEY,
	name varchar(255)
);
CREATE TABLE IF NOT EXISTS recipe_ingredients(
	recipe_id int,
	ingredient_id int,
	quantity int,
	measurement_id int,
	PRIMARY KEY (recipe_id, ingredient_id),
	FOREIGN KEY (recipe_id) REFERENCES recipes(id),
	FOREIGN KEY (ingredient_id) REFERENCES ingredients(id),
	FOREIGN KEY (measurement_id) REFERENCES measurements(id)
);

INSERT INTO recipes (id, name) VALUES
(1,'pizza'),
(2,'cake'),
(3,'spaghetti');

INSERT INTO ingredients(id, name) VALUES
(1,'cheese'),
(2,'flour'),
(3,'sugar'),
(4,'pepperoni');

INSERT INTO measurements(id, name) VALUES
(1, 'grams'),
(2, 'liters');

INSERT INTO recipe_steps(id, recipe_id, text, order_no) VALUES
(1, 1, 'mix the dough', 1),
(2, 1, 'form the pizza', 2),
(3, 1, 'put the sauce on the pizza',3),
(4, 2, 'make the cake',1);

INSERT INTO recipe_ingredients(recipe_id, ingredient_id, quantity, measurement_id) VALUES
(1, 1, 100, 1),
(1, 2, 500, 1),
(1, 4, 100, 1),
(2, 2, 300, 1),
(2, 3, 200, 1);