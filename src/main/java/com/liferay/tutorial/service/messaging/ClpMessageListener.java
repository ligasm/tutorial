package com.liferay.tutorial.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.liferay.tutorial.service.ClpSerializer;
import com.liferay.tutorial.service.TutorialStepLocalServiceUtil;
import com.liferay.tutorial.service.TutorialStepServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            TutorialStepLocalServiceUtil.clearService();

            TutorialStepServiceUtil.clearService();
        }
    }
}
