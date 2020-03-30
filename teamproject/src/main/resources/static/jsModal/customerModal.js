/*
 *modal내에서 검색,list표시시 사용 
 */
$(function(){
	/*
	 *modal표시 
	 */
	$('#customerModal').click(function(){	
		console.log('customerModal_click');
		__modalRquest('/customerModal', '고객님 검색','__customerModal');	
	});
	const __modalRquest = function(modalUrl ,title,modalId){
		var request = $.ajax({
			  url: modalUrl,
			  method: "GET",
			  dataType: "html"});

		request.done(function( data ) {
			
			let modalHtml = '';
			modalHtml += '<div class="modal fade" id="'+modalId+'">';
			modalHtml += '<div class="modal-dialog modal-xl">';
			modalHtml += '<div class="modal-content">';
			modalHtml += '<div class="modal-header">';
			modalHtml += '<h4 class="modal-title">'+ title +'</h4>';
			modalHtml += '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			modalHtml += '</div>';
			modalHtml += '<div class="modal-body">';
			modalHtml += data;
			modalHtml += '</div>';
			modalHtml += '<div class="modal-footer">';
			modalHtml += '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
			modalHtml += '</div>';
			modalHtml += '</div>';
			modalHtml += '</div>';
			modalHtml += '</div>';
			
			if($('#__showModal').length > 1){				
				$('#__showModal').remove();
			}
			
			$('body').append(modalHtml)
			
			//html 렌더링이 완료될때까지 대기
			setTimeout(function(){
				$('#'+modalId).modal('show');
			}, 50);
			
			//modal내 법인 개인 선택시
			$('.company').click(function(){
				console.log('company');
				$('.name').html('회사명');
				$('.name').next().attr('name','conpanyName');
				$('.tel').html('대표 전화번호');
				$('.tel').next().attr('name','customerCompanyCall');
				$('.email').next().attr('name','customerCompanyEmail');
				$('.staffDiv').css('display','block');
			});
			$('.person').click(function(){
				console.log('person'); 
				$('.name').html('이름')
				$('.name').next().attr('name','customerName');
				$('.tel').html('전화번호');
				$('.tel').next().attr('name','customerCall');
				$('.email').next().attr('name','customerEmail');
				$('.staffDiv').css('display','none');
			});
		});
		 
		request.fail(function( jqXHR, textStatus ) {
		  alert( "Request failed: " + textStatus );
		}); 
	};
	/*
	 *modal내에서 const formData = new FormData($("form#staffSerch")[0]);을
	 *보내고 html을 받을때 사용
	 */
	//검색Btn click시
	$(document).on('click', '#staffSerchBtn', function(){
		console.log("staffSerchBtn");
		
		if($('.company').prop('checked')){
			var customerName = $('input[name=customerName]').val();
			var customerCompanyCall = $('input[name=customerCompanyCall]').val();
			var customerCompanyEmail = $('input[name=customerCompanyEmail]').val();
		}else{
			var customerName = $('input[name=customerName]').val();
			var customerCall = $('input[name=customerCall]').val();
			var customerEmail = $('input[name=customerEmail]').val();
		}
		
		const formData = new FormData($("form#staffSerch")[0]);
		$('.modalTable').remove();
		console.log(formData.get('branchCode'));
		__modalRquest2('/modalStaffList', '모달타이틀', formData);
	});
	const __modalRquest2 = function(modalUrl ,title, param){
		
		var request = $.ajax({
			  url: modalUrl,
			  method: "POST",
			  processData: false,
			  contentType: false,
			  data: param,
			  dataType: "html"
			});
		
		request.done(function( data ) {
			$('.modalTable').remove();
			let modalHtml = data;
			$('form#staffSerch').append(modalHtml);
		});
		
		request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
		});
	};
	/**
	 * 		//modal에서 직원 선택시
		$(document).on('click', '#staffChoice', function(){
			console.log("staffChoice");
			console.log(this);
			var str = $(this).parents('tr');
			console.log(str+"<-str");
			$('#staff').remove();
			var staffChoiceHtml = '<div id="staff">'
				staffChoiceHtml += str.find('#branchName').text()+'<br>';
				staffChoiceHtml += str.find('#staffName').text()+'<br>';
				staffChoiceHtml += str.find('#staffTell').text()+'<br>';
				staffChoiceHtml += str.find('#staffEmail').text()+'<br>';
				staffChoiceHtml += '</div>';
			console.log(staffChoiceHtml+"<-staffChoiceHtml");
			$('label#staffChoice').after(staffChoiceHtml);
			$('#__staffModal').modal('hide');
		});
	 * **/
});