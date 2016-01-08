/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p/>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p/>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.tutorial.portlet;


import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import im.ligas.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author Miroslav Ligas
 */
public class TutorialPortlet extends MVCPortlet {

	public static final String TITLE = "title";
	public static final String CONTENT = "content";

	@Override
	public void setModel(Map<String, Object> model, RenderRequest request) {
		PortletPreferences preferences = request.getPreferences();
		model.put(TITLE, preferences.getValue(TITLE, StringPool.BLANK));
		model.put(CONTENT, preferences.getValue(CONTENT, StringPool.BLANK));
	}

	public void saveTutorialTitle(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		PortletPreferences preferences = request.getPreferences();
		preferences.setValue(TITLE, ParamUtil.getString(request, TITLE, StringPool.BLANK));
		preferences.setValue(CONTENT, ParamUtil.getString(request, CONTENT, StringPool.BLANK));
		preferences.store();
	}


}
