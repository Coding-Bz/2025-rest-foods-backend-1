
INSERT INTO menu (menu_id, name, price, category, dietary_requirements, allergies, description, chefs_choice)
VALUES
(gen_random_uuid(), 'Pizza 1', 19, 'main', 'vegetarian', 'gluten', 'Prepared fresh every day.', TRUE),
(gen_random_uuid(), 'Salad 2', 14, 'starter', 'vegan', '', 'A delicious choice for everyone.', FALSE),
(gen_random_uuid(), 'Burger 3', 22, 'main', 'gluten-free', 'nuts', 'Classic and flavorful.', TRUE),
(gen_random_uuid(), 'Soup 4', 11, 'starter', 'lactose-free', '', 'Light and healthy.', FALSE),
(gen_random_uuid(), 'Steak 5', 30, 'main', 'gluten-free', 'soy', 'Rich and spicy.', TRUE),
(gen_random_uuid(), 'Fish 6', 28, 'main', 'lactose-free', 'shellfish', 'Prepared fresh every day.', TRUE),
(gen_random_uuid(), 'Curry 7', 20, 'main', 'vegan', '', 'Classic and flavorful.', FALSE),
(gen_random_uuid(), 'Pizza 8', 21, 'main', 'vegetarian', 'dairy', 'Rich and spicy.', TRUE),
(gen_random_uuid(), 'Salad 9', 12, 'starter', 'vegan', '', 'Light and healthy.', FALSE),
(gen_random_uuid(), 'Soup 10', 13, 'starter', 'gluten-free', '', 'A delicious choice for everyone.', FALSE),
(gen_random_uuid(), 'Burger 11', 24, 'main', 'vegetarian', 'gluten', 'Prepared fresh every day.', TRUE),
(gen_random_uuid(), 'Pizza 12', 18, 'main', 'lactose-free', '', 'Classic and flavorful.', TRUE),
(gen_random_uuid(), 'Fish 13', 27, 'main', 'gluten-free', 'shellfish', 'Rich and spicy.', FALSE),
(gen_random_uuid(), 'Steak 14', 31, 'main', 'lactose-free', '', 'Prepared fresh every day.', TRUE),
(gen_random_uuid(), 'Curry 15', 19, 'main', 'vegan', '', 'Light and healthy.', FALSE),
(gen_random_uuid(), 'Soup 16', 12, 'starter', 'gluten-free', 'dairy', 'A delicious choice for everyone.', FALSE),
(gen_random_uuid(), 'Burger 17', 22, 'main', 'vegetarian', '', 'Rich and spicy.', TRUE),
(gen_random_uuid(), 'Pizza 18', 20, 'main', 'gluten-free', 'nuts', 'Classic and flavorful.', TRUE),
(gen_random_uuid(), 'Fish 19', 29, 'main', 'lactose-free', '', 'Prepared fresh every day.', TRUE),
(gen_random_uuid(), 'Salad 20', 13, 'starter', 'vegan', '', 'Light and healthy.', FALSE);



INSERT INTO reservation (reservation_id, date, time, party_size, name)
VALUES
(gen_random_uuid(), '2025-06-12', '18:00', 2, 'Guest_1'),
(gen_random_uuid(), '2025-06-12', '19:00', 4, 'Guest_2'),
(gen_random_uuid(), '2025-06-13', '17:30', 3, 'Guest_3'),
(gen_random_uuid(), '2025-06-13', '20:00', 2, 'Guest_4'),
(gen_random_uuid(), '2025-06-14', '18:45', 5, 'Guest_5'),
(gen_random_uuid(), '2025-06-14', '19:15', 6, 'Guest_6'),
(gen_random_uuid(), '2025-06-15', '18:00', 1, 'Guest_7'),
(gen_random_uuid(), '2025-06-15', '20:30', 3, 'Guest_8'),
(gen_random_uuid(), '2025-06-16', '19:00', 4, 'Guest_9'),
(gen_random_uuid(), '2025-06-16', '21:00', 2, 'Guest_10'),
(gen_random_uuid(), '2025-06-17', '18:15', 2, 'Guest_11'),
(gen_random_uuid(), '2025-06-17', '19:45', 3, 'Guest_12'),
(gen_random_uuid(), '2025-06-18', '18:30', 5, 'Guest_13'),
(gen_random_uuid(), '2025-06-18', '20:00', 6, 'Guest_14'),
(gen_random_uuid(), '2025-06-19', '19:30', 2, 'Guest_15'),
(gen_random_uuid(), '2025-06-19', '21:15', 1, 'Guest_16'),
(gen_random_uuid(), '2025-06-20', '18:00', 4, 'Guest_17'),
(gen_random_uuid(), '2025-06-20', '20:30', 3, 'Guest_18'),
(gen_random_uuid(), '2025-06-21', '19:00', 2, 'Guest_19'),
(gen_random_uuid(), '2025-06-21', '21:00', 5, 'Guest_20'),
(gen_random_uuid(), '2025-06-22', '18:30', 2, 'Guest_21'),
(gen_random_uuid(), '2025-06-22', '19:15', 4, 'Guest_22'),
(gen_random_uuid(), '2025-06-23', '17:45', 3, 'Guest_23'),
(gen_random_uuid(), '2025-06-23', '20:45', 2, 'Guest_24'),
(gen_random_uuid(), '2025-06-24', '19:30', 6, 'Guest_25'),
(gen_random_uuid(), '2025-06-24', '21:30', 2, 'Guest_26'),
(gen_random_uuid(), '2025-06-25', '18:30', 4, 'Guest_27'),
(gen_random_uuid(), '2025-06-25', '20:15', 3, 'Guest_28'),
(gen_random_uuid(), '2025-06-26', '19:00', 2, 'Guest_29'),
(gen_random_uuid(), '2025-06-26', '21:00', 1, 'Guest_30');
COMMIT;