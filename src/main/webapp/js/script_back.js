$(window).on('load', function(){
	/*
	var equalHigh = $("#topMenu").height()+$("#contents").height()+$("#footMenu").height();
	$("#leftMenu").height(equalHigh);*/

	$(".list ul li a").click(function(){
	if( $(this).next().is("ul") ){
		if( $(this).hasClass("on") ){
			$(this).removeClass("on").next("ul").slideUp("fast");
		} else{
			$(this).parent().siblings().find("a").removeClass("on");
			$(this).parent().siblings().find("ul").slideUp("fast");
			$(this).addClass("on").next("ul").slideDown("fast");
		}
		return false;
	}
	});
});

$(document).ready(function() {
	// 팝업01 action 추가
	$(".more").click(function(){
		$('.layer_pop').bPopup({
			modalClose: false,
			opacity: 0.6,
			positionStyle: 'fixed' //'fixed' or 'absolute'
		});
	});

	$(".closeX").click(function(){
		$('.layer_pop').bPopup().close();
	});
});

