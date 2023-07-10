# 8. Создать таблицы с иерархией из диаграммы в БД

USE Human_friends;

DROP TABLE IF EXISTS `Animal`;

CREATE TABLE `Animal` (`animal_type_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                        `animal_type` VARCHAR (50)
						);

INSERT INTO `Animal` (`animal_type_id`, `animal_type`) VALUES 
(1 , 'Домашние'),
(2 , 'Вьючные');

SELECT * FROM `Animal`;

DROP TABLE IF EXISTS `PetAnimal`;

CREATE TABLE `PetAnimal` (`pet_animal_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
						  `pet_name` VARCHAR (50),
						  `type_pet_animal` INT UNSIGNED,
						   FOREIGN KEY (`type_pet_animal`) REFERENCES `Animal`(`animal_type_id`) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO `PetAnimal` (`pet_animal_id`, `pet_name`, `type_pet_animal`) VALUES 
(1, 'Собаки', 1),
(2, 'Кошки', 1),
(3, 'Хомяки', 1);

SELECT * FROM `PetAnimal`;

DROP TABLE IF EXISTS `PackAnimal`;

CREATE TABLE `PackAnimal` (`pack_animal_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
							`pack_name` VARCHAR (50),
                            `type_pack_animal` INT UNSIGNED,
                            FOREIGN KEY (`type_pack_animal`) REFERENCES `Animal`(`animal_type_id`) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO `PackAnimal` (`pack_animal_id`, `pack_name`, `type_pack_animal`) VALUES 
(1, 'Лошади', 2),
(2, 'Ослы', 2),
(3, 'Верблюды', 2);

SELECT * FROM `PackAnimal`;

CREATE TABLE `Dog` (`dog_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
					`nickname` VARCHAR(50),
					`birthday` DATE,
					`commands` VARCHAR(200),
					`id_for_dogs` INT UNSIGNED,
					FOREIGN KEY (`id_for_dogs`) REFERENCES `PetAnimal`(`pet_animal_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Cat` (`cat_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
					`nickname` VARCHAR(50),
					`birthday` DATE,
					`commands` VARCHAR(200),
					`id_for_cats` INT UNSIGNED,
					FOREIGN KEY (`id_for_cats`) REFERENCES `PetAnimal`(`pet_animal_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Hamster` (`hamster_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
						`nickname` VARCHAR(50),
						`birthday` DATE,
						`commands` VARCHAR(200),
						`id_for_hamsters` INT UNSIGNED,
						FOREIGN KEY (`id_for_hamsters`) REFERENCES `PetAnimal`(`pet_animal_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Horse` (`horse_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
					  `nickname` VARCHAR(50),
					  `birthday` DATE,
					  `commands` VARCHAR(200),
					  `id_for_horses` INT UNSIGNED,
					  FOREIGN KEY (`id_for_horses`) REFERENCES `PackAnimal`(`pack_animal_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Camel` (`camel_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
					  `nickname` VARCHAR(50),
					  `birthday` DATE,
					  `commands` VARCHAR(200),
					  `id_for_camels` INT UNSIGNED,
					  FOREIGN KEY (`id_for_camels`) REFERENCES `PackAnimal`(`pack_animal_id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `Donkey` (`donkey_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
					  `nickname` VARCHAR(50),
					  `birthday` DATE,
					  `commands` VARCHAR(200),
					  `id_for_donkeys` INT UNSIGNED,
					  FOREIGN KEY (`id_for_donkeys`) REFERENCES `PackAnimal`(`pack_animal_id`) ON DELETE CASCADE ON UPDATE CASCADE
);