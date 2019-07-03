//function verCategoria(id_producto, nombre, descripcion, precio, url_imagen) {
function verCategoria(id_producto) {	


	$.ajax({
		url: 'verCategoria',
		type: 'POST',
		data: {
			"id_producto": id_producto
		},
		dataType: 'json',
		success: function (response) {
			console.log(response)
			let encontrado = response.encontrado;
			let producto = response.producto;
			if(encontrado) {
				$("#nombre_producto").text(producto.nombre);
				$("#descripcion_producto").text(producto.descripcion);
				$("#categoria_producto").text(producto.categoria.nombre);
				
				
				
			} else {
				console.log("no existe el producto")
			}
			
			
		}
	});
}