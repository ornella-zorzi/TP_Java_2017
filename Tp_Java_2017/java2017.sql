# SQL Manager 2005 Lite for MySQL 3.7.0.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : java2017


SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `java2017`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

#
# Structure for the `categoria` table : 
#

CREATE TABLE `categoria` (
  `id_cat` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cat` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Structure for the `tipo_elemento` table : 
#

CREATE TABLE `tipo_elemento` (
  `id_te` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_te` varchar(20) DEFAULT NULL,
  `cant_reserva_max` int(11) DEFAULT NULL,
  `tiempo_limite` int(11) DEFAULT NULL,
  `dias_anticipacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_te`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Structure for the `elemento` table : 
#

CREATE TABLE `elemento` (
  `id_el` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_el` varchar(20) DEFAULT NULL,
  `id_te` int(11) NOT NULL,
  PRIMARY KEY (`id_el`,`id_te`),
  KEY `id_te` (`id_te`),
  KEY `id_el` (`id_el`),
  CONSTRAINT `elemento_fk` FOREIGN KEY (`id_te`) REFERENCES `tipo_elemento` (`id_te`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Structure for the `persona` table : 
#

CREATE TABLE `persona` (
  `id_per` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(8) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `contraseña` varchar(10) DEFAULT NULL,
  `habilitado` bit(1) DEFAULT NULL,
  `id_cat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_per`),
  UNIQUE KEY `usuario` (`usuario`),
  UNIQUE KEY `dni` (`dni`),
  KEY `id_cat` (`id_cat`),
  CONSTRAINT `persona_fk` FOREIGN KEY (`id_cat`) REFERENCES `categoria` (`id_cat`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

#
# Structure for the `reserva` table : 
#

CREATE TABLE `reserva` (
  `id_el` int(11) NOT NULL,
  `id_te` int(11) NOT NULL,
  `id_per` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` date NOT NULL,
  `detalle` varchar(20) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_el`,`id_te`,`id_per`,`fecha`,`hora`),
  KEY `id_el` (`id_el`),
  KEY `id_te` (`id_te`),
  KEY `id_per` (`id_per`),
  CONSTRAINT `reserva_fk` FOREIGN KEY (`id_el`) REFERENCES `elemento` (`id_el`),
  CONSTRAINT `reserva_fk1` FOREIGN KEY (`id_te`) REFERENCES `elemento` (`id_te`),
  CONSTRAINT `reserva_fk2` FOREIGN KEY (`id_per`) REFERENCES `persona` (`id_per`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for the `categoria` table  (LIMIT 0,500)
#

INSERT INTO `categoria` (`id_cat`, `nombre_cat`) VALUES 
  (1,'usuario');

COMMIT;

#
# Data for the `tipo_elemento` table  (LIMIT 0,500)
#

INSERT INTO `tipo_elemento` (`id_te`, `nombre_te`, `cant_reserva_max`, `tiempo_limite`, `dias_anticipacion`) VALUES 
  (1,'paraguas',6,4,5),
  (2,'perro',3,8,9),
  (3,'perro',2,3,3),
  (4,'silla',6,7,7);

COMMIT;

#
# Data for the `elemento` table  (LIMIT 0,500)
#

INSERT INTO `elemento` (`id_el`, `nombre_el`, `id_te`) VALUES 
  (1,'perro',1),
  (2,'verde',1),
  (3,'flor',1),
  (5,'mora',1);

COMMIT;

#
# Data for the `persona` table  (LIMIT 0,500)
#

INSERT INTO `persona` (`id_per`, `dni`, `nombre`, `apellido`, `email`, `usuario`, `contraseña`, `habilitado`, `id_cat`) VALUES 
  (26,'121212','hiuhui','huihuih','hiuhui','njkndkj','njnjknjk',True,1),
  (34,'37815875','julio','chapa','juliach','jchapa','jchapa',False,1),
  (37,'37815876','julia','chapa','juliach','jchaparro','jchapa',False,1),
  (41,'12345555','julieta','chaparro','julietach','ju','jchapa',True,1),
  (42,'12121212','Juan','Perez',NULL,NULL,NULL,True,NULL),
  (43,'13131313','Fulano','De Tal',NULL,NULL,NULL,False,NULL),
  (44,'13923622','hector','chaparro','hector-chapa@hotmail.com','hchaparro','hchaparro',True,1),
  (45,'121234','jonatan','perez','jperez','jperez','jperez',True,1),
  (46,'12345678','elsa','pato','elsapato@gmail.com','elsa','pato',True,1);

COMMIT;

