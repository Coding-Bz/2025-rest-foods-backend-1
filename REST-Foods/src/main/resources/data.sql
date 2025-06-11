INSERT INTO menu (menu_id, name, price, category, dietary_requirements, allergies, description, chefs_choice)
VALUES
('3e4c7c0b-901e-4db4-aaca-54e33f8849c1', 'Pizza 1', 19, 'main', 'vegetarian', 'gluten', 'Prepared fresh every day.', TRUE),
('311c2933-bec0-4f0e-b700-20f33775dfa1', 'Salad 2', 14, 'starter', 'vegan', '', 'A delicious choice for everyone.', FALSE),
('34e9359b-fc82-4e91-a6f1-17a2d42048a9', 'Burger 3', 22, 'main', 'gluten-free', 'nuts', 'Classic and flavorful.', TRUE),
('74f4f308-5ebb-4799-818d-65d770294dde', 'Soup 4', 11, 'starter', 'lactose-free', '', 'Light and healthy.', FALSE),
('32ce3df4-6afe-4930-860b-479ca2573e10', 'Steak 5', 30, 'main', 'gluten-free', 'soy', 'Rich and spicy.', TRUE),
('27b7e537-e300-45c7-a183-b20e23b84bc3', 'Fish 6', 28, 'main', 'lactose-free', 'shellfish', 'Prepared fresh every day.', TRUE),
('adaab4bd-d152-49de-9120-065f39c03a69', 'Curry 7', 20, 'main', 'vegan', '', 'Classic and flavorful.', FALSE),
('b18fbc97-64d8-402c-8a76-a4da16c53852', 'Pizza 8', 21, 'main', 'vegetarian', 'dairy', 'Rich and spicy.', TRUE),
('39df7317-b22f-441e-8106-e38b8ba4df0f', 'Salad 9', 12, 'starter', 'vegan', '', 'Light and healthy.', FALSE),
('17c2c4a1-3e97-482a-85fe-726abdd0fcd6', 'Soup 10', 13, 'starter', 'gluten-free', '', 'A delicious choice for everyone.', FALSE),
('5f5689b7-c6f4-4c74-8a43-4ba90da1d8ee', 'Burger 11', 24, 'main', 'vegetarian', 'gluten', 'Prepared fresh every day.', TRUE),
('b8f165db-7211-4f96-85b5-b2504e03b580', 'Pizza 12', 18, 'main', 'lactose-free', '', 'Classic and flavorful.', TRUE),
('0667301c-46bb-4dc1-a1b0-a6ba61392541', 'Fish 13', 27, 'main', 'gluten-free', 'shellfish', 'Rich and spicy.', FALSE),
('b3b87cff-216d-4d10-a4c9-4f77dda7ebb3', 'Steak 14', 31, 'main', 'lactose-free', '', 'Prepared fresh every day.', TRUE),
('c72a12c1-2d2d-42df-bd95-4fed5756d13a', 'Curry 15', 19, 'main', 'vegan', '', 'Light and healthy.', FALSE),
('ad245a15-f334-4441-9347-b5f8af8894d7', 'Soup 16', 12, 'starter', 'gluten-free', 'dairy', 'A delicious choice for everyone.', FALSE),
('69af48ce-5340-46d4-9895-d30b70afd243', 'Burger 17', 22, 'main', 'vegetarian', '', 'Rich and spicy.', TRUE),
('b9a6d027-861e-44f9-bfd7-ee44350ac6e3', 'Pizza 18', 20, 'main', 'gluten-free', 'nuts', 'Classic and flavorful.', TRUE),
('8a823c4a-9e1c-4b55-ac4a-89ebcfadd401', 'Fish 19', 29, 'main', 'lactose-free', '', 'Prepared fresh every day.', TRUE),
('e6747663-02b7-4198-86a3-81b5230be7e9', 'Salad 20', 13, 'starter', 'vegan', '', 'Light and healthy.', FALSE)
ON CONFLICT (menu_id) DO NOTHING;;




