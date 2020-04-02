//고객 검색bottun click시 list 표시
$('#customerSerchBtn').click(function(){
	$('#customerList').css('display','block');
});
//고객을 선택시 검색창,list 비표시
$('#customerChoice').click(function(){
	$('#coustomerClose').click();
});

$(function(){
	//customer(개인) 선택시
	$(document).on('click', '#customerChoice', function(){
		console.log("customerChoice");
		console.log(this+"<-customerChoice");
		var ctr = $(this).parents('tr');
		console.log(ctr+"<-ctr");
		//입력된 계약자 정보 삭제
		$('#customerHtml').remove();
		
		$('#customerContractor').val(ctr.find('#customerId').text());
		$('#customerClass').val(ctr.find('#customerClass').text());						
		
		var customerChoiceHtml = '<div id="customerHtml">'
			customerChoiceHtml += ctr.find('#customerChoice').text()+'<br>';
			customerChoiceHtml += '<span id="telContractor">'+ ctr.find('#customerCall').text()+'</span><br>';
			customerChoiceHtml += '<span id="number" style="display:none;">'+ ctr.find('#zipCode').text() +'</span>';
			customerChoiceHtml += '<span id="addressContractor">'+ ctr.find('#customerAddress').text() +'</span>';
			customerChoiceHtml += '<span id="detailAddressContractor">'+ ctr.find('#customerAddress2').text() +'</span><br>'
		console.log(customerChoiceHtml+"<-customerChoiceHtml");
		$('[name="customerContractor"]').after(customerChoiceHtml);
		$('#__customerModal').modal('hide');
		
		//배송지 선택란에서 '계약자 주소와 동일'이 선택되었을 경우, 계약자 주소를 배송지 란에 입력
		if($('#sameAddress').prop('checked')){
			$('#addressMessage').remove();
			var deliveryNumberM = $('#number').text();
			var deliveryAddressM = $('#addressContractor').text();
			var deliveryDetailAddressM = $('#detailAddressContractor').text();
			var deliveryTelM = $('#telContractor').text();
			
			$('input[name="deliveryNumber"]').val(deliveryNumberM);
			$('input[name="deliveryAddress"]').val(deliveryAddressM);
			$('input[name="deliveryDetailAddress"]').val(deliveryDetailAddressM);
			$('input[name="deliveryTel"]').val(deliveryTelM);
		}
	});
	
	//customer(company) 선택시
	$(document).on('click', '#companyChoice', function(){
		console.log("companyChoice");
		console.log(this+"<-companyChoice");
		var ctr = $(this).parents('tr');
		console.log(ctr+"<-ctr");
		//입력된 계약자 정보 삭제
		$('#customerHtml').remove();
		
		$('#customerContractor').val(ctr.find('#customerId').text());
		$('#customerClass').val(ctr.find('#customerClass').text());						
		
		var customerChoiceHtml = '<div id="customerHtml">'
			customerChoiceHtml += ctr.find('#customerCompanyName').text()+'<br>';
			customerChoiceHtml += '<span id="telContractor">'+ ctr.find('#customerCompanyCall').text()+'</span><br>';
			customerChoiceHtml += '<span id="number" style="display:none;">'+ ctr.find('#customerCompanyZipCode').text() +'</span>';
			customerChoiceHtml += '<span id="addressContractor">'+ ctr.find('#customerCompanyAddress1').text() +'</span>';
			customerChoiceHtml += '<span id="detailAddressContractor">'+ ctr.find('#customerCompanyAddress2').text() +'</span><br>'
		console.log(customerChoiceHtml+"<-customerChoiceHtml");
		$('[name="customerContractor"]').after(customerChoiceHtml);
		$('#__customerModal').modal('hide');
	});

	//렌탈 기간 입력후 기간 계산
	$('input.rentalDate').on('blur',function(){
		console.log('blur');
		var fromStr = $('input[name="rentalFromDate"]').val();
		var toStr = $('input[name="rentalToDate"]').val();
		var fromDate;
		var toDate;
		if(fromStr!="")fromDate=new Date(fromStr);
		if(toStr!="")toDate=new Date(toStr);
		var date = new Date;

		console.log(fromStr+'<-fromStr');
		console.log(toStr+'<-toStr');
		console.log(fromDate+'<-fromDate');
		console.log(toDate+'<-toDate');
		
		if(fromStr!="" && toStr!=""){
			if(fromDate<=date){
				alert("렌탈은 네일부터 가능합니다")
			}else if(fromDate>toDate){
				alert("올바른 날짜를 입력하세요");
			}
			var period = (toDate-fromDate)/1000/60/60/24;
			console.log(period+"<=period");
			$('input[name="rentalPeriod"]').val(period);
			
			var request = $.ajax({
				url : "/saleApplication",
				type : "post",
				data : {period:period}
			});
			request.done(function(rate){
				console.log(rate);
				$('#sale').text(rate+'%할인')
			});
			request.fail(function( jqXHR, textStatus ) {
				  alert("period error");
			});
		};
	});
	//주소 출력(modal내 입력)
	$(document).on('click', '#addressBtn', function(){
		$('#addressMessage').remove();
		var deliveryNumberM = $('#deliveryNumberM').val();
		var deliveryAddressM = $('#deliveryAddressM').val();
		var deliveryDetailAddressM = $('#deliveryDetailAddressM').val();
		var deliveryTelM = $('#deliveryTelM').val();
		
		$('input[name="deliveryNumber"]').val(deliveryNumberM);
		$('input[name="deliveryAddress"]').val(deliveryAddressM);
		$('input[name="deliveryDetailAddress"]').val(deliveryDetailAddressM);
		$('input[name="deliveryTel"]').val(deliveryTelM);	
	});
	//주소 출력(계약자하고 동일)
	$(function(){
		$('#sameAddress').click(function(){
			$('#addressMessage').remove();
			var deliveryNumberM = $('#number').text();
			var deliveryAddressM = $('#addressContractor').text();
			var deliveryDetailAddressM = $('#detailAddressContractor').text();
			var deliveryTelM = $('#telContractor').text();
			
			$('input[name="deliveryNumber"]').val(deliveryNumberM);
			$('input[name="deliveryAddress"]').val(deliveryAddressM);
			$('input[name="deliveryDetailAddress"]').val(deliveryDetailAddressM);
			$('input[name="deliveryTel"]').val(deliveryTelM);
		});
		
	});
	
	
	// /jsModal/staffModal.js -> staffListModal작성,검색
	//modal에서 직원 선택시
	$(document).on('click', '#staffChoice', function(){
		$('#staffMessage').remove();
		
		console.log("staffChoice");
		console.log(this);
		var str = $(this).parents('tr');
		console.log(str+"<-str");
		$('#staffHtml').remove();
		var staffChoiceHtml = '<div id="staffHtml">'
			staffChoiceHtml += '<label>담당자&emsp;</label>';
			staffChoiceHtml += str.find('#branchName').text()+'&emsp;';
			staffChoiceHtml += str.find('#staffName').text()+'&emsp;';
			staffChoiceHtml += str.find('#staffTell').text()+'&emsp;';
			staffChoiceHtml += str.find('#staffEmail').text()+'&emsp;';
			staffChoiceHtml += '<button id="staffModal" type="button" class="btn btn-sm btn-primary" style="padding:3px;float:right;margin:0 20px 5px 0">';
			staffChoiceHtml += '<i class="fas fa-folder"></i>&ensp;담당자 검색';
			staffChoiceHtml += '</button>';
		console.log(staffChoiceHtml+"<-staffChoiceHtml");
		$('#address').after(staffChoiceHtml);
		$('#__staffModal').modal('hide');
	});
	//상품 추가
	$(document).on('click', '#goodsChoice', function(){
		var choiceTr = $(this).parents('tr');
			
		var goodsCode = choiceTr.find('#goodsCode').text();
		var goodName = choiceTr.find('#goodsName').text();
		var rentalDayPrice = choiceTr.find('#rentalDayPrice').text();
		var rentalCanCount = choiceTr.find('#rentalCanCount').text();
		var goodsCategoryName = choiceTr.find('#goodsCategoryName').text();
		
		var goodsChoiceHtml = '<tr>';
			goodsChoiceHtml += '<td>'+ goodsCategoryName +'</td>';
			goodsChoiceHtml += '<td>'+goodName+'<input type="text" name="goodsCode" value="'+goodsCode+'" hidden="hidden"></td>';
			goodsChoiceHtml += '<td id="rentalDayPrice">'+ rentalDayPrice +'</td>';
			goodsChoiceHtml += '<td id="rentalCanCount">'+ rentalCanCount +'</td>'
			goodsChoiceHtml += '<td style="width:120px;"><input type="number" name="rentalCount" style="width:60px; box-sizing:border-box" class="checkReadonly">개</td>'
			goodsChoiceHtml += '<td>-300</td>';
			goodsChoiceHtml += '<td></td>';
			goodsChoiceHtml += '<td class="checkHidden">';
			goodsChoiceHtml += '<a id="goodsDelete" class="btn btn-danger btn-sm" href="#" style="padding:1px 4px 1px 4px">';
			goodsChoiceHtml += '<i class="fas fa-trash"></i>&ensp;삭제</a>';
			goodsChoiceHtml += '</td>';

		$('#goodAdd').before(goodsChoiceHtml);
		$('input[name="goodsCode"]').val(goodsCode);
		$('#__goodsModal').modal('hide');
	});
	$(document).on('click', '#goodsDelete', function(){
		$(this).parents('tr').remove();
	});
	
	//세트 추가
	$(document).on('click', '#setChoice', function(){
		console.log('setChoice');
		var setCode = $('#setCode').text();
		var setName = $('#setName').text();
		var rentalDayPrice = $('#rentalDayPrice').text();
		var rentalCanCount = $('#rentalCanCount').text();
		
		var goodsChoiceHtml = '<tr>';
			goodsChoiceHtml += '<td>'+setName+'<input type="text" name="setCode" hidden="hidden"></td>';
			goodsChoiceHtml += '<td>'+ rentalDayPrice +'</td>';
			goodsChoiceHtml += '<td>'+ rentalCanCount +'</td>'
			goodsChoiceHtml += '<td style="width:120px;"><input type="number" name="rentalCount" style="width:60px; box-sizing:border-box" class="checkReadonly">개</td>'
			goodsChoiceHtml += '<td>-300</td>';
			goodsChoiceHtml += '<td>49700</td>';
			goodsChoiceHtml += '<td class="checkHidden">';
			goodsChoiceHtml += '<a class="btn btn-danger btn-sm" href="#" style="padding:1px 4px 1px 4px">';
			goodsChoiceHtml += '<i class="fas fa-trash"></i>&ensp;삭제</a>';
			goodsChoiceHtml += '</td>';
		
		$('#goodAdd').before(goodsChoiceHtml);
		$('input[name="setCode"]').val(setCode);
		$('#__setModal').modal('hide');
	});
	
	$('#contractCheck').click(function(){
		$('.checkHidden').css('display','none');
		$('.checkReadonly').attr('readonly',true);
		$('input.checkReadonly').css('border','none');
	});
	
	$('#contractCancel').click(function(){
		console.log('contractCancel');
		$('.checkHidden').css('display','block');
		$('.checkReadonly').attr('readonly',false);
		$('input.checkReadonly').css('border-line','2px');
	});
});		