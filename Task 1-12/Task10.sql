# 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
# питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

USE Human_friends;

DELETE FROM `PackAnimal`
WHERE `pack_name` = 'Верблюды';

SELECT * FROM `Camel`;

SELECT `nickname`, `birthday`, `commands`
FROM `Horse`
UNION 
SELECT `nickname`, `birthday`, `commands`
FROM `Donkey`;