INSERT INTO reservation (reservation_id, date, time, party_size, name)
VALUES
('7d12c438-95a2-428c-8d3d-03a275f80c38', '2025-06-12', '18:00', 2, 'Guest_1'),
('b80e87f9-fa0f-4a65-a5f9-6712acbfd31c', '2025-06-12', '19:00', 4, 'Guest_2'),
('790e9338-37d7-45d7-90bc-a6db91c056de', '2025-06-13', '17:30', 3, 'Guest_3'),
('74e79c60-9f9a-402c-ad8e-cc0643f43744', '2025-06-13', '20:00', 2, 'Guest_4'),
('1ff0fa0b-583f-43d2-88ca-9e7ced86cf71', '2025-06-14', '18:45', 5, 'Guest_5'),
('daf72788-56df-40a9-8f63-a64c119ec5ea', '2025-06-14', '19:15', 6, 'Guest_6'),
('6c479606-5470-4c6a-9516-1c233823679a', '2025-06-15', '18:00', 1, 'Guest_7'),
('2bbdb4b1-5e6d-4f2e-b12c-dcd339c37947', '2025-06-15', '20:30', 3, 'Guest_8'),
('b4895c70-00cb-4143-a210-24d4b5778a61', '2025-06-16', '19:00', 4, 'Guest_9'),
('4ea7e61a-74d0-43ef-ab2a-c5ca7559500d', '2025-06-16', '21:00', 2, 'Guest_10'),
('64a2d339-8eb7-49c4-8c65-04fc35d169bb', '2025-06-17', '18:15', 2, 'Guest_11'),
('f61ff441-af3a-4630-9e65-7e35421dc630', '2025-06-17', '19:45', 3, 'Guest_12'),
('c9e2f89e-d026-4f62-a9e1-465c6470791a', '2025-06-18', '18:30', 5, 'Guest_13'),
('118d3450-4971-461c-b686-f23d25bc3c56', '2025-06-18', '20:00', 6, 'Guest_14'),
('c85884dc-92bc-46c4-a6b1-e506207a5c59', '2025-06-19', '19:30', 2, 'Guest_15'),
('b450ad39-e3c5-4069-840d-fbd8cf138098', '2025-06-19', '21:15', 1, 'Guest_16'),
('7fb170e8-e25b-481c-b0c8-d697f28d96b7', '2025-06-20', '18:00', 4, 'Guest_17'),
('473e4ab9-a3ff-4603-afe8-f1018ffd7b8b', '2025-06-20', '20:30', 3, 'Guest_18'),
('2090c157-0cb3-47dc-a9a3-a2643b29d3a8', '2025-06-21', '19:00', 2, 'Guest_19'),
('1f306687-dee2-4d10-a883-a5466e903c0e', '2025-06-21', '21:00', 5, 'Guest_20'),
('f4f2fdf3-0113-4896-8072-47efec72b092', '2025-06-22', '18:30', 2, 'Guest_21'),
('349dbb97-fd02-4df1-b87a-26df8a4f24db', '2025-06-22', '19:15', 4, 'Guest_22'),
('2acf20de-a59f-4823-b470-c46165e3e4a2', '2025-06-23', '17:45', 3, 'Guest_23'),
('09881b89-dbc9-4960-a794-b028195a9723', '2025-06-23', '20:45', 2, 'Guest_24'),
('70f470b2-f2b5-4ddd-b7de-a4f7da2f2682', '2025-06-24', '19:30', 6, 'Guest_25'),
('5db15052-c4dd-421e-8488-5fe6594833d4', '2025-06-24', '21:30', 2, 'Guest_26'),
('f33a8c7a-592f-407f-9a61-44cfb34d916c', '2025-06-25', '18:30', 4, 'Guest_27'),
('9691921b-d11b-48ab-964f-64f178f8117d', '2025-06-25', '20:15', 3, 'Guest_28'),
('249f7263-503d-40a7-b2c3-dcb42f94b070', '2025-06-26', '19:00', 2, 'Guest_29'),
('6b3726fd-fba7-44e3-8fb5-2eb484692afe', '2025-06-26', '21:00', 1, 'Guest_30')
ON CONFLICT (reservation_id) DO NOTHING;;

