const formCheckout = document.getElementById("formCheckout");
formCheckout.addEventListener('submit', function(evt){
    evt.preventDefault();
    let email_login = $("#email_login").text();
    if(email_login !== "Sin sesión"){
    	
    	
    	
    	if(localStorage.getItem('productos') !== null){
    		let items_carrito = JSON.parse(localStorage.getItem('productos'));
    		
    		let items = `{
								"items_carrito" : [`;
				items_carrito.forEach(function(c,index) {
					if(items_carrito.length - 1 === index) {
						items += `{
							"id_producto" : ${c.id},
							"cantidad" : 1,
							"precio" : ${c.precio}
						}`;
					} else {
						items += `{
							"id_producto" : ${c.id},
							"cantidad" : 1,
							"precio" : ${c.precio}
						},`;
					}
				});
				
				items+=`
							]
							}`;
				
				
				var Json = JSON.parse(items);
				console.log(Json);
				
				
				$.ajax({
					type : "POST",
					contentType : 'application/json; charset=utf-8',
					dataType : 'json',
					url: 'cart/checkout',
					data : JSON.stringify(Json),
					success : function(response) {	
						let registrado = response.registrado;
						if(registrado) {
							alert("Se procedió a registrar su pedido satisfactoriamente!!")
							localStorage.clear();
							window.location="/orders";
						}
					}
				});
    		
    		
    	} else {
    		alert("No hay ningún producto en el carrito")
    	}
    	
    } else {
    	window.location="/account/register";
    }
});


	