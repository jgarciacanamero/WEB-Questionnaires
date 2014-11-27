USE practica8;

DROP TABLE IF EXISTS TEMAS;
CREATE TABLE TEMAS (
	Tema_id BIGINT NOT NULL AUTO_INCREMENT,
	Nombre VARCHAR(30) NOT NULL,
	PRIMARY KEY(`Tema_id`),
	UNIQUE KEY(`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET="UTF8";

DROP TABLE IF EXISTS NIVELES;
CREATE TABLE NIVELES (
	Nivel_id BIGINT NOT NULL AUTO_INCREMENT,
	Nombre VARCHAR(30) NOT NULL,
	PRIMARY KEY(`Nivel_id`),
	UNIQUE KEY(`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET="UTF8";

DROP TABLE IF EXISTS PREGUNTAS;
CREATE TABLE PREGUNTAS (
	Pregunta_id BIGINT NOT NULL AUTO_INCREMENT,
	Tema_id BIGINT NOT NULL,
	Nivel_id BIGINT NOT NULL,
	Texto TEXT NOT NULL,
	Correcta VARCHAR(100) NOT NULL,
	PRIMARY KEY(`Pregunta_id`),
	FOREIGN KEY(`Tema_id`) REFERENCES TEMAS (`Tema_id`),
	FOREIGN KEY(`Nivel_id`) REFERENCES NIVELES (`Nivel_id`)
) ENGINE InnoDB DEFAULT CHARSET="UTF8";

DROP TABLE IF EXISTS RESULTADOS;
CREATE TABLE RESULTADOS (
	Num_Correctas BIGINT NOT NULL,
	Nivel_id BIGINT NOT NULL,
	Resultado VARCHAR(100) NOT NULL,
	FOREIGN KEY(`Nivel_id`) REFERENCES NIVELES (`Nivel_id`)
) ENGINE=InnoDB DEFAULT CHARSET="UTF8";





-- Información básica

INSERT INTO TEMAS VALUES (NULL, 'Programación');
INSERT INTO TEMAS VALUES (NULL, 'Deportes');

INSERT INTO NIVELES VALUES (NULL, 'Fácil');
INSERT INTO NIVELES VALUES (NULL, 'Medio');
INSERT INTO NIVELES VALUES (NULL, 'Dificil');

-- Preguntas
INSERT INTO PREGUNTAS VALUES (NULL, 1, 1, 'Cual no es un lenguaje de programación java o tata?', 'tata');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 1, 'Cual es un IDE netbeans o petbeans?', 'petbeans');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 1, 'Java es un deporte o un lenguaje de programación ?', 'lenguaje de programación');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 1, 'Cual es un lenguaje de programación php o hph? ?', 'php');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 1, 'Cual es correcta, javin o java?', 'java');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 1, 'Que se estudia en el master java, java o jova?', 'java');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 1, 'De que color es el caballo blanco de Santiago?', 'blanco');

INSERT INTO PREGUNTAS VALUES (NULL, 1, 2, 'Java es multiplaforma o uniplataforma?', 'multiplataforma');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 2, 'Cual es tipo de dato entero, int o float?', 'int');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 2, 'Cual es una clase de entorno gŕafico swing o wingo ?', 'swing');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 2, 'Que es Tomcat un contenedor o un gato ?', 'contenedor');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 2, 'Cual es un lenguaje cobol o coboloco?', 'cobol');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 2, 'Cual es una edicion de java, j2ee o jjsantos?', 'j2ee');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 2, 'Donde se puede estudiar java en syncrom o syncram?', 'syncrom');

INSERT INTO PREGUNTAS VALUES (NULL, 1, 3, 'Qué lenguaje fue inventado antes C o C++?', 'C');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 3, 'Cuantos lenguajes diferentes hay 800 o 1150?', '1150');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 3, 'En que año apareció java 1995 o 1998 ?', '1995');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 3, 'En que año apareció php 2000 o 1995 ?', '1995');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 3, 'Que lenguaje salió antes cobol o basic?', 'cobol');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 3, 'Que apli de capa intermedia salió antes CGI o servlet?', 'CGI');
INSERT INTO PREGUNTAS VALUES (NULL, 1, 3, 'Quién es mi profesor de Java Antonio o Ramón?', 'Antonio');

