package com.liferay.tutorial.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.tutorial.model.TutorialStep;

import java.util.List;

/**
 * The persistence utility for the tutorial step service. This utility wraps {@link TutorialStepPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Ligas
 * @see TutorialStepPersistence
 * @see TutorialStepPersistenceImpl
 * @generated
 */
public class TutorialStepUtil {
    private static TutorialStepPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(TutorialStep tutorialStep) {
        getPersistence().clearCache(tutorialStep);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<TutorialStep> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<TutorialStep> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<TutorialStep> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static TutorialStep update(TutorialStep tutorialStep)
        throws SystemException {
        return getPersistence().update(tutorialStep);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static TutorialStep update(TutorialStep tutorialStep,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(tutorialStep, serviceContext);
    }

    /**
    * Returns all the tutorial steps where companyId = &#63; and groupId = &#63; and plid = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param plid the plid
    * @return the matching tutorial steps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.tutorial.model.TutorialStep> findByC_G_P(
        long companyId, long groupId, long plid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G_P(companyId, groupId, plid);
    }

    /**
    * Returns a range of all the tutorial steps where companyId = &#63; and groupId = &#63; and plid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.tutorial.model.impl.TutorialStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param plid the plid
    * @param start the lower bound of the range of tutorial steps
    * @param end the upper bound of the range of tutorial steps (not inclusive)
    * @return the range of matching tutorial steps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.tutorial.model.TutorialStep> findByC_G_P(
        long companyId, long groupId, long plid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G_P(companyId, groupId, plid, start, end);
    }

    /**
    * Returns an ordered range of all the tutorial steps where companyId = &#63; and groupId = &#63; and plid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.tutorial.model.impl.TutorialStepModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param plid the plid
    * @param start the lower bound of the range of tutorial steps
    * @param end the upper bound of the range of tutorial steps (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching tutorial steps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.tutorial.model.TutorialStep> findByC_G_P(
        long companyId, long groupId, long plid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_G_P(companyId, groupId, plid, start, end,
            orderByComparator);
    }

    /**
    * Returns the first tutorial step in the ordered set where companyId = &#63; and groupId = &#63; and plid = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param plid the plid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tutorial step
    * @throws com.liferay.tutorial.NoSuchStepException if a matching tutorial step could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep findByC_G_P_First(
        long companyId, long groupId, long plid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.tutorial.NoSuchStepException {
        return getPersistence()
                   .findByC_G_P_First(companyId, groupId, plid,
            orderByComparator);
    }

    /**
    * Returns the first tutorial step in the ordered set where companyId = &#63; and groupId = &#63; and plid = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param plid the plid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching tutorial step, or <code>null</code> if a matching tutorial step could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep fetchByC_G_P_First(
        long companyId, long groupId, long plid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_P_First(companyId, groupId, plid,
            orderByComparator);
    }

    /**
    * Returns the last tutorial step in the ordered set where companyId = &#63; and groupId = &#63; and plid = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param plid the plid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tutorial step
    * @throws com.liferay.tutorial.NoSuchStepException if a matching tutorial step could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep findByC_G_P_Last(
        long companyId, long groupId, long plid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.tutorial.NoSuchStepException {
        return getPersistence()
                   .findByC_G_P_Last(companyId, groupId, plid, orderByComparator);
    }

    /**
    * Returns the last tutorial step in the ordered set where companyId = &#63; and groupId = &#63; and plid = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param plid the plid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching tutorial step, or <code>null</code> if a matching tutorial step could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep fetchByC_G_P_Last(
        long companyId, long groupId, long plid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_P_Last(companyId, groupId, plid,
            orderByComparator);
    }

    /**
    * Returns the tutorial steps before and after the current tutorial step in the ordered set where companyId = &#63; and groupId = &#63; and plid = &#63;.
    *
    * @param stepId the primary key of the current tutorial step
    * @param companyId the company ID
    * @param groupId the group ID
    * @param plid the plid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next tutorial step
    * @throws com.liferay.tutorial.NoSuchStepException if a tutorial step with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep[] findByC_G_P_PrevAndNext(
        long stepId, long companyId, long groupId, long plid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.tutorial.NoSuchStepException {
        return getPersistence()
                   .findByC_G_P_PrevAndNext(stepId, companyId, groupId, plid,
            orderByComparator);
    }

    /**
    * Removes all the tutorial steps where companyId = &#63; and groupId = &#63; and plid = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param plid the plid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_G_P(long companyId, long groupId, long plid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_G_P(companyId, groupId, plid);
    }

    /**
    * Returns the number of tutorial steps where companyId = &#63; and groupId = &#63; and plid = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param plid the plid
    * @return the number of matching tutorial steps
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_G_P(long companyId, long groupId, long plid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_G_P(companyId, groupId, plid);
    }

    /**
    * Caches the tutorial step in the entity cache if it is enabled.
    *
    * @param tutorialStep the tutorial step
    */
    public static void cacheResult(
        com.liferay.tutorial.model.TutorialStep tutorialStep) {
        getPersistence().cacheResult(tutorialStep);
    }

    /**
    * Caches the tutorial steps in the entity cache if it is enabled.
    *
    * @param tutorialSteps the tutorial steps
    */
    public static void cacheResult(
        java.util.List<com.liferay.tutorial.model.TutorialStep> tutorialSteps) {
        getPersistence().cacheResult(tutorialSteps);
    }

    /**
    * Creates a new tutorial step with the primary key. Does not add the tutorial step to the database.
    *
    * @param stepId the primary key for the new tutorial step
    * @return the new tutorial step
    */
    public static com.liferay.tutorial.model.TutorialStep create(long stepId) {
        return getPersistence().create(stepId);
    }

    /**
    * Removes the tutorial step with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param stepId the primary key of the tutorial step
    * @return the tutorial step that was removed
    * @throws com.liferay.tutorial.NoSuchStepException if a tutorial step with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep remove(long stepId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.tutorial.NoSuchStepException {
        return getPersistence().remove(stepId);
    }

    public static com.liferay.tutorial.model.TutorialStep updateImpl(
        com.liferay.tutorial.model.TutorialStep tutorialStep)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(tutorialStep);
    }

    /**
    * Returns the tutorial step with the primary key or throws a {@link com.liferay.tutorial.NoSuchStepException} if it could not be found.
    *
    * @param stepId the primary key of the tutorial step
    * @return the tutorial step
    * @throws com.liferay.tutorial.NoSuchStepException if a tutorial step with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep findByPrimaryKey(
        long stepId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.liferay.tutorial.NoSuchStepException {
        return getPersistence().findByPrimaryKey(stepId);
    }

    /**
    * Returns the tutorial step with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param stepId the primary key of the tutorial step
    * @return the tutorial step, or <code>null</code> if a tutorial step with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.tutorial.model.TutorialStep fetchByPrimaryKey(
        long stepId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(stepId);
    }

    /**
    * Returns all the tutorial steps.
    *
    * @return the tutorial steps
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.tutorial.model.TutorialStep> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.liferay.tutorial.model.TutorialStep> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.liferay.tutorial.model.TutorialStep> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the tutorial steps from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of tutorial steps.
    *
    * @return the number of tutorial steps
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static TutorialStepPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (TutorialStepPersistence) PortletBeanLocatorUtil.locate(com.liferay.tutorial.service.ClpSerializer.getServletContextName(),
                    TutorialStepPersistence.class.getName());

            ReferenceRegistry.registerReference(TutorialStepUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(TutorialStepPersistence persistence) {
    }
}
