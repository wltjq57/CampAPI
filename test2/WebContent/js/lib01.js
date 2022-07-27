$(function() {
	getJson();
});

//json 데이터 읽어오는 함수
function getJson(){
	$.getJSON("json/basedList.json",function(data){
		$.each(data, function(key, val){
			if(key=="header"){
				$("table").attr("border","1");
				
				$("thead").append(
					"<tr>"+
						"<th>"+val.addr1+"</th>"+
						"<th>"+val.addr2+"</th>"+
						"<th>"+val.caraSiteCo+"</th>"+
						"<th>"+val.facltNm+"</th>"+
						"<th>"+val.featureNm+"</th>"+
						"<th>"+val.firstImageUrl+"</th>"+
						"<th>"+val.induty+"</th>"+
						"<th>"+val.intro+"</th>"+
						"<th>"+val.lineIntro+"</th>"+
						"<th>"+val.mapX+"</th>"+
						"<th>"+val.mapY+"</th>"+
						
					"</tr>"
				);	
			} else{
				var list = val;
				for(var i=0; i<list.length; i++){
					var str = list[i];
					$("tbody").append(
						"<tr>"+
							"<td>"+str.addr1+"</td>"+
							"<td>"+str.addr2+"</td>"+
							"<td>"+str.caraSiteCo+"</td>"+
							"<td>"+str.facltNm+"</td>"+
							"<td>"+str.featureNm+"</td>"+
							"<td>"+str.firstImageUrl+"</td>"+
							"<td>"+str.induty+"</td>"+
							"<td>"+str.intro+"</td>"+
							"<td>"+str.lineIntro+"</td>"+
							"<td>"+str.mapX+"</td>"+
							"<td>"+str.mapY+"</td>"+
							"<input type='hidden' name='lib' value='"+
							str.addr1+"/"+str.addr2+"/"+str.caraSiteCo+"/"+str.facltNm+"/"+str.featureNm+"/"+str.firstImageUrl+"/"
							+str.induty+"/"+str.intro+"/"+str.lineIntro+"/"+str.mapX+"/"+str.mapY+"'>"+
						"</tr>"
					);
				}
			}
		});
	});
}