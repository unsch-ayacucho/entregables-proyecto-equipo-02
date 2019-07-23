function loadItemsCart(){
	 //= localStorage.getItem('productos');
	 let carrito = JSON.parse(localStorage.getItem('productos'));
	 let total = 0;
	 if(localStorage.getItem('productos') !== null){
		 if(carrito.length > 0){
				carrito.forEach(function(c) {

					total += parseFloat(c.precio);
					let trTable = `<tr>
						<td>
							<a href="#"> <img src="${c.imagen}" height="42" width="42">
							</a>
						</td>
						<td>
							<span>${c.nombre}</span>
						</td>
						<td>1</td>
						<td>${c.precio}</td>
						<td>0.00</td>
						<td>${c.precio}</td>
						<td><a href="#" onclick="removeItem(${c.id})"><i class="fa fa-trash-o"></i></a></td>
					</tr>`;
					$("#bodyCart").append(trTable);
					
					
					
				});
				
			 } else {
				 console.log("no hay productos en el carrito");
			 }
		 
		
	}
	 document.getElementById("total").textContent='S/. ' + total;
	 
	 /*******resumen******/
	 
	 let resumen = `<tbody>
											<tr>
												<td>Sub total</td>
												<th>S/ ${total}</th>
											</tr>
											<tr>
												<td>Envio</td>
												<th>S/ 0.00</th>
											</tr>
											<tr>
												<td>Impuestos</td>
												<th>S/ 0.00</th>
											</tr>
											<tr class="total">
												<td>Total</td>
												<th>S/ ${total}</th>
											</tr>
										</tbody>`;
	
	 $("#resumenBody").html(resumen);
	
	
	
	

//	console.log(carrito)
//	console.log("rsf")
}

function removeItem(id) {
	let carrito = JSON.parse(localStorage.getItem('productos'));
	carrito.forEach(function(c,index) {
		if(c.id === id.toString()){
			carrito.splice(index, 1);
		}
	});
	localStorage.setItem('productos', JSON.stringify(carrito));
	location.reload();
};
