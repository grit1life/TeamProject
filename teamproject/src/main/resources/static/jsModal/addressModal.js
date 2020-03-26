/*
 *modal내에서 검색,list표시시 사용 
 */

function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }

$(function(){
	/*
	 *modal표시 
	 */
	$('#addressModal').click(function(){
		console.log('#addressModal');
		__modalRquest('/addressModal', '주소 입력','__addressModal');	
	});
	const __modalRquest = function(modalUrl ,title,modalId){
		var request = $.ajax({
			  url: modalUrl,
			  method: "GET",
			  dataType: "html"});

		request.done(function( data ) {
			
			let modalHtml = '';
			modalHtml += '<div class="modal fade" id="'+modalId+'">';
			modalHtml += '<div class="modal-dialog">';
			modalHtml += '<div class="modal-content">';
			modalHtml += '<div class="modal-header">';
			modalHtml += '<h4 class="modal-title">'+ title +'</h4>';
			modalHtml += '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			modalHtml += '</div>';
			modalHtml += '<div class="modal-body">';
			modalHtml += data;
			modalHtml += '</div>';
			modalHtml += '<div class="card-footer">';
			modalHtml += '<button type="submit" class="btn btn-info">확인</button>'
			modalHtml += '<button type="button" style="float:right" class="btn btn-default" data-dismiss="modal">Close</button>';
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