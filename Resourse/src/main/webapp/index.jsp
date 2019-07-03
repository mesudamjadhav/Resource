<html>

<head>
<title>Home</title>
<link href="resources/jQuery/jquery-ui.css" rel="stylesheet">
<link href="resources/jQuery/jquery-ui.theme.css" rel="stylesheet">
<link href="resources/jQuery/jquery-ui.structure.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="resources/jqGrid/ui.jqgrid.css">

<script src="resources/jQuery/jquery.min.js"></script>
<script src="resources/jQuery/jquery-ui.js"></script>

<script type="text/javascript">
	function getAddressDoc() {
		var oApplication = new ActiveXObject("Word.Application");
// 		oApplication.Documents.Open("/Logs/Address.doc");
		oApplication.Documents.Open("C:\Users\sudam.jadhav\Documents\Interview Questions.xlsx");
		
		oApplication.Visible = true;
		var oDocument = oApplication.ActiveDocument;
		oDocument.Bookmarks("bmkCity").Range.Text = "";
		oDocument.Bookmarks("bmkState").Range.Text = "";
		oDocument.Bookmarks("bmkRegion").Range.Text = "";
		oDocument.Bookmarks("bmkState").Range.Text = "";
		oDocument.Bookmarks("bmkZip").Range.Text = "";
		oApplication.Documents.SaveAs("/Logs/Address_Upd.doc");
		oApplication.Visible = false;
		oApplication.Quit();
	}

	jQuery.browser = {};
	(function() {
		getAddressDoc();
		jQuery.browser.msie = false;
		jQuery.browser.version = 0;
		if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
			jQuery.browser.msie = true;
			jQuery.browser.version = RegExp.$1;
		}
	})();
</script>

<script src="resources/jqGrid/i18n/grid.locale-en.js"></script>
<script src="resources/jqGrid/jquery.jqGrid.min.js"></script>
<script src="resources/js/application.js" type="text/javascript"></script>


</head>
<body>
	<a href="#" onclick="showDataAjaxCall();">Show</a>
	<a href="#" onclick="loadUploadPage();">Upload</a>
	<table id="employeeGridId"></table>
	<div id="employeeGridPager"></div>

	<div id="container">${msg}</div>



</body>


</html>
