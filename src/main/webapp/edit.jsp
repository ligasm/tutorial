<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects/>

<aui:button-row>
	<aui:button cssClass="openTutorialSetup" value="Open Step setup"/>
</aui:button-row>

<div class="tutorial-setup-message">

	<portlet:renderURL var="redirect"/>
	<portlet:actionURL name="saveTutorialTitle" var="saveURL">
		<portlet:param name="redirect" value="${redirect}"/>
	</portlet:actionURL>
	<aui:form action="${saveURL}" method="POST">
		<aui:input name="title" value="${title}"/>
		<aui:input type="textarea" name="content" value="${content}"/>
		<aui:button-row>
			<aui:button type="submit" name="save"/>
			<portlet:renderURL var="backURL" portletMode="VIEW"/>
			<aui:button type="button" name="back" value="back" onClick="${backURL}"/>
		</aui:button-row>
	</aui:form>
</div>
<script type="text/javascript">

	AUI().use('tutorial-setup',
			function (A) {

				A.one(".tutorial-setup .openTutorialSetup").on('click', function (event) {
					event.stopPropagation();

					new Liferay.TutorialSetupContainer({
						saveFn: function (data) {
							Liferay.Service(
									'/tutorial-portlet.tutorialstep/add-tutorial-steps',
									{
										plid: themeDisplay.getPlid(),
										companyId: themeDisplay.getCompanyId(),
										groupId: themeDisplay.getScopeGroupId(),
										stepsListJson: data
									},
									function (obj) {
										alert("Operation was successful")
									},
									function (obj) {
										alert("Error: " + obj)
									}
							);
						}
					});
				});
			}
	);
</script>