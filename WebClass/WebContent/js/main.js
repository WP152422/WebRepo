$(document).ready(function()
  	{
  		$('#loginForm').submit(function (event)
		{
  			event.preventDefault();
  			
			//id, pwd 값 가져오기
			var id = $("#id").val();
			var pwd = $("#pwd").val(); 
			console.log(id, pwd);
			
			$.post("http://httpbin.org/post", 
					{ id: id, pwd: pwd },
					function(data) 
					{
						var myModal = $('#alert');
						myModal.modal();
						myModal.find('.modal-body').text(data.form.id + '님 로그인 되었습니다.');
						
					});
			$('#login').modal("hide");
		})
  	}
);

$(function()
	  	{
	  		
	  	})

$(document).ready(function()
	  	{
	  		$('#signupForm').submit(function (event)
			{
	  			event.preventDefault();
	  			
	  			var name = $('#name').val();
	  			
	  			console.log(name);
				
				$.post("http://httpbin.org/post", 
						{ name: name },
						function(data) 
						{
							var myModal = $('#alert');
							myModal.modal();
							myModal.find('.modal-body').text(data.form.name + '님 회원가입 되었습니다.');
						});
				$('#sign_up').modal('hide');
			})
	  	}
	);

$(function()
	  	{
	  		
	  	})