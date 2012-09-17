<%@ include file="../includes/directives.jsp"%>

<!DOCTYPE HTML>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <title></title>

    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.0.4/css/bootstrap-combined.min.css" rel="stylesheet">

</head>
<body>
    <div class="container">
        <div class="row">
            <div class="span12 well">
                <g:link action="bootstrap" class="btn btn-warning pull-right">Reset DB</g:link>
                <form class="form-inline">
                    email
                    <input type="text" name="email" value="${email}" class="input-medium search-query input-xlarge">
                    facebook id
                    <input type="text" name="facebookId" value="${facebookId}" class="input-medium search-query input-xlarge">
                    <button type="submit" class="btn">Search</button>
                </form>
            </div>
        </div>

        <g:if test="${email || facebookId}">
            <div class="row">
                <div class="span12">
                    <legend>Profile</legend>
                    ${profile == null ? 'unknown profile' : profile}
                </div>
            </div>
        </g:if>

        <div class="row">
            <div class="span8">
                <legend>
                    Open graph for ${profile == null ? 'all users' : profile.email}
                    <g:link action="buildRecommendations" params="[facebookId : profile?.facebookId]" class="btn btn-warning pull-right">Build recos</g:link>
                </legend>
                <g:each var="recommendationEntry" in="${recommendation?.entries}">
                    <h4>${recommendationEntry.query}</h4>
                    <ul>
                        <g:each var="recommendedObject" in="${recommendationEntry.objects}">
                            <li>
                                ${recommendedObject.id}
                                <g:each var="profile" in="${recommendedObject.by}">
                                    <a href="http://www.facebook.com/${profile.facebookId}" target="_blank"><img src="https://graph.facebook.com/${profile.facebookId}/picture" alt="${profile.name}" height="24px" width="24px"></a>
                                </g:each>
                            </li>
                        </g:each>
                    </ul>
                </g:each>
            </div>
            <div class="span4">
                <legend>Facebook Likes Recommendation</legend>
                <ul>
                    <g:each var="keyword" in="${facebookLikesRecommendation?.keywords}">
                        <li>${keyword}</li>
                    </g:each>
                </ul>
            </div>
        </div>

        <g:if test="${profile}">
            <div class="row">
                <div class="span12">
                    <legend>Friends</legend>
                    <g:each var="friend" in="${friends}">
                        <a href="?facebookId=${friend.facebookId}">${friend.name}</a>
                    </g:each>
                </div>
            </div>
        </g:if>

        <div class="row">
            <div class="span12">
                <legend>
                    Latests actions
                    <g:link controller="actions" class="btn btn-warning pull-right">View all</g:link>
                </legend>
                <ul>
                    <g:each var="action" in="${actions}">
                        <li>
                            <g:formatDate value="${action.date}" pattern="dd/MM HH:mm" />
                            -
                            <a href="?facebookId=${action.profile.facebookId}">${action.profile.name}</a>
                            -
                            ${action.object}
                        </li>
                    </g:each>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>