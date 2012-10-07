<%@ page import="fun.reco.Persistence" %>



<div class="fieldcontain ${hasErrors(bean: persistenceInstance, field: 'first', 'error')} ">
	<label for="first">
		<g:message code="persistence.first.label" default="First" />
		
	</label>
	<g:textField name="first" value="${persistenceInstance?.first}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: persistenceInstance, field: 'last', 'error')} ">
	<label for="last">
		<g:message code="persistence.last.label" default="Last" />
		
	</label>
	<g:textField name="last" value="${persistenceInstance?.last}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: persistenceInstance, field: 'number', 'error')} required">
	<label for="number">
		<g:message code="persistence.number.label" default="Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="number" type="number" value="${persistenceInstance.number}" required=""/>
</div>

