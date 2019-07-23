const formLogin = document.getElementById("formLogin");

formLogin.addEventListener('submit', function(evt){
    evt.preventDefault();
    const email = $("#email").val();
    const password = $("#password1").val();
    
    console.log(email, password);
    
    $.ajax({
		url: 'login',
		type: 'POST',
		data: {
			"email": email,
			"password": password
		},
		dataType: 'json',
		success: function (response) {
			const isLogin = response.isLogin;
			if(!isLogin) {
				alert("Usuario/Password incorrecto");
			} else {
				window.location="/orders";
			}
			
		}
	});
    
   
})