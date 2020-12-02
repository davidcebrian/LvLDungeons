-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_LvLDungeons
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `db_LvLDungeons` ;

-- -----------------------------------------------------
-- Schema db_LvLDungeons
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_LvLDungeons` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `db_LvLDungeons` ;

-- -----------------------------------------------------
-- Table `db_LvLDungeons`.`new_table`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_LvLDungeons`.`new_table` ;

CREATE TABLE IF NOT EXISTS `db_LvLDungeons`.`new_table` (
  `idnew_table` INT NOT NULL,
  PRIMARY KEY (`idnew_table`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- ----------------------------------------------------
-- USERS 
-- ----------------------------------------------------
DROP USER IF EXISTS 'david';
CREATE USER 'david'@'%' IDENTIFIED BY 'password';
GRANT ALL ON db_LvLDungeons.* TO 'david'@'%';

DROP USER IF EXISTS'ruben';
CREATE USER 'ruben'@'%' IDENTIFIED BY 'password';
GRANT ALL ON db_LvLDungeons.* TO 'ruben'@'%';

DROP USER IF EXISTS 'abraham';
CREATE USER 'abraham'@'%' IDENTIFIED BY 'password';
GRANT ALL ON db_LvLDungeons.* TO 'abraham'@'%';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
