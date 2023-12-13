-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema restaurantreviewerdb
-- -----------------------------------------------------
CREATE USER 'restaurantreviewerdbuser' IDENTIFIED BY 'restaurantreviewerdbpassword';

GRANT ALL ON `restaurantreviewerdb`.* TO 'restaurantreviewerdbuser';
GRANT SELECT ON TABLE `restaurantreviewerdb`.* TO 'restaurantreviewerdbuser';
GRANT SELECT, INSERT, TRIGGER ON TABLE `restaurantreviewerdb`.* TO 'restaurantreviewerdbuser';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `restaurantreviewerdb`.* TO 'restaurantreviewerdbuser';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema restaurantreviewerdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema restaurantreviewerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `restaurantreviewerdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `restaurantreviewerdb` ;

-- -----------------------------------------------------
-- Table `restaurantreviewerdb`.`RESTAURANT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantreviewerdb`.`RESTAURANT` (
  `idRESTAURANT` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  `FIRST_DISH` varchar(45) NOT NULL,
  `FIRST_DISH_PRICE` decimal(5,2) NOT NULL,
  `SECOND_DISH` varchar(45) NOT NULL, 
  `SECOND_DISH_PRICE` decimal(5,2) NOT NULL,
  `THIRD_DISH` varchar(45) NOT NULL,
  `THIRD_DISH_PRICE` decimal(5,2) NOT NULL,  
  PRIMARY KEY (`idRESTAURANT`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

