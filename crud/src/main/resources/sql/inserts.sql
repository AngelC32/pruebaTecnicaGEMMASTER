-- Insertar Categorías
INSERT INTO categoria (nombre, descripcion) VALUES ('Electrónica', 'Productos electrónicos como teléfonos y computadoras');
INSERT INTO categoria (nombre, descripcion) VALUES ('Ropa', 'Ropa para hombres, mujeres y niños');
INSERT INTO categoria (nombre, descripcion) VALUES ('Alimentos', 'Comida enlatada, snacks y bebidas');
INSERT INTO categoria (nombre, descripcion) VALUES ('Muebles', 'Sillas, mesas y sofás para el hogar');

-- Insertar Productos
INSERT INTO producto (nombre, precio, stock,id_categoria) VALUES ('Smartphone', 599.99, 10, 1);  -- Electrónica
INSERT INTO producto (nombre, precio, stock,id_categoria) VALUES ('Laptop', 799.99, 20, 1);  -- Electrónica
INSERT INTO producto (nombre, precio, stock,id_categoria) VALUES ('Camiseta', 19.99, 30, 2);  -- Ropa
INSERT INTO producto (nombre, precio, stock,id_categoria) VALUES ('Jeans', 39.99, 40,2);  -- Ropa
INSERT INTO producto (nombre, precio, stock,id_categoria) VALUES ('Soda', 1.50, 20,3);  -- Alimentos
INSERT INTO producto (nombre, precio, stock,id_categoria) VALUES ('Galletas', 3.00, 3,3);  -- Alimentos
