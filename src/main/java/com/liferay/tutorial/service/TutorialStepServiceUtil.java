package com.liferay.tutorial.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for TutorialStep. This utility wraps
 * {@link com.liferay.tutorial.service.impl.TutorialStepServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Miroslav Ligas
 * @see TutorialStepService
 * @see com.liferay.tutorial.service.base.TutorialStepServiceBaseImpl
 * @see com.liferay.tutorial.service.impl.TutorialStepServiceImpl
 * @generated
 */
public class TutorialStepServiceUtil {
    private static TutorialStepService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.tutorial.service.impl.TutorialStepServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void addTutorialSteps(long companyId, long groupId,
        long plid, java.lang.String stepsListJson)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().addTutorialSteps(companyId, groupId, plid, stepsListJson);
    }

    public static java.util.List<com.liferay.tutorial.model.TutorialStep> getTutorialSteps(
        long companyId, long groupId, long plid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTutorialSteps(companyId, groupId, plid);
    }

    public static void clearService() {
        _service = null;
    }

    public static TutorialStepService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    TutorialStepService.class.getName());

            if (invokableService instanceof TutorialStepService) {
                _service = (TutorialStepService) invokableService;
            } else {
                _service = new TutorialStepServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(TutorialStepServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(TutorialStepService service) {
    }
}
