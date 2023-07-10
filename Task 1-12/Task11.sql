# 11.Создать новую таблицу “молодые животные” в которую попадут все
# животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
# до месяца подсчитать возраст животных в новой таблице

DROP TABLE IF EXISTS `all_animals`;

CREATE TEMPORARY TABLE `all_animals` AS 
SELECT *, 'Лошади' AS `name_animal` FROM `Horse`
UNION SELECT *, 'Ослы' AS `name_animal` FROM `Donkey`
UNION SELECT *, 'Собаки' AS `name_animal` FROM `Dog`
UNION SELECT *, 'Кошки' AS `name_animal` FROM `Cat`
UNION SELECT *, 'Хомяки' AS `name_animal` FROM `Hamster`;

SELECT * FROM `all_animals`;

DROP TABLE IF EXISTS `young_animal`;

CREATE TABLE `young_animal` AS
SELECT `nickname`, `birthday`, `commands`, `name_animal`, TIMESTAMPDIFF(MONTH, `birthday`, CURDATE()) AS `count_month`
FROM `all_animals` WHERE `birthday` BETWEEN ADDDATE(CURDATE(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);

SELECT * FROM `young_animal`;