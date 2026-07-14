/* Creación de tablas */
CREATE TABLE clientes (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100)
);

CREATE TABLE pedidos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_cliente INT,
  total DECIMAL(10,2),
  FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);

-- Insertamos 3 clientes
INSERT INTO clientes (nombre) VALUES ('Juan'), ('Camilo'), ('Susana');

-- Insertamos 5 pedidos
INSERT INTO pedidos (id_cliente, total) VALUES
(1, 150.00),
(1, 80.00),
(2, 300.00),
(2, 50.00),
(3, 220.00);

SELECT * FROM clientes;
SELECT * FROM pedidos;

/* INNER JOIN y filtro */
SELECT clientes.nombre, pedidos.total
FROM clientes
INNER JOIN pedidos ON clientes.id = pedidos.id_cliente
WHERE pedidos.total > 100;

/* GROUP BY Y HAVING */
SELECT clientes.nombre, SUM(pedidos.total) AS total_gastado
FROM clientes
INNER JOIN pedidos ON clientes.id = pedidos.id_cliente
GROUP BY clientes.nombre
HAVING SUM(pedidos.total) > 200;

/* BONUS - Crear un indice */
CREATE INDEX idx_id_cliente ON pedidos(id_cliente);
