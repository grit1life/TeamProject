/*
 *modal내에서 검색,list표시시 사용 
 */
$(function(){
	/*
	 *modal표시 
	 * 
	 */
	//고객님 검색 modal 생성
	$('#customerModal').click(function(){	
		console.log('customerModal_click');
		__modalRquest('/customerModal', '고객님 검색','__customerModal');	
	});
	//한번 modal을 생성했으면 표시만 하면된다
	$(document).on('click', '#customerModal', function(){
		$('#__customerModal').modal('show');
	});
	/**** 상품 modal ******************************************************/
	var gModalMakeBtn = "#goodsModal";
	var gModalId = "__goodsModal";
	var gModalFormName = "form#goodsSerch";
	var gModalTableName = ".goodsModalTable";
	
	//상품 검색 modal 생성
	$(gModalMakeBtn).click(function(){	
		__modalRquest('/goodsSelectModal', '삼품 선택',gModalId);	
	});
	//한번 modal을 생성했으면 표시만 하면된다
	$(document).on('click', gModalMakeBtn, function(){
		$('#'+gModalId).modal('show');
	});
	//상품  검색Btn click시 table만 삭제하고 세로 table 생성
	$(document).on('click', '#goodsSerchBtn', function(){
		const formData = new FormData($("form#goodsSerch")[0]);
		$('.goodsModalTable').remove();
		//console.log(formData.get('branchCode'));
		__modalRquest2('/goodsListModal', formData, gModalFormName, gModalTableName);
	});
	/**** set modal ******************************************************/
	var setModalMakeBtn = "#setModal";
	var setModalId = "__setModal";
	var setModalFormName = "form#setSerch";
	var setModalTableName = ".setModalTable";
	
	//set 검색 modal 생성
	$(setModalMakeBtn).click(function(){	
		__modalRquest('/setSelectModal', '삼품 선택',setModalId);	
	});
	//한번 modal을 생성했으면 표시만 하면된다
	$(document).on('click', setModalMakeBtn, function(){
		$('#'+setModalId).modal('show');
	});
	//set  검색Btn click시 table만 삭제하고 세로 table 생성
	$(document).on('click', '#setSerchBtn', function(){
		const formData = new FormData($(setModalFormName)[0]);
		$('.setModalTable').remove();
		//console.log(formData.get('branchCode'));
		__modalRquest2('/setListModal', formData, setModalFormName, setModalTableName);
	});
	/**** 직원 modal ******************************************************/
	var sModalMakeBtn = "#staffModal";
	var sModalId = "__staffModal";
	var sModalTableName = ".staffModalTable";
	var sModalFormName = "form#staffSerch";
	
	//직원 검색 modal 생성
	$(sModalMakeBtn).click(function(){	
		__modalRquest('/staffSelectModal', '직원 선택',sModalId);	
	});
	//한번 modal을 생성했으면 표시만 하면된다
	$(document).on('click', sModalMakeBtn, function(){
		$('#'+sModalId).modal('show');
	});
	//staff  검색Btn click시 table만 삭제하고 세로 table 생성
	$(document).on('click', '#staffSerchBtn', function(){
		const formData = new FormData($(sModalFormName)[0]);
		//console.log(formData.get('branchCode'));
		__modalRquest2('/staffListModal', formData, sModalFormName, sModalTableName);
	});
	const __modalRquest = function(modalUrl ,title ,modalId){
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
	 * 	검색Btn click시 table만 삭제하고 세로 table 생성
	 * */
	const __modalRquest2 = function(modalUrl , param, formName, tableName){
		
		var request = $.ajax({
			  url: modalUrl,
			  method: "POST",
			  processData: false,
			  contentType: false,
			  data: param,
			  dataType: "html"
			});
		
		request.done(function( data ) {
			$(tableName).remove();
			let modalHtml = data;
			console.log(modalHtml);
			console.log($(formName));
			$(formName).append(modalHtml);
		});
		
		request.fail(function( jqXHR, textStatus ) {
			  alert( "Request failed: " + textStatus );
		});
	};

});