-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema BLOCKFILEDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BLOCKFILEDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BLOCKFILEDB` DEFAULT CHARACTER SET latin1 ;
USE `BLOCKFILEDB` ;

-- -----------------------------------------------------
-- Table `BLOCKFILEDB`.`extensions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BLOCKFILEDB`.`extensions` ;

CREATE TABLE IF NOT EXISTS `BLOCKFILEDB`.`extensions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `extension` VARCHAR(20) NOT NULL,
  UNIQUE INDEX `extension_UNIQUE` (`extension` ASC) ,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
