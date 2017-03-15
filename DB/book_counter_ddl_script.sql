-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema books_counter
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `books_counter` ;

-- -----------------------------------------------------
-- Schema books_counter
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `books_counter` DEFAULT CHARACTER SET utf8 ;
USE `books_counter` ;

-- -----------------------------------------------------
-- Table `books_counter`.`book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `books_counter`.`book` ;

CREATE TABLE IF NOT EXISTS `books_counter`.`book` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `brief` VARCHAR(50) NULL DEFAULT NULL,
  `publish_year` INT(11) NOT NULL,
  `author` VARCHAR(255) NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 57
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `books_counter`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `books_counter`.`employee` ;

CREATE TABLE IF NOT EXISTS `books_counter`.`employee` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `date_of_birth` DATE NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `books_counter`.`employee_book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `books_counter`.`employee_book` ;

CREATE TABLE IF NOT EXISTS `books_counter`.`employee_book` (
  `book_id` INT(11) NOT NULL,
  `employee_id` INT(11) NOT NULL,
  `id` INT(11) NOT NULL,
  PRIMARY KEY (`book_id`, `employee_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_employeeb_employee_idx` (`employee_id` ASC),
  CONSTRAINT `fk_employeeb_book`
    FOREIGN KEY (`book_id`)
    REFERENCES `books_counter`.`book` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employeeb_employee`
    FOREIGN KEY (`employee_id`)
    REFERENCES `books_counter`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
