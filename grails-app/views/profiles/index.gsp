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
        <legend>New profile <g:link action="generateProfiles" class="btn btn-warning pull-right">Generate random profiles</g:link></legend>

        <label>Profile</label>
        <input type="text" name="email" placeholder="email (leave blank for random)" class="span4">
        <br>
        <button type="submit" class="btn btn-success">Generate</button>
    </g:form>

    <div class="row">
        <div class="span12">
            <legend>
                ${count} profiles in database
                <g:form class="form-search pull-right" action="index" method="get">
                    <input type="text" name="query" value="${query}" class="search-query span4" placeholder="search by email" style="height:28px">
                </g:form>
            </legend>
            <ul>
                <g:each in="${items}">
                    <li>${it.email} <g:link action="profile" id="${it.id.toString()}" ><i class="icon-eye-open"></i></g:link></li>
                </g:each>
            </ul>
        </div>
    </div>
</div>
</body>
</html>