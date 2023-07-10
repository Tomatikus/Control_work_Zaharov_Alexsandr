# 9. Заполнить низкоуровневые таблицы именами(животных), 
# командами которые они выполняют и датами рождения

USE Human_friends;

INSERT INTO `Dog` (`nickname`, `birthday`, `commands`, `id_for_dogs`) VALUES
('Пес1', '2021-03-07', "Список команд №1", 1),
('Пес2', '2022-06-11', "Список команд №2", 1),
('Пес3', '2020-05-03', "Список команд №3", 1);

SELECT * FROM `Dog`;

INSERT INTO `Cat` (`nickname`, `birthday`, `commands`, `id_for_cats`) VALUES 
('Кот1', '2022-06-07', "Список команд №1", 2),
('Кот2', '2021-02-03', "Список команд №2", 2),
('Кот3', '2020-03-05', "Список команд №3", 2); 

SELECT * FROM `Cat`;

INSERT INTO `Hamster` (`nickname`, `birthday`, `commands`, `id_for_hamsters`) VALUES 
('Хомяк1', '2021-10-10', NULL, 3),
('Хомяк2', '2020-02-12', NULL, 3),
('Хомяк3', '2021-08-12', NULL, 3);

SELECT * FROM `Hamster`;

INSERT INTO `Horse` (`nickname`, `birthday`, `commands`, `id_for_horses`) VALUES 
('Конь1', '2020-05-11', "Список команд №1", 1),
('Конь2', '2020-05-11', "Список команд №2", 1),
('Конь3', '2015-08-11', "Список команд №3", 1);

SELECT * FROM `Horse`;

INSERT INTO `Donkey` (`nickname`, `birthday`, `commands`, `id_for_donkeys`) VALUES 
('Осел1', '2021-04-10', NULL, 2),
('Осел2', '2019-08-11', NULL, 2),
('Осел3', '2020-07-10', NULL, 2);

SELECT * FROM `Donkey`;

INSERT INTO `Camel` (`nickname`, `birthday`, `commands`, `id_for_camels`) VALUES 
('Верблюд1', '2020-04-10', "Список команд №1", 3),
('Верблюд2', '2018-03-12', "Список команд №2", 3),
('Верблюд3', '2017-07-12', "Список команд №3", 3);

SELECT * FROM `Camel`;