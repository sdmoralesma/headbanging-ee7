-- MySQL Workbench Forward Engineering
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema headbanging-db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `headbanging-db` ;

-- -----------------------------------------------------
-- Schema headbanging-db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `headbanging-db` DEFAULT CHARACTER SET latin1 ;
USE `headbanging-db` ;


-- -----------------------------------------------------
-- Table `headbanging-db`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`users` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`users` (
  `USERNAME` VARCHAR(50) NOT NULL,
  `user_type` VARCHAR(31) NULL DEFAULT NULL,
  `GROUP_NAME` VARCHAR(50) NOT NULL,
  `PASSWORD` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`USERNAME`),
  UNIQUE INDEX `USERNAME` (`USERNAME` ASC))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `headbanging-db`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`admin` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`admin` (
  `USERNAME` VARCHAR(50) NOT NULL,
  `DESCRIPTION` VARCHAR(100) NOT NULL,
  `NAME` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`USERNAME`),
  CONSTRAINT `FK_admin_USERNAME`
  FOREIGN KEY (`USERNAME`)
  REFERENCES `headbanging-db`.`users` (`USERNAME`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `headbanging-db`.`jury`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`jury` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`jury` (
  `USERNAME` VARCHAR(50) NOT NULL,
  `DESCRIPTION` VARCHAR(100) NOT NULL,
  `NAME` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`USERNAME`),
  CONSTRAINT `FK_jury_USERNAME`
  FOREIGN KEY (`USERNAME`)
  REFERENCES `headbanging-db`.`users` (`USERNAME`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `headbanging-db`.`participant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`participant` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`participant` (
  `USERNAME` VARCHAR(50) NOT NULL,
  `AGE` INT(11) NOT NULL,
  `COUNTRY` VARCHAR(50) NOT NULL,
  `GENDER` VARCHAR(50) NOT NULL,
  `IMAGE_URL` VARCHAR(100) NULL DEFAULT NULL,
  `NAME` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`USERNAME`),
  CONSTRAINT `FK_participant_USERNAME`
  FOREIGN KEY (`USERNAME`)
  REFERENCES `headbanging-db`.`users` (`USERNAME`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `headbanging-db`.`presentation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`presentation` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`presentation` (
  `id_presentation` INT(11) NOT NULL AUTO_INCREMENT,
  `hand_score` FLOAT NOT NULL,
  `head_score` FLOAT NOT NULL,
  `total_score` FLOAT NOT NULL,
  `username` VARCHAR(50) NOT NULL,
  `song` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`id_presentation`),
  UNIQUE INDEX `id_presentation` (`id_presentation` ASC),  
  INDEX `FK_presentation_username` (`username` ASC),  
  CONSTRAINT `FK_presentation_username`
  FOREIGN KEY (`username`)
  REFERENCES `headbanging-db`.`users` (`USERNAME`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `headbanging-db`.`score_matrix`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `headbanging-db`.`score_matrix` ;

CREATE TABLE IF NOT EXISTS `headbanging-db`.`score_matrix` (
  `id_score_matrix` INT(11) NOT NULL AUTO_INCREMENT,
  `HAND1` INT(11) NULL DEFAULT NULL,
  `HAND10` INT(11) NULL DEFAULT NULL,
  `HAND2` INT(11) NULL DEFAULT NULL,
  `HAND3` INT(11) NULL DEFAULT NULL,
  `HAND4` INT(11) NULL DEFAULT NULL,
  `HAND5` INT(11) NULL DEFAULT NULL,
  `HAND6` INT(11) NULL DEFAULT NULL,
  `HAND7` INT(11) NULL DEFAULT NULL,
  `HAND8` INT(11) NULL DEFAULT NULL,
  `HAND9` INT(11) NULL DEFAULT NULL,
  `HEAD1` INT(11) NULL DEFAULT NULL,
  `HEAD10` INT(11) NULL DEFAULT NULL,
  `HEAD2` INT(11) NULL DEFAULT NULL,
  `HEAD3` INT(11) NULL DEFAULT NULL,
  `HEAD4` INT(11) NULL DEFAULT NULL,
  `HEAD5` INT(11) NULL DEFAULT NULL,
  `HEAD6` INT(11) NULL DEFAULT NULL,
  `HEAD7` INT(11) NULL DEFAULT NULL,
  `HEAD8` INT(11) NULL DEFAULT NULL,
  `HEAD9` INT(11) NULL DEFAULT NULL,
  `total_score` FLOAT NULL DEFAULT NULL,
  `username` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_score_matrix`),
  INDEX `FK_score_matrix_username` (`username` ASC),
  CONSTRAINT `FK_score_matrix_username`
  FOREIGN KEY (`username`)
  REFERENCES `headbanging-db`.`users` (`USERNAME`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
