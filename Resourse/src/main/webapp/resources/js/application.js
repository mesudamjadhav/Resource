
function callAjax(url,callback) {
		$.ajax({
			  method: "GET",
			  url: url,
			})
			.done(function( data ) {
				callback(data);
			  });
	}

function callPostAjax(url,data,callback) {
	$.ajax({
		  method: "POST",
		  url: url,
		  data : data,
		  dataType: "html",          
          contentType: 'application/json',
          mimeType: 'application/json',
		})
		.done(function( data ) {
			callback(data);
		  });
}

function callAjaxForFileUpload(url,formData,callback){
	$.ajax({
	       url : url,
	       type : 'POST',
	       data : formData,
	       processData: false,  
	       contentType: false,  
	       success : function(data) {
	           callback(data);
	       }
	});
}

function addEmployees(){
	
	var data = '[{"id": 1,"name": "Sudam","address": "Pune"},{"id": 2,"name": "Sagar","address": "Pune"}]';
	
	var addCallBack = function(response){
		
	}
	callPostAjax("fileUploadController/add",data,addCallBack)
}

function loadUploadPage(){
	var uploadPageCallback = function(response){
		$("#employeeGridId").jqGrid('GridUnload');
		$('#container').html(response);
	};
	callAjax("fileUploadController/upload",uploadPageCallback);
}

function showDataAjaxCall(){
	$("#employeeGridId").jqGrid('GridUnload');
	var showDataCallback = function(response){
		$('#container').html('');
		renderEmployeeGrid(response);
	};
	callAjax("fileUploadController/show",showDataCallback);
}

function uploadExcelFileData() {
	 var formData = new FormData();
	 formData.append('file', $('#fileId')[0].files[0]);
	 var fileUploadCallback = function(response){
		 $('#container').html(response);
	 };
	 callAjaxForFileUpload("fileUploadController/fileUpload",formData,fileUploadCallback);
}

function renderEmployeeGrid(data){
	$("#employeeGridId").jqGrid({
	data : data,
	datatype : "local",
	colNames : ["", "Name", "Address"],
	colModel : [
		
					{name : "id",index: "id",sortable : true,hidden:true},
					{name : "name",index: "name",sortable : true, editable:false, edittype:'text'},
					{name : "address",index: "address",sortable : true} 
				],
	pager : "#employeeGridPager",
	rowNum : 10,
	height : 'auto',
	width : '500',
	loadonce : true,
	viewrecords: true,
	caption : "Employee Details",
	onSelectRow: function(id, status) {
		jQuery("#employeeGridId").jqGrid('editRow',id);
    },
    beforeSelectRow: function (rowid, e) {
    	jQuery("#employeeGridId").jqGrid('saveRow',$("#employeeGridId").jqGrid ('getGridParam', 'selrow'));
    	return true;
    },
    onPaging : function(pgButton){
//    	updateDataOnpaging();
    },
    afterEditCell:function (rowid, cellname, value, iRow, iCol){
		   alert("Edited "+cellname);
	}
	});
	
	 
} 

function getGridData(){
	var jsonData = {
		"employeeDTOs" : jQuery("#employeeGridId").getRowData()
	}; 
	return JSON.stringify(jsonData);
}

function updateDataOnpaging(){
	var updateCallback = function(response){
		console.log(response);
	};
	callPostAjax("fileUploadController/updateDataOnpaging",getGridData(),updateCallback);
}


//function getAddressDoc()
//{
// var oApplication=new ActiveXObject("Word.Application");
// oApplication.Documents.Open("/Logs/Address.doc");
// oApplication.Visible=true;
// var oDocument=oApplication.ActiveDocument;
// oDocument.Bookmarks("bmkCity").Range.Text = "";
// oDocument.Bookmarks("bmkState").Range.Text = "";
// oDocument.Bookmarks("bmkRegion").Range.Text = "";
// oDocument.Bookmarks("bmkState").Range.Text = "";
// oDocument.Bookmarks("bmkZip").Range.Text = "";
// oApplication.Documents.SaveAs("/Logs/Address_Upd.doc");
// oApplication.Visible=false;
// oApplication.Quit();
//}
