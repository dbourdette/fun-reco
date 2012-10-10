
<%@ page import="fun.reco.Persistence" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'persistence.label', default: 'Persistence')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-persistence" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-persistence" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="first" title="${message(code: 'persistence.first.label', default: 'First')}" />
					
						<g:sortableColumn property="last" title="${message(code: 'persistence.last.label', default: 'Last')}" />
					
						<g:sortableColumn property="number" title="${message(code: 'persistence.number.label', default: 'Number')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${persistenceInstanceList}" status="i" var="persistenceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${persistenceInstance.id}">${fieldValue(bean: persistenceInstance, field: "first")}</g:link></td>
					
						<td>${fieldValue(bean: persistenceInstance, field: "last")}</td>
					
						<td>${fieldValue(bean: persistenceInstance, field: "number")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${persistenceInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
