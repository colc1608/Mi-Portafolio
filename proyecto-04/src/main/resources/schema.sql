DROP TABLE IF EXISTS ciudad;
CREATE TABLE ciudad (
ciudad_id INT AUTO_INCREMENT  PRIMARY KEY,
ciudad_nombre VARCHAR(100) NOT NULL,
ciudad_codigo_postal INT NOT NULL
);