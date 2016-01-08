package com.liferay.tutorial.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TutorialStepLocalService}.
 *
 * @author Miroslav Ligas
 * @see TutorialStepLocalService
 * @generated
 */
public class TutorialStepLocalServiceWrapper implements TutorialStepLocalService,
    ServiceWrapper<TutorialStepLocalService> {
    private TutorialStepLocalService _tutorialStepLocalService;

    public TutorialStepLocalServiceWrapper(
        TutorialStepLocalService tutorialStepLocalService) {
        _tutorialStepLocalService = tutorialStepLocalService;
    }

    /**
    * Adds the tutorial step to the database. Also notifies the appropriate model listeners.
    *
    * @param tutorialStep the tutorial step
    * @return the tutorial step that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.tutorial.model.TutorialStep addTutorialStep(
        com.liferay.tutorial.model.TutorialStep tutorialStep)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.addTutorialStep(tutorialStep);
    }

    /**
    * Creates a new tutorial step with the primary key. Does not add the tutorial step to the database.
    *
    * @param stepId the primary key for the new tutorial step
    * @return the new tutorial step
    */
    @Override
    public com.liferay.tutorial.model.TutorialStep createTutorialStep(
        long stepId) {
        return _tutorialStepLocalService.createTutorialStep(stepId);
    }

    /**
    * Deletes the tutorial step with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param stepId the primary key of the tutorial step
    * @return the tutorial step that was removed
    * @throws PortalException if a tutorial step with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.tutorial.model.TutorialStep deleteTutorialStep(
        long stepId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.deleteTutorialStep(stepId);
    }

    /**
    * Deletes the tutorial step from the database. Also notifies the appropriate model listeners.
    *
    * @param tutorialStep the tutorial step
    * @return the tutorial step that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.tutorial.model.TutorialStep deleteTutorialStep(
        com.liferay.tutorial.model.TutorialStep tutorialStep)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.deleteTutorialStep(tutorialStep);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _tutorialStepLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.dynamicQuery(dynamicQuery, start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.liferay.tutorial.model.TutorialStep fetchTutorialStep(
        long stepId) throws com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.fetchTutorialStep(stepId);
    }

    /**
    * Returns the tutorial step with the primary key.
    *
    * @param stepId the primary key of the tutorial step
    * @return the tutorial step
    * @throws PortalException if a tutorial step with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.tutorial.model.TutorialStep getTutorialStep(long stepId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.getTutorialStep(stepId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.liferay.tutorial.model.TutorialStep> getTutorialSteps(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.getTutorialSteps(start, end);
    }

    /**
    * Returns the number of tutorial steps.
    *
    * @return the number of tutorial steps
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getTutorialStepsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.getTutorialStepsCount();
    }

    /**
    * Updates the tutorial step in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param tutorialStep the tutorial step
    * @return the tutorial step that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.tutorial.model.TutorialStep updateTutorialStep(
        com.liferay.tutorial.model.TutorialStep tutorialStep)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.updateTutorialStep(tutorialStep);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _tutorialStepLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _tutorialStepLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _tutorialStepLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.liferay.tutorial.model.TutorialStep addNewTutorialStep(
        com.liferay.tutorial.model.TutorialStep tutorialStep)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.addNewTutorialStep(tutorialStep);
    }

    @Override
    public java.util.List<com.liferay.tutorial.model.TutorialStep> getTutorialSteps(
        long companyId, long groupId, long plid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _tutorialStepLocalService.getTutorialSteps(companyId, groupId,
            plid);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TutorialStepLocalService getWrappedTutorialStepLocalService() {
        return _tutorialStepLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTutorialStepLocalService(
        TutorialStepLocalService tutorialStepLocalService) {
        _tutorialStepLocalService = tutorialStepLocalService;
    }

    @Override
    public TutorialStepLocalService getWrappedService() {
        return _tutorialStepLocalService;
    }

    @Override
    public void setWrappedService(
        TutorialStepLocalService tutorialStepLocalService) {
        _tutorialStepLocalService = tutorialStepLocalService;
    }
}
