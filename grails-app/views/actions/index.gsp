<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.1.1/css/bootstrap-combined.min.css" rel="stylesheet">
    <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="navbar">
        <div class="navbar-inner">
            <a class="brand" href="/">Fun-reco</a>
        </div>
    </div>

    <g:form action="save">
        <legend>New actions</legend>

        <label>Profile</label>
        <input type="text" name="email" placeholder="email (leave blank for random)" class="span4">
        <label>Object id</label>
        <input type="text" name="id" placeholder="54603131" class="span2">
        <label>Object properties</label>
        <textarea name="properties" placeholder="type=video..." class="span6"></textarea>
        <br/>
        <button type="submit" class="btn btn-success">Generate</button>
    </g:form>

    <div class="row">
        <div class="span12">
            <legend>${count} actions in database</legend>
            <ul>
                <g:each in="${items}">
                    <li>${it}</li>
                </g:each>
            </ul>
        </div>
    </div>
</div>
</body>
</html>