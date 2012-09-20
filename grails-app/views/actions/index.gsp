<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <link href="/css/bootstrap-combined.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="span12 well">
                <g:link action="bootstrap" class="btn btn-warning pull-right">Reset DB</g:link>
                <g:form controller="index" class="form-inline">
                    email
                    <input type="text" name="email" value="${email}" class="input-medium search-query input-xlarge">
                    facebook id
                    <input type="text" name="facebookId" value="${facebookId}" class="input-medium search-query input-xlarge">
                    <button type="submit" class="btn">Search</button>
                </g:form>
            </div>
        </div>

        <div class="row">
            <div class="span12">
                <legend>All actions</legend>
                <div class="well">
                    <g:paginate controller="actions" total="${total}" />
                </div>
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