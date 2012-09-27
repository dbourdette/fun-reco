<g:formatDate value="${action.date}" pattern="dd/MM HH:mm" />
-
<g:link controller="index" params="[facebookId: action.profile.facebookId]">${action.profile.name}</g:link>
-
${action.object}