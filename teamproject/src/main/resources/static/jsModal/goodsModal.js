/*
 *modal내에서 검색,list표시시 사용 
 */
$(function(){
	/*
	 *modal표시 
	 * 
	 */
	$('#goodsModal').click(function(){	
		__modalRquest('/modalGoodsList', '삼품 선택','__goodsModal');	
	});
	$('#setModal').click(function(){	
		__modalRquest('/modalSetList', '세트 선택','__setModal');	
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
});