//고객 검색bottun click시 list 표시
$('#customerSerchBtn').click(function(){
	$('#customerList').css('display','block');
});
//고객을 선택시 검색창,list 비표시
$('#customerChoice').click(function(){
	$('#coustomerClose').click();
});
//기간,상품,세트,갯수를 입력시 할인액,합계액,종합계액을 병경하는 함수
var pricePrint =
	function(){
		var rate = $('#sale').text();
		//상품이 입력 되있다면
		var rentalDayPriceLength = $('.rentalDayPrice').length;
		if(rentalDayPriceLength>0){
			var totalPrice = 0;
			for(var i=0; i<rentalDayPriceLength; i++){
				var rentalDayPrice = parseInt($('.rentalDayPrice').eq(i).text());
				var discount = rentalDayPrice*rate*0.01*(-1);
				console.log($('[name="rentalCount"]').eq(i).val());
				var goodsSetPrice = ($('[name="rentalCount"]').eq(i).val())*(rentalDayPrice+discount);
				$('.discount').eq(i).text(discount);
				$('.goodsSetPrice').eq(i).text(goodsSetPrice);
				totalPrice += goodsSetPrice;
			};
			var rentalPeriod = $('[name="rentalPeriod"]').val();
			//totalPrice*rentalPeriod렌탈 기간*등급 할인율(%)*0.01*(-1)=등급 할인액
			if($('#customerClass').text()=="")var customerClass = 0;
			else var customerClass = parseInt($('#customerClass').text());
			if(customerClass=="NaN")customerClass=1;
			var customerDiscount = totalPrice*rentalPeriod*customerClass*0.01*(-1);
			$('#customerDiscount').text(customerDiscount);
			$('[name="contractTotalPrice"]').val(totalPrice*rentalPeriod+customerDiscount);
		};
	};


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
		customerChoiceHtml += '<input type="readonly" style="border:none" name="gradeName" value="'+ctr.find('#customerClass').text()+'">';
		customerChoiceHtml += '<span id="customerDiscount">'+ ctr.find('#customerDiscount').text() +'</span>';
		customerChoiceHtml += '<span>% 할인</span>';
	console.log(customerChoiceHtml+"<-customerChoiceHtml");
	$('[name="customerContractor"]').after(customerChoiceHtml);
	$('#__customerModal').modal('hide');
	
	//기간,상품,세트,갯수를 입력시 할인액,합계액,종합계액을 병경
	pricePrint();
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
	//선택된 값을 가지고 오기
	$('#customerContractor').val(ctr.find('#customerId').text());
	$('#customerClass').val(ctr.find('#customerClass').text());						
	
	var customerChoiceHtml = '<div id="customerHtml">'
		customerChoiceHtml += ctr.find('#customerCompanyName').text()+'<br>';
		customerChoiceHtml += '<span id="telContractor">'+ ctr.find('#customerCompanyCall').text()+'</span><br>';
		customerChoiceHtml += '<span id="number" style="display:none;">'+ ctr.find('#customerCompanyZipCode').text() +'</span>';
		customerChoiceHtml += '<span id="addressContractor">'+ ctr.find('#customerCompanyAddress1').text() +'</span>';
		customerChoiceHtml += '<span id="detailAddressContractor">'+ ctr.find('#customerCompanyAddress2').text() +'</span><br>'
		customerChoiceHtml += '<span id="customerClass">'+ctr.find('#customerClass').text()+'</span>'
	console.log(customerChoiceHtml+"<-customerChoiceHtml");
	$('[name="customerId"]').after(customerChoiceHtml);
	$('#__customerModal').modal('hide');
	//기간,상품,세트,갯수를 입력시 할인액,합계액,종합계액을 병경
	pricePrint();
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
			$('#sale').text(rate);
			//기간,상품,세트,갯수를 입력시 할인액,합계액,종합계액을 병경
			pricePrint();
			
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
	//console.log(staffChoiceHtml+"<-staffChoiceHtml");
	$('#address').after(staffChoiceHtml);
	$('#__staffModal').modal('hide');
});

var goodsSetAdd = function(rentalDayPrice,rentalCanCount
							,goodsCode,goodsName,goodsCategoryName
							,setCode,setName){	
	var goodsChoiceHtml = '<tr>';
	goodsChoiceHtml += '<td>'+ goodsCategoryName + setName +'<input type="hidden" name="setCode" value="'+setCode+'"</td>';
	goodsChoiceHtml += '<td>'+goodsName+'<input type="hidden" name="goodsCode" value="'+goodsCode+'"></td>';
	goodsChoiceHtml += '<td class="rentalDayPrice">'+ rentalDayPrice +'</td>';
	goodsChoiceHtml += '<td class="discount"></td>';
	goodsChoiceHtml += '<td id="rentalCanCount">'+ rentalCanCount +'</td>'
	goodsChoiceHtml += '<td style="width:120px;"><input type="number" value=1 name="rentalCount" style="width:60px; box-sizing:border-box">개</td>'
	goodsChoiceHtml += '<td class="goodsSetPrice"></td>';
	goodsChoiceHtml += '<td>';
	goodsChoiceHtml += '<a id="goodsSetDelete" class="btn btn-danger btn-sm" href="#" style="padding:1px 4px 1px 4px">';
	goodsChoiceHtml += '<i class="fas fa-trash"></i>&ensp;삭제</a>';
	goodsChoiceHtml += '</td>';
	
	//console.log(goodsChoiceHtml);
	$('tbody#contract').append(goodsChoiceHtml);//계약 상품 목록의 마기막에 추가
};

