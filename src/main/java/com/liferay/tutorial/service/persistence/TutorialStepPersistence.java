package com.liferay.tutorial.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.tutorial.model.TutorialStep;

/**
 * The persistence interface for the tutorial step service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Ligas
 * @see TutorialStepPersistenceImpl
 * @see TutorialStepUtil
 * @generated
 */
public interface TutorialStepPersistence extends BasePersistence<TutorialStep> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link TutorialStepUtil} to access the tutorial step persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the tutorial step in the entity cache if it is enabled.
    *
    * @param tutorialStep the tutorial step
    */
    public void cacheResult(
        com.liferay.tutorial.model.TutorialStep tutorialStep);

    /**
    * Caches the tutorial steps in the entity cache if it is enabled.
    *
    * @param tutorialSteps the tutorial steps
    */
    public void cacheResult(
        java.util.List<com.liferay.tutorial.model.TutorialStep> tutorialSteps);

    /**
    * Creates a new tutorial step with the primary key. Does not add the tutorial step to the database.
    *
    * @param stepId the primary key for the new tutorial step
    * @return the new tutorial step
    */
    public com.liferay.tutorial.model.TutorialStep create(long stepId);

    /**
    * Removes the tutorial step with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param stepId the primary key of the tutorial step
    * @return the tutorial step that was removed
    * @throws com.liferay.tutorial.NoSuchStepException if a tutorial step with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.tutorial.model.TutorialStep remove(long stepId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.tutorial.NoSuchStepException;

    public com.liferay.tutorial.model.TutorialStep updateImpl(
        com.liferay.tutorial.model.TutorialStep tutorialStep)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the tutorial step with the primary key or throws a {@link com.liferay.tutorial.NoSuchStepException} if it could not be found.
    *
    * @param stepId the primary key of the tutorial step
    * @return the tutorial step
    * @throws com.liferay.tutorial.NoSuchStepException if a tutorial step with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.tutorial.model.TutorialStep findByPrimaryKey(long stepId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.tutorial.NoSuchStepException;

    /**
    * Returns the tutorial step with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param stepId the primary key of the tutorial step
    * @return the tutorial step, or <code>null</code> if a tutorial step with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.tutorial.model.TutorialStep fetchByPrimaryKey(
        long stepId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the tutorial steps.
    *
    * @return the tutorial steps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.tutorial.model.TutorialStep> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.tutorial.model.TutorialStep> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the tutorial steps.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.tutorial.model.impl.TutorialStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of tutorial steps
    * @param end the upper bound of the range of tutorial steps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of tutorial steps
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.tutorial.model.TutorialStep> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the tutorial steps from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of tutorial steps.
    *
    * @return the number of tutorial steps
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
