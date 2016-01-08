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

				var tutorial = new Liferay.Tutorial({
					plid: themeDisplay.getPlid(),
					welcomePopup: {
						text: 'sdfg sd fgsd gs gsd s fs sd',
						title: 'About Patient Map'
					}
				});

				Liferay.Service(
						'/tutorial-portlet.tutorialstep/get-tutorial-steps',
						{
							plid: themeDisplay.getPlid(),
							companyId: themeDisplay.getCompanyId(),
							groupId: themeDisplay.getScopeGroupId()
						},
						function(obj) {
							var _tutorialSteps = [];
							A.Array.forEach(obj, function(item){
								var after = {};
								if(item.action){
									after.action = item.action;
									after.value = item.actionValue;
								}
								_tutorialSteps.push({
									align: {
										node: item.node,
										points: JSON.parse(item.alignPosition)
									},
									bodyContent: item.messageCurrentValue,
									position: item.position,
									after :after
								});
							});

							tutorial.setTutorialSteps(_tutorialSteps);
							tutorial.activateTutorial();
						}
				);

			}
	);
</script>
