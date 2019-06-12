--ejecutar la segunda linea para crear la base de datos en MySQL
--CREATE SCHEMA 'comerciodb' DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (1,'Alimentos y Bebidas',1,0);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (2,'Cuidado Personal',1,0);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (3,'Cuidado de la Piel',1,0);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (4,'Granos',1,1);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (5,'Cereal',1,1);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (6,'Higiene',1,2);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (7,'Manos',1,3);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (8,'Rostro',1,3);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (9,'Café',1,4);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (10,'Cacao',1,4);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (11,'Cereal',1,5);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (12,'Espirulina',1,5);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (13,'Jabón',1,6);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (14,'Shampoo',1,6);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (15,'Gel',1,7);
INSERT INTO categoria (id_categoria,nombre,estado,subcategoria) VALUES (16,'Crema',1,8);

INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio) VALUES (1,10,'cocozhi','Cocozhi está formulado de la más fina cocoa con extracto de Ganoderma.','href','69.90');
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio) VALUES (2,9,'vita cafe','Café Negro Lingzhi DXN no tiene azúcar o aditivos','href','89.90');
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio) VALUES (3,9,'Lingzhi Coffee','Cingzhi Coffee 3 en 1 es todo lo que necesitas para una taza completa de suave','href','59.90');

INSERT INTO cliente (id_cliente,nombre,apellido,telefono) VALUES (1,'juan','perez gutierrez','949376537');
INSERT INTO cliente (id_cliente,nombre,apellido,telefono) VALUES (2,'ruth','gonzalez illescas','988365245');
INSERT INTO cliente (id_cliente,nombre,apellido,telefono) VALUES (3,'pedro','jaime fernandez','988662233');
INSERT INTO cliente (id_cliente,nombre,apellido,telefono) VALUES (4,'jorge','luna tafur','922272540');
INSERT INTO cliente (id_cliente,nombre,apellido,telefono) VALUES (5,'andrea','reyes rondinel','944562302');

INSERT INTO usuario (id_usuario,id_cliente,username,password) VALUES (1,1,'juan','123');
INSERT INTO usuario (id_usuario,id_cliente,username,password) VALUES (2,2,'ruth','123');
INSERT INTO usuario (id_usuario,id_cliente,username,password) VALUES (3,3,'pedro','123');
INSERT INTO usuario (id_usuario,id_cliente,username,password) VALUES (4,4,'jorge','123');
INSERT INTO usuario (id_usuario,id_cliente,username,password) VALUES (5,5,'andrea','123');

INSERT INTO pedido(id_pedido,id_cliente) VALUES (1,1);
INSERT INTO pedido(id_pedido,id_cliente) VALUES (2,2);
INSERT INTO pedido(id_pedido,id_cliente) VALUES (3,3);
INSERT INTO pedido(id_pedido,id_cliente) VALUES (4,4);
INSERT INTO pedido(id_pedido,id_cliente) VALUES (5,5);

INSERT INTO detalle_pedido(id_detalle_pedido,id_pedido,id_producto,cantidad,fecha) VALUES (1,1,1,4,'2019-06-10');
INSERT INTO detalle_pedido(id_detalle_pedido,id_pedido,id_producto,cantidad,fecha) VALUES (2,2,3,2,'2019-06-15');