var goodsSessionFn = function(){
	var goodsArr = [];
	var tbodyGoodsCode = $('tbody#contract').find('[name="goodsCode"]');
	for(var i=0; i<tbodyGoodsCode.length; i++){
		if(tbodyGoodsCode.eq(i).val()!=""){
			goodsArr.push(tbodyGoodsCode.eq(i).val());
		}
	}
	sessionStorage.setItem('goodsArr',goodsArr);
	console.log(goodsArr);
};
var setSettionFn = function(){
	var setArr = [];
	var tbodySetCode = $('tbody#contract').find('[name="setCode"]');
	for(var i=0; i<tbodySetCode.length; i++){
		if(tbodySetCode.eq(i).val()!=""){
			setArr.push(tbodySetCode.eq(i).val());
		}
	}
	sessionStorage.setItem('setArr',setArr);
	console.log(setArr);
};

//상품 추가
$(document).on('click', '#goodsChoice', function(){
	var choiceTr = $(this).parents('tr');
	var rentalDayPrice = choiceTr.find('#rentalDayPrice').text();
	var rentalCanCount = choiceTr.find('#rentalCanCount').text();
	
	var goodsCode = choiceTr.find('#goodsCode').text();
	var goodsName = choiceTr.find('#goodsName').text();
	console.log(goodsName);
	console.log('goodsName');
	
	var goodsCategoryName = choiceTr.find('#goodsCategoryName').text();
	
	var setCode = "";
	var setName = "";
	
	goodsSetAdd(rentalDayPrice,rentalCanCount
				,goodsCode,goodsName,goodsCategoryName
				,setCode,setName);	
	$('#__goodsModal').modal('hide');

	//session에 추가 goods검색시 선택한 goods 제외
	//goodsSessionFn();
	//기간,상품,세트,갯수를 입력시 할인액,합계액,종합계액을 병경
	pricePrint();
	
});
//세트 추가
$(document).on('click', '#setChoice', function(){
	var choiceTr = $(this).parents('tr');
	var rentalDayPrice = choiceTr.find('#rentalDayPrice').text();
	var rentalCanCount = choiceTr.find('#rentalCanCount').text();
	
	var goodsCode = "";
	var goodsName = choiceTr.find('#goodsName').text();
	var goodsCategoryName = "";
	
	var setCode = choiceTr.find('#setCode').text();
	var setName = choiceTr.find('#setName').text();	
	goodsSetAdd(rentalDayPrice,rentalCanCount
			,goodsCode,goodsName,goodsCategoryName
			,setCode,setName);
	
	$('#__setModal').modal('hide');
	//session에 추가 set검색시 선택한 set 제외
	setSettionFn();
	//기간,상품,세트,갯수를 입력시 할인액,합계액,종합계액을 병경
	pricePrint();
});
	


$(document).on('click', '#goodsSetDelete', function(){
	$(this).parents('tr').find('')
	$(this).parents('tr').remove();
	//session을 제검색 set검색시 선택한 set 제외
	setSettionFn();
	//session을 제검색 goods검색시 선택한 set 제외
	goodsSessionFn();
	//기간,상품,세트,갯수를 입력시 할인액,합계액,종합계액을 병경
	pricePrint();
});
	
	$('#contractInsert').click(function(){
		console.log("contractInsert");
		const formData = new FormData($('form#docContractCom')[0]);
		console.log(formData);
		var tbodyTr = $('tbody#contract').find('tr');
		var goodsList = [tbodyTr.length];
		for(var i=0; i<tbodyTr.length; i++){
			var obj;
			var goodsCodeVal = tbodyTr.eq(0).find('[name="goodsCode"]').val();
			var setCodeVal = tbodyTr.eq(0).find('[name="setCode"]').val();
			var rentalCountVal = tbodyTr.eq(0).find('[name="rentalCountVal"]').val();
			if(goodsCodeVal!=undefined){
				obj={goodsCode:goodsCodeVal,rentalCount:rentalCountVal};
			}else if(setCodeVal!=undefined){
				obj={setCode:setCodeVal,rentalCount:rentalCountVal};
			}
			goodsList.push(obj);
			//'goodsList=goodsList&formData=formData'
		}
		console.log(goodsList+"<-goodsList");
		location.href='/staff/contractInsert';//

		$.post( '/staff/contractInsert', 'a=1').done(function( data ) {
		    console.log( data.form );
		});			
	});
	
	$('#contractCancel').click(function(){
	});
	