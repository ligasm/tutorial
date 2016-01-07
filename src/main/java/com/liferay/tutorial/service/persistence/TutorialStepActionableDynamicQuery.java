package com.liferay.tutorial.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.tutorial.model.TutorialStep;
import com.liferay.tutorial.service.TutorialStepLocalServiceUtil;

/**
 * @author Miroslav Ligas
 * @generated
 */
public abstract class TutorialStepActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public TutorialStepActionableDynamicQuery() throws SystemException {
        setBaseLocalService(TutorialStepLocalServiceUtil.getService());
        setClass(TutorialStep.class);

        setClassLoader(com.liferay.tutorial.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("stepId");
    }
}