INSERT INTO PREGUNTAS VALUES (NULL, 2, 1, 'Cual no es deporte futbol o parchis?', 'parchis');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 1, 'El futbol se juega con balon o raqueta?', 'balon');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 1, 'Al tenis se juega con raqueta o palo?', 'raqueta');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 1, 'Al basquet se juega con balon o pluma?', 'balon');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 1, 'Quién es piloto de F1 Alonso o Iniesta?', 'Alonso');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 1, 'Cual es un deporte basket o zapear?', 'basket');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 1, 'Quien jugó en el madrid Zidane o Cruyff?', 'Zidane');

INSERT INTO PREGUNTAS VALUES (NULL, 2, 2, 'Ultimo campeon del mundo de futbol fue Alemania o Brasil?', 'Alemania');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 2, 'De que color juega el ManU de rojo o verde?', 'rojo');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 2, 'Cuantos mundiales ha ganado Alonso 2 o 4?', '2');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 2, 'De que color es el caballo azul de Santigo?', 'azul');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 2, 'Quien juega en la nba, Gasol o Gafol?', 'Gasol');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 2, 'Quie fue presidente del barça, Floren o Nuñez?', 'Nuñez');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 2, 'Quién ha sido campeon de MotoGP, Lorenzo o Pedrosa?', 'Lorenzo');

INSERT INTO PREGUNTAS VALUES (NULL, 2, 3, 'Cuantos equipos juegan en la LFP 20 o 22?', '20');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 3, 'Numero de copas de europa del Valencia 1 o 0?', '0');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 3, 'Quién fue antes el huevo o la gallina?', 'huevo');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 3, 'Numero de ligas ganadas por el sevilla, 1 o 5?', '1');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 3, 'Pichichi de la liga 2013/2014, Messi o Cristiano?', 'Cristiano');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 3, 'Último campeón de la F1, Alonso o Vettel?', 'Vettel');
INSERT INTO PREGUNTAS VALUES (NULL, 2, 3, 'Último campeón MotoGP, Lorenzo o Marquez?', 'Marquez');

--Resultados
INSERT INTO RESULTADOS VALUES (0, 1, 'Nulos conocimientos');
INSERT INTO RESULTADOS VALUES (1, 1, 'Nulos conocimientos');
INSERT INTO RESULTADOS VALUES (2, 1, 'Muy bajos conocimientos');
INSERT INTO RESULTADOS VALUES (3, 1, 'Pocos conocimientos');
INSERT INTO RESULTADOS VALUES (4, 1, 'Conocimiento aceptable, pruebe dificultad media');
INSERT INTO RESULTADOS VALUES (5, 1, 'Parece que tiene buen conocimiento, pruebe dificultad media');
INSERT INTO RESULTADOS VALUES (0, 2, 'Muy bajos conocimientos');
INSERT INTO RESULTADOS VALUES (1, 2, 'Pocos conocimientos, pruebe nivel bajo');
INSERT INTO RESULTADOS VALUES (2, 2, 'Conocimiento aceptable');
INSERT INTO RESULTADOS VALUES (3, 2, 'Buen conocimiento');
INSERT INTO RESULTADOS VALUES (4, 2, 'Parece que tiene muchos conocimientos, pruebe nivel alto');
INSERT INTO RESULTADOS VALUES (5, 2, 'Excelente, pruebe nivel alto');
INSERT INTO RESULTADOS VALUES (0, 3, 'Mejor pruebe un nivel inferior');
INSERT INTO RESULTADOS VALUES (1, 3, 'Mejor pruebe un nivel inferior');
INSERT INTO RESULTADOS VALUES (2, 3, 'Tiene un conocimiento más que aceptable');
INSERT INTO RESULTADOS VALUES (3, 3, 'Muy buen conocimiento');
INSERT INTO RESULTADOS VALUES (4, 3, 'Excelente');
INSERT INTO RESULTADOS VALUES (5, 3, 'Es usted un experto');





-- Consultas demo
SELECT P.*, T.Nombre AS Tema, N.Nombre AS Nivel FROM PREGUNTAS P LEFT JOIN TEMAS T ON T.Tema_id=P.Tema_id LEFT JOIN NIVELES N ON N.Nivel_id=P.Nivel_id;
SELECT * FROM PREGUNTAS WHERE Tema_id=1 ORDER BY RAND() LIMIT 5;
SELECT * FROM PREGUNTAS WHERE Pregunta_id IN (5,3,4,7,2);

