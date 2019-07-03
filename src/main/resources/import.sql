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

INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (1,10,'Cocozhi','Cocozhi está formulado de la más fina cocoa con extracto de Ganoderma. Es un polvo listo para beberse, el cual te da un sabor a chocolate. Solo vierta el contenido en una taza de agua caliente y mueva para disfrutar una bebida vigorizante adecuada para toda la familia.','cocozhi.jpg','69.90',1);
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (2,9,'Vita Cafe','Vita Café es la más reciente bebida de café natural traída por DXN! Es una mezcla única de extracto de gran calidad de Ginseng y Tongkat Ali con polvo de extracto de Ganoderma.Vita Café DXN esta convenientemente preparado para su fácil consumo. Todo lo que necesitas es agregar polvo de Vita Café en una taza de agua caliente y experimentar el delicioso aroma de Vita Café.','vitacafe.jpg','89.90',1);
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (3,9,'Lingzhi Coffee','Café Negro Lingzhi DXN no tiene azúcar o aditivos, pero logra mantener un fuerte sabor y rico aroma del café. Está perfectamente diseñado para la Sociedad moderna. Café Negro Lingzhi También te ofrece el sabor satisfactorio del café real.','lingzhi-cafe.jpg','59.90',1);
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (4,12,'Spirulina','La Spirulina es bien conocida como un alimento balanceado mientras que los cereales ricos en fibras son usualmente recomendados por los especialistas en nutrición. El cereal de Spirulina DXN, esta echo de cereales de alta calidad y polvo de Spirulina que ofrece una de las mejores fuentes de nutrición.','spirulina_cereal.jpg','69.90',1);
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (5,9,'Zhi Mocha','Es una mezcla de polvo de café instantáneo elaborado de granos de café selectos, extracto de Ganoderma y cacao en polvo. Con el café en frappe siendo popular en estos días, puedes probar agregando algunos hielos a tu taza de Zhi Mocha. Definitivamente es una Buena elección para refrescarte en un día soleado de verano. Ya sea caliente o frio, Zhi Mocha tiene un sabor cremoso, dulce y único con un ligero sabor amargo después de probarlo','zhimocha.jpg','89.90',1);
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (6,9,'Tea Latte','Para brindarle la oportunidad a los amantes del Té la experiencia única del té latte, DXN ha introducido un totalmente nuevo Té Latte Lingzhi. Es una mezcla de polvo de té premium con crema no láctea y extracto de Ganoderma. Esta combinación ofrece un fuerte pero menos amargo sabor de té, el cual ha sido mejorado con la adición de deliciosa crema. Esta empacada convenientemente en sobres para tener una bebida suave y satisfactoria, amada por todos de cualquier estilo de vida, pero especialmente de aquellos que siempre están en movimiento.','tealatte.jpg','89.90',1);
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (7,11,'Cereal De Cordyceps','Disfruta de tu día con Cereal de Cordyceps DXN que contiene avena y trigo y adicionado con extracto de Cordyceps. Con un gran sabor a chocolate, el Cereal de Cordyceps es una excelente elección de fibra para todos que puede disfrutarse en cualquier momento, en cualquier lugar.','cereal.jpg','89.90',1);

INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (8,13,'Ganozhi','Formula especial enriquecida con extracto de Ganoderma y aceite de palma para limpiar suavemente y humectar su piel mientras preserva el aceite natural de su piel en un solo paso. Apropiado para todo tipo de piel.','soap.jpg','69.90',1);
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (9,14,'Shampoo Ganozhi','Un shampoo especial vigorizante que contiene extracto de Ganoderma y vitamina B5 que refrescara su cabello y se lo dejara suave y brilloso. Shampoo Ganozhi DXN con pH balanceado es apropiado para todo tipo de cabello.','shampoo.jpg','69.90',1);
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (10,14,'Gel De Baño Ganozhi','Consienta su cuerpo con la suave limpieza de un gel de baño que esta enriquecido con extracto de Ganoderma y que mientras se enjabona en la ducha te dejara en la piel una sensación de limpieza sin remover el aceite natural de la su piel.','bodyfoam.jpg','69.90',1);

INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (11,15,'Aloe.V Aqua Gel','Humectante especial que rápidamente absorbe, hidrata y humecta la piel, y contiene una mezcla de extracto de Aloe Vera. Deja la piel limpia, fresca y suave. Precauciones y advertencias: Aplicar sobre la piel según indicaciones evitando el área de los ojos.','aloe-aqua-gel.jpg','69.90',1);
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (12,16,'Aloe.V Crema De Manos Y Cuerpo','Una loción hidratante no grasa con extracto de Aloe Vera. Alivia resequedad y suaviza la piel, dando una sensación refrescante. Nutre y suaviza la piel para ayudar a mantener su humedad natural. Precauciones y advertencias: Aplicar sobre la piel según indicaciones evitando el área de los ojos.','bodyfoam.jpg','69.90',1);
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (13,16,'Aloe.V Crema Nutritiva','Una crema nocturna enriquecida con una mezcla especial de Aloe Vera y extractos botánicos, que actúa como una película protectora para reestablecer la perdida de humectación en la piel mientras duerme. Precauciones y advertencias: Aplicar sobre la piel según indicaciones evitando el área de los ojos.','aloe-ncare-cream.jpg','69.90',1);
INSERT INTO producto(id_producto,id_categoria,nombre,descripcion,url_imagen,precio,destacado) VALUES (14,15,'Aloe.V Gel Exfoliante Facial','Un exfoliante que le proporciona una gentil limpieza de poros profunda para remover células sin vida de la superficie y otras impurezas, dejando su piel viéndose suave, limpia y fresca. Formulada con extracto de Aloe Vera para lubricar y acondicionar su piel durante el proceso de limpieza para protegerla de los efectos de resequedad y dañinos. Contiene aceites esenciales de Olivo y Macadamia para aliviar su piel.','aloe-facial-scrub.jpg','69.90',1);

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