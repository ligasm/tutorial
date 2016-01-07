package com.liferay.tutorial.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TutorialStepService}.
 *
 * @author Miroslav Ligas
 * @see TutorialStepService
 * @generated
 */
public class TutorialStepServiceWrapper implements TutorialStepService,
    ServiceWrapper<TutorialStepService> {
    private TutorialStepService _tutorialStepService;

    public TutorialStepServiceWrapper(TutorialStepService tutorialStepService) {
        _tutorialStepService = tutorialStepService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _tutorialStepService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _tutorialStepService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _tutorialStepService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public void addTutorialSteps(long companyId, long groupId, long plid,
        java.lang.String stepsListJson)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _tutorialStepService.addTutorialSteps(companyId, groupId, plid,
            stepsListJson);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TutorialStepService getWrappedTutorialStepService() {
        return _tutorialStepService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTutorialStepService(
        TutorialStepService tutorialStepService) {
        _tutorialStepService = tutorialStepService;
    }

    @Override
    public TutorialStepService getWrappedService() {
        return _tutorialStepService;
    }

    @Override
    public void setWrappedService(TutorialStepService tutorialStepService) {
        _tutorialStepService = tutorialStepService;
    }
}
