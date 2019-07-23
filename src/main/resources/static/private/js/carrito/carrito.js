
//variables
const carrito = document.getElementById('carrito');
const productos = document.getElementById('lista-productos');
const productos_destacados = document.getElementById('lista-productos-destacados');
const listaProductos = document.querySelector('#lista-carrito tbody');
const vaciarCarritoBtn = document.getElementById('vaciar-carrito');

//listeners
	cargarEventListeners();
	function cargarEventListeners(){
	//dispara cuando se presiona agregar carrito
	productos.addEventListener('click', comprarProducto);
	productos_destacados.addEventListener('click', addCartRelated);
	
	//cuando se elimina un producto
	
	carrito.addEventListener('click', eliminarProducto);
	
	//Vaciar Carrito
	vaciarCarritoBtn.addEventListener('click',vaciarCarrito);
	
	//Al cargar el documento, mostrar LocalStorage
	document.addEventListener('DOMContentLoaded', leerLocalStorage);
	
	}
;
//funciones
//funcion que añade el producto al carrito
	function comprarProducto(e){
		e.preventDefault();
//delegation para agregar-carrito
		if(e.target.classList.contains('agregar-carrito')){
		const producto = e.target.parentElement.parentElement.parentElement;
//enviamos el producto seleccionado para tomar sus datos
		leerDatosProducto(producto);
		
		}
	};
	
	function addCartRelated(e){
		e.preventDefault();

		if(e.target.classList.contains('agregar-carrito')){
			const producto = e.target.parentElement.parentElement.parentElement;
			leerDatosProducto(producto);
		
		}
	};
//lee datos del producto
	function leerDatosProducto(producto){
	const infoProducto = {
		imagen:producto.querySelector('img').src,
		nombre: producto.querySelector('h5').textContent,
		precio: producto.querySelector('.precio em').textContent,
		id: producto.querySelector('a').getAttribute('value')
		}
	//console.log(infoProducto);
	
	insertarCarrito(infoProducto);
	}

//muestar el curso seleccionado en el carrito
	function insertarCarrito(producto){
	const row = document.createElement('tr');
	row.innerHTML = `
		<td>
			<img src="${producto.imagen}" height="40" width="40">
		</td>
		<td>
			${producto.nombre}
		</td>
		<td>
			${producto.precio}
		</td>
		<td>
			<a href="#" type="button" class="borrar-producto btn btn-danger" value="${producto.id}">
			X</a>
		</td>
	`;
	listaProductos.appendChild(row);
	guardarProductoLocalStorage(producto);
	
	}
//Elimina el producto del carrito
	function eliminarProducto(e){
		e.preventDefault();
		
		//console.log('Eliminado');
		
		let producto;
		let	productoId;
		if(e.target.classList.contains('borrar-producto') ){
			e.target.parentElement.parentElement.remove();
			producto = e.target.parentElement.parentElement;
			productoId = producto.querySelector('a').getAttribute('value');
			//console.log(productoId);
		}
		
		eliminarProductoLocalStorage(productoId);
	}

//elimina los productos
	function vaciarCarrito(){
		//listaProductos.innerHTML = '';
		
		while(listaProductos.firstChild){
			listaProductos.removeChild(listaProductos.firstChild);
		}
		
		
		
		//Vaciar Local Storage
		vaciarLocalStorage();
		
		return false;
	}
	
	
	//almacena carrito a localStorage
	
	
	function guardarProductoLocalStorage(producto){
		let productos;
		//toma el valor de un arreglo con datos de LS o vacio
		productos = obtenerProductosLocalStorage();
		
		//el productos seleccionado se agrega al arreglo
		productos.push(producto);
		//console.log(productos);
		
		localStorage.setItem('productos', JSON.stringify(productos));
	}
	
	//comprueba que haya elementos el localStorage
	function obtenerProductosLocalStorage(){
		let productosLS;
		
		//comprobar si hay algo en el LocalStorage
		if(localStorage.getItem('productos') === null){
			productosLS = [];
		} else{
			productosLS = JSON.parse(localStorage.getItem('productos'));
		}
		return productosLS;
		
	}
		
	
	//imprime los productos de Local Storage en el carrito
	function leerLocalStorage(){
		let productosLS1;
		productosLS1 = obtenerProductosLocalStorage()
		//console.log(productosLS1);
		productosLS1.forEach(function(producto){
			//construir el template
			const row = document.createElement('tr');
			row.innerHTML = `
				<td>
					<img src="${producto.imagen}" height="40" width="40">
				</td>
				<td>
					${producto.nombre}
				</td>
				<td>
					${producto.precio}
				</td>
				<td>
					<a href="#" type="button" class="borrar-producto btn btn-danger" value="${producto.id}">
					X</a>
				</td>
			`;
			listaProductos.appendChild(row);
		});
		
	}
	
	//Eliminar el curso por el ID en Local Storage
	function eliminarProductoLocalStorage(producto){
		let productosLS;
		
		productosLS = obtenerProductosLocalStorage();
		productosLS.forEach(function(productoLS,index){
			if(productoLS.id === producto){
				productosLS.splice(index, 1);
			}
		});
		
		localStorage.setItem('productos', JSON.stringify(productosLS));
		console.log(productosLS);
	}
	
	//Elimina productos Local Storage
	
	function vaciarLocalStorage(){
		localStorage.clear();
	}