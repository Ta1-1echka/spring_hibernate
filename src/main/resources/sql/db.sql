CREATE SCHEMA IF NOT EXISTS `user` DEFAULT CHARACTER SET utf8 ;
USE `user` ;

-- -----------------------------------------------------
-- Table `user`.`userinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user`.`userinfo` (
  `iduser` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `firstname` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `iduser_UNIQUE` (`iduser` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  INDEX `login_password` (`login` ASC, `password` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;