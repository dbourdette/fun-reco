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

    <g:form action="add">
        <legend>New query</legend>

        <label>Query</label>
        <input type="text" name="query" placeholder="and (type = xxx, ...)" class="span6">
        <br/>
        <button type="submit" class="btn btn-success">Update</button>
    </g:form>
</div>
</body>
</html>