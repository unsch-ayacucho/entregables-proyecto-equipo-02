$(window).load(function() {
	$("#flexiselDemo2").flexisel({
		visibleItems : 4,
		animationSpeed : 1000,
		autoPlay : true,
		autoPlaySpeed : 3000,
		pauseOnHover : true,
		enableResponsiveBreakpoints : true,
		responsiveBreakpoints : {
			portrait : {
				changePoint : 568,
				visibleItems : 1
			},
			landscape : {
				changePoint : 667,
				visibleItems : 2
			},
			tablet : {
				changePoint : 768,
				visibleItems : 3
			}
		}
	});

});