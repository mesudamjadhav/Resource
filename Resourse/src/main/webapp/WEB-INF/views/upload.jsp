<form id="fileUploadFormId" method="post"  action="fileUploadController/fileUpload" enctype="multipart/form-data">
	<table>
   		<tr>
   			<td>Select File</td>
   			<td><input type="file" id="fileId" name="file" multiple /></td>
   		</tr>
   		<tr><td></td><td></td></tr>
   		<tr>
   			<td></td><td><input type="button" value="Submit" onclick="uploadExcelFileData();"></td>
   		</tr>
   	</table>
</form>
