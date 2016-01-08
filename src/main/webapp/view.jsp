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

<portlet:defineObjects/>

<script type="text/javascript">

	AUI().ready('tutorial',
			function (A) {

				Liferay.Service(
						'/tutorial-portlet.tutorialstep/get-tutorial-steps',
						{
							plid: themeDisplay.getPlid(),
							companyId: themeDisplay.getCompanyId(),
							groupId: themeDisplay.getScopeGroupId()
						},
						function(obj) {
							console.log(obj);
						}
				);

				var _tutorialSteps = [
					{
						align: {
							node: 'a.logo',
							points: ['tc', 'bc']
						},
						bodyContent: 'Test 1',
						position: 'bottom'
					},
					{
						align: {
							node: 'li.user-avatar',
							points: ['tc', 'bc']
						},
						bodyContent: 'Test 2',
						position: 'bottom'
					},
					{
						align: {
							node: '#portlet_58',
							points: ['bc', 'cc']
						},
						bodyContent: 'Test 3',
						position: 'top'
					},
					{
						align: {
							node: '#portlet_tutorial_WAR_tutorialportlet',
							points: ['cc', 'rc']
						},
						bodyContent: 'Test 4',
						position: 'right'
					}
				];

				new Liferay.Tutorial({
					tutorialSteps: _tutorialSteps,
					welcomePopup: {
						text: 'sdfg sd fgsd gs gsd s fs sd',
						title: 'About Patient Map'
					}
				}).activateTutorial();
			}
	);
</script>
