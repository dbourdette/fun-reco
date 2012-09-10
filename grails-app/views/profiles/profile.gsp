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

    <div class="row">
        <div class="span12">
            ${profile}
        </div>
    </div>

    <div class="row">
        <div class="span12">
            <legend>Actions</legend>
            <ul>
                <g:each in="${actions}">
                    <li>${it}</li>
                </g:each>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="span12">
            <legend>Recommendations <g:link action="buildRecommendations" id="${profile.id}" class="btn btn-warning pull-right">Build recommenations</g:link></legend>
            <ul>
                <g:each in="${recommendations}">
                    <li>${it}</li>
                </g:each>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="span12">
            <legend>Friends <g:link action="generateFriends" id="${profile.id}" class="btn btn-warning pull-right">Generate friends</g:link></legend>
            <ul>
                <g:each in="${friends.friends}">
                    <li>${it.name}</li>
                </g:each>
            </ul>
        </div>
    </div>
</div>
</body>
</html>