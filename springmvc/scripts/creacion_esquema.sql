-- password is 'somePassword' hashed con http://www.nitrxgen.net/hashgen/ - Ojo que tal vez haya que agregar un '*' adelante
CREATE USER 'noroot'@'localhost' IDENTIFIED BY PASSWORD '*B04E11FAAAE9A5A019BAF695B40F3BF1997EB194'; 

CREATE SCHEMA IF NOT EXISTS `appschema`;

USE `appschema`;

DROP TABLE IF EXISTS `Something`;

CREATE TABLE `Something` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`id`)  );

CREATE TABLE `Avatar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `source` BLOB NOT NULL ,
  PRIMARY KEY (`id`)  );

  
GRANT ALL PRIVILEGES ON `appschema`.* TO 'noroot'@'localhost'
  IDENTIFIED BY PASSWORD '*B04E11FAAAE9A5A019BAF695B40F3BF1997EB194';
