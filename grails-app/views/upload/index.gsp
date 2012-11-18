<html>

<head>
<meta name="layout" content="main" />
</head>

<body>

    Uploader une archive ZIP contenant les éléments JSON à importer, par classe dans un fichier texte nommé du nom de la classe.
    <br/>

	<fileuploader:form upload="archive" successAction="upload_success"
		successController="upload" errorAction="upload_error" errorController="upload"
	 />
		
</body>
</html>