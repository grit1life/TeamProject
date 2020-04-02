/*
 *modal내에서 검색,list표시시 사용 
 */
$(function(){
	/*
	 *modal표시 
	 * 
	 */
	
	$(document).on('click', '#staffModal', function(){
		$('#__staffModal').modal('show');
	});
	$('#staffModal').click(function(){	
		__modalRquest('/modalStaffList', '모달타이틀','__staffModal');	
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
		const formData = new FormData($("form#staffSerch")[0]);
		$('.staffModalTable').remove();
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