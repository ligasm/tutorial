package com.liferay.tutorial.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for TutorialStep. This utility wraps
 * {@link com.liferay.tutorial.service.impl.TutorialStepLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Miroslav Ligas
 * @see TutorialStepLocalService
 * @see com.liferay.tutorial.service.base.TutorialStepLocalServiceBaseImpl
 * @see com.liferay.tutorial.service.impl.TutorialStepLocalServiceImpl
 * @generated
 */
public class TutorialStepLocalServiceUtil {
    private static TutorialStepLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.tutorial.service.impl.TutorialStepLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the tutorial step to the database. Also notifies the appropriate model listeners.
    *
    * @param tutorialStep the tutorial step
    * @return the tutorial step that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep addTutorialStep(
        com.liferay.tutorial.model.TutorialStep tutorialStep)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addTutorialStep(tutorialStep);
    }

    /**
    * Creates a new tutorial step with the primary key. Does not add the tutorial step to the database.
    *
    * @param stepId the primary key for the new tutorial step
    * @return the new tutorial step
    */
    public static com.liferay.tutorial.model.TutorialStep createTutorialStep(
        long stepId) {
        return getService().createTutorialStep(stepId);
    }

    /**
    * Deletes the tutorial step with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param stepId the primary key of the tutorial step
    * @return the tutorial step that was removed
    * @throws PortalException if a tutorial step with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep deleteTutorialStep(
        long stepId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteTutorialStep(stepId);
    }

    /**
    * Deletes the tutorial step from the database. Also notifies the appropriate model listeners.
    *
    * @param tutorialStep the tutorial step
    * @return the tutorial step that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep deleteTutorialStep(
        com.liferay.tutorial.model.TutorialStep tutorialStep)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteTutorialStep(tutorialStep);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.tutorial.model.impl.TutorialStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.tutorial.model.impl.TutorialStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.liferay.tutorial.model.TutorialStep fetchTutorialStep(
        long stepId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchTutorialStep(stepId);
    }

    /**
    * Returns the tutorial step with the primary key.
    *
    * @param stepId the primary key of the tutorial step
    * @return the tutorial step
    * @throws PortalException if a tutorial step with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep getTutorialStep(
        long stepId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getTutorialStep(stepId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the tutorial steps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.tutorial.model.impl.TutorialStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of tutorial steps
    * @param end the upper bound of the range of tutorial steps (not inclusive)
    * @return the range of tutorial steps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.tutorial.model.TutorialStep> getTutorialSteps(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTutorialSteps(start, end);
    }

    /**
    * Returns the number of tutorial steps.
    *
    * @return the number of tutorial steps
    * @throws SystemException if a system exception occurred
    */
    public static int getTutorialStepsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTutorialStepsCount();
    }

    /**
    * Updates the tutorial step in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param tutorialStep the tutorial step
    * @return the tutorial step that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep updateTutorialStep(
        com.liferay.tutorial.model.TutorialStep tutorialStep)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateTutorialStep(tutorialStep);
    }

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

    public static com.liferay.tutorial.model.TutorialStep addNewTutorialStep(
        com.liferay.tutorial.model.TutorialStep tutorialStep)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addNewTutorialStep(tutorialStep);
    }

    public static java.util.List<com.liferay.tutorial.model.TutorialStep> getTutorialSteps(
        long companyId, long groupId, long plid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getTutorialSteps(companyId, groupId, plid);
    }

    public static void clearService() {
        _service = null;
    }

    public static TutorialStepLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    TutorialStepLocalService.class.getName());

            if (invokableLocalService instanceof TutorialStepLocalService) {
                _service = (TutorialStepLocalService) invokableLocalService;
            } else {
                _service = new TutorialStepLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(TutorialStepLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(TutorialStepLocalService service) {
    }
}
