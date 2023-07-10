# 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
# прошлую принадлежность к старым таблицам.

SELECT * FROM `horse`;
SELECT * FROM `young_animal`;
SELECT * FROM `PackAnimal`;

SELECT h.`nickname`, h.`birthday`, h.`commands`, pa.`pack_name`, ya.`count_month` AS `count_month_for_young_animal`
FROM `horse` AS h
LEFT JOIN `young_animal` AS ya ON ya.`nickname` = h.`nickname`
LEFT JOIN `PackAnimal` pa ON pa.`pack_animal_id` = h.`id_for_horses`
UNION
SELECT d.`nickname`, d.`birthday`, d.`commands`, pa.`pack_name`, ya.`count_month`
FROM `donkey` AS d
LEFT JOIN `young_animal` AS ya ON ya.`nickname` = d.`nickname`
LEFT JOIN `PackAnimal` pa ON pa.`pack_animal_id` = d.`id_for_donkeys`
UNION
SELECT c.`nickname`, c.`birthday`, c.`commands`, pe.`pet_name`, ya.`count_month`
FROM `cat` AS c
LEFT JOIN `young_animal` AS ya ON ya.`nickname` = c.`nickname`
LEFT JOIN `PetAnimal` pe ON pe.`pet_animal_id` = c.`id_for_cats`
UNION
SELECT dog.`nickname`, dog.`birthday`, dog.`commands`, pe.`pet_name`, ya.`count_month`
FROM `dog`
LEFT JOIN `young_animal` AS ya ON ya.`nickname` = dog.`nickname`
LEFT JOIN `PetAnimal` pe ON pe.`pet_animal_id` = dog.`id_for_dogs`
UNION
SELECT hamster.`nickname`, hamster.`birthday`, hamster.`commands`, pe.`pet_name`, ya.`count_month`
FROM `hamster`
LEFT JOIN `young_animal` AS ya ON ya.`nickname` = hamster.`nickname`
LEFT JOIN `PetAnimal` pe ON pe.`pet_animal_id` = hamster.`id_for_hamsters`;