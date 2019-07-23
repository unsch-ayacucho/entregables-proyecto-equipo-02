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
				
				//const url_img = producto.url_imagen;
				//console.log("img: "+producto.url_imagen)
				
				let div_img = `<img src="/private/img/${producto.url_imagen}" class="img-responsive" />`;
				
				$("#img_product").html(div_img);
				
			} else {
				console.log("no existe el producto")
			}
			
			
		}
	});
}

