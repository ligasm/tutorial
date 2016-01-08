package com.liferay.tutorial.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.tutorial.NoSuchStepException;
import com.liferay.tutorial.model.TutorialStep;
import com.liferay.tutorial.model.impl.TutorialStepImpl;
import com.liferay.tutorial.model.impl.TutorialStepModelImpl;
import com.liferay.tutorial.service.persistence.TutorialStepPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tutorial step service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Ligas
 * @see TutorialStepPersistence
 * @see TutorialStepUtil
 * @generated
 */
public class TutorialStepPersistenceImpl extends BasePersistenceImpl<TutorialStep>
    implements TutorialStepPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link TutorialStepUtil} to access the tutorial step persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = TutorialStepImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
            TutorialStepModelImpl.FINDER_CACHE_ENABLED, TutorialStepImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
            TutorialStepModelImpl.FINDER_CACHE_ENABLED, TutorialStepImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
            TutorialStepModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_P = new FinderPath(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
            TutorialStepModelImpl.FINDER_CACHE_ENABLED, TutorialStepImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_P",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_P = new FinderPath(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
            TutorialStepModelImpl.FINDER_CACHE_ENABLED, TutorialStepImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G_P",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            },
            TutorialStepModelImpl.COMPANYID_COLUMN_BITMASK |
            TutorialStepModelImpl.GROUPID_COLUMN_BITMASK |
            TutorialStepModelImpl.PLID_COLUMN_BITMASK |
            TutorialStepModelImpl.SEQUENCE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G_P = new FinderPath(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
            TutorialStepModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G_P",
            new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            });
    private static final String _FINDER_COLUMN_C_G_P_COMPANYID_2 = "tutorialStep.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_P_GROUPID_2 = "tutorialStep.groupId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_P_PLID_2 = "tutorialStep.plid = ?";
    private static final String _SQL_SELECT_TUTORIALSTEP = "SELECT tutorialStep FROM TutorialStep tutorialStep";
    private static final String _SQL_SELECT_TUTORIALSTEP_WHERE = "SELECT tutorialStep FROM TutorialStep tutorialStep WHERE ";
    private static final String _SQL_COUNT_TUTORIALSTEP = "SELECT COUNT(tutorialStep) FROM TutorialStep tutorialStep";
    private static final String _SQL_COUNT_TUTORIALSTEP_WHERE = "SELECT COUNT(tutorialStep) FROM TutorialStep tutorialStep WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "tutorialStep.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TutorialStep exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TutorialStep exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(TutorialStepPersistenceImpl.class);
    private static TutorialStep _nullTutorialStep = new TutorialStepImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<TutorialStep> toCacheModel() {
                return _nullTutorialStepCacheModel;
            }
        };

    private static CacheModel<TutorialStep> _nullTutorialStepCacheModel = new CacheModel<TutorialStep>() {
            @Override
            public TutorialStep toEntityModel() {
                return _nullTutorialStep;
            }
        };

    public TutorialStepPersistenceImpl() {
        setModelClass(TutorialStep.class);
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
    @Override
    public List<TutorialStep> findByC_G_P(long companyId, long groupId,
        long plid) throws SystemException {
        return findByC_G_P(companyId, groupId, plid, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<TutorialStep> findByC_G_P(long companyId, long groupId,
        long plid, int start, int end) throws SystemException {
        return findByC_G_P(companyId, groupId, plid, start, end, null);
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
    @Override
    public List<TutorialStep> findByC_G_P(long companyId, long groupId,
        long plid, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_P;
            finderArgs = new Object[] { companyId, groupId, plid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_P;
            finderArgs = new Object[] {
                    companyId, groupId, plid,
                    
                    start, end, orderByComparator
                };
        }

        List<TutorialStep> list = (List<TutorialStep>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (TutorialStep tutorialStep : list) {
                if ((companyId != tutorialStep.getCompanyId()) ||
                        (groupId != tutorialStep.getGroupId()) ||
                        (plid != tutorialStep.getPlid())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_TUTORIALSTEP_WHERE);

            query.append(_FINDER_COLUMN_C_G_P_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_P_GROUPID_2);

            query.append(_FINDER_COLUMN_C_G_P_PLID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TutorialStepModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                qPos.add(plid);

                if (!pagination) {
                    list = (List<TutorialStep>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<TutorialStep>(list);
                } else {
                    list = (List<TutorialStep>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public TutorialStep findByC_G_P_First(long companyId, long groupId,
        long plid, OrderByComparator orderByComparator)
        throws NoSuchStepException, SystemException {
        TutorialStep tutorialStep = fetchByC_G_P_First(companyId, groupId,
                plid, orderByComparator);

        if (tutorialStep != null) {
            return tutorialStep;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(", plid=");
        msg.append(plid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchStepException(msg.toString());
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
    @Override
    public TutorialStep fetchByC_G_P_First(long companyId, long groupId,
        long plid, OrderByComparator orderByComparator)
        throws SystemException {
        List<TutorialStep> list = findByC_G_P(companyId, groupId, plid, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public TutorialStep findByC_G_P_Last(long companyId, long groupId,
        long plid, OrderByComparator orderByComparator)
        throws NoSuchStepException, SystemException {
        TutorialStep tutorialStep = fetchByC_G_P_Last(companyId, groupId, plid,
                orderByComparator);

        if (tutorialStep != null) {
            return tutorialStep;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(", plid=");
        msg.append(plid);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchStepException(msg.toString());
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
    @Override
    public TutorialStep fetchByC_G_P_Last(long companyId, long groupId,
        long plid, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByC_G_P(companyId, groupId, plid);

        if (count == 0) {
            return null;
        }

        List<TutorialStep> list = findByC_G_P(companyId, groupId, plid,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public TutorialStep[] findByC_G_P_PrevAndNext(long stepId, long companyId,
        long groupId, long plid, OrderByComparator orderByComparator)
        throws NoSuchStepException, SystemException {
        TutorialStep tutorialStep = findByPrimaryKey(stepId);

        Session session = null;

        try {
            session = openSession();

            TutorialStep[] array = new TutorialStepImpl[3];

            array[0] = getByC_G_P_PrevAndNext(session, tutorialStep, companyId,
                    groupId, plid, orderByComparator, true);

            array[1] = tutorialStep;

            array[2] = getByC_G_P_PrevAndNext(session, tutorialStep, companyId,
                    groupId, plid, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected TutorialStep getByC_G_P_PrevAndNext(Session session,
        TutorialStep tutorialStep, long companyId, long groupId, long plid,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TUTORIALSTEP_WHERE);

        query.append(_FINDER_COLUMN_C_G_P_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_G_P_GROUPID_2);

        query.append(_FINDER_COLUMN_C_G_P_PLID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(TutorialStepModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        qPos.add(plid);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(tutorialStep);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<TutorialStep> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the tutorial steps where companyId = &#63; and groupId = &#63; and plid = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @param plid the plid
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_G_P(long companyId, long groupId, long plid)
        throws SystemException {
        for (TutorialStep tutorialStep : findByC_G_P(companyId, groupId, plid,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(tutorialStep);
        }
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
    @Override
    public int countByC_G_P(long companyId, long groupId, long plid)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G_P;

        Object[] finderArgs = new Object[] { companyId, groupId, plid };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_TUTORIALSTEP_WHERE);

            query.append(_FINDER_COLUMN_C_G_P_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_P_GROUPID_2);

            query.append(_FINDER_COLUMN_C_G_P_PLID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                qPos.add(plid);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the tutorial step in the entity cache if it is enabled.
     *
     * @param tutorialStep the tutorial step
     */
    @Override
    public void cacheResult(TutorialStep tutorialStep) {
        EntityCacheUtil.putResult(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
            TutorialStepImpl.class, tutorialStep.getPrimaryKey(), tutorialStep);

        tutorialStep.resetOriginalValues();
    }

    /**
     * Caches the tutorial steps in the entity cache if it is enabled.
     *
     * @param tutorialSteps the tutorial steps
     */
    @Override
    public void cacheResult(List<TutorialStep> tutorialSteps) {
        for (TutorialStep tutorialStep : tutorialSteps) {
            if (EntityCacheUtil.getResult(
                        TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
                        TutorialStepImpl.class, tutorialStep.getPrimaryKey()) == null) {
                cacheResult(tutorialStep);
            } else {
                tutorialStep.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all tutorial steps.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(TutorialStepImpl.class.getName());
        }

        EntityCacheUtil.clearCache(TutorialStepImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the tutorial step.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(TutorialStep tutorialStep) {
        EntityCacheUtil.removeResult(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
            TutorialStepImpl.class, tutorialStep.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<TutorialStep> tutorialSteps) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (TutorialStep tutorialStep : tutorialSteps) {
            EntityCacheUtil.removeResult(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
                TutorialStepImpl.class, tutorialStep.getPrimaryKey());
        }
    }

    /**
     * Creates a new tutorial step with the primary key. Does not add the tutorial step to the database.
     *
     * @param stepId the primary key for the new tutorial step
     * @return the new tutorial step
     */
    @Override
    public TutorialStep create(long stepId) {
        TutorialStep tutorialStep = new TutorialStepImpl();

        tutorialStep.setNew(true);
        tutorialStep.setPrimaryKey(stepId);

        return tutorialStep;
    }

    /**
     * Removes the tutorial step with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param stepId the primary key of the tutorial step
     * @return the tutorial step that was removed
     * @throws com.liferay.tutorial.NoSuchStepException if a tutorial step with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TutorialStep remove(long stepId)
        throws NoSuchStepException, SystemException {
        return remove((Serializable) stepId);
    }

    /**
     * Removes the tutorial step with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the tutorial step
     * @return the tutorial step that was removed
     * @throws com.liferay.tutorial.NoSuchStepException if a tutorial step with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TutorialStep remove(Serializable primaryKey)
        throws NoSuchStepException, SystemException {
        Session session = null;

        try {
            session = openSession();

            TutorialStep tutorialStep = (TutorialStep) session.get(TutorialStepImpl.class,
                    primaryKey);

            if (tutorialStep == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchStepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(tutorialStep);
        } catch (NoSuchStepException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected TutorialStep removeImpl(TutorialStep tutorialStep)
        throws SystemException {
        tutorialStep = toUnwrappedModel(tutorialStep);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(tutorialStep)) {
                tutorialStep = (TutorialStep) session.get(TutorialStepImpl.class,
                        tutorialStep.getPrimaryKeyObj());
            }

            if (tutorialStep != null) {
                session.delete(tutorialStep);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (tutorialStep != null) {
            clearCache(tutorialStep);
        }

        return tutorialStep;
    }

    @Override
    public TutorialStep updateImpl(
        com.liferay.tutorial.model.TutorialStep tutorialStep)
        throws SystemException {
        tutorialStep = toUnwrappedModel(tutorialStep);

        boolean isNew = tutorialStep.isNew();

        TutorialStepModelImpl tutorialStepModelImpl = (TutorialStepModelImpl) tutorialStep;

        Session session = null;

        try {
            session = openSession();

            if (tutorialStep.isNew()) {
                session.save(tutorialStep);

                tutorialStep.setNew(false);
            } else {
                session.merge(tutorialStep);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !TutorialStepModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((tutorialStepModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_P.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        tutorialStepModelImpl.getOriginalCompanyId(),
                        tutorialStepModelImpl.getOriginalGroupId(),
                        tutorialStepModelImpl.getOriginalPlid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_P, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_P,
                    args);

                args = new Object[] {
                        tutorialStepModelImpl.getCompanyId(),
                        tutorialStepModelImpl.getGroupId(),
                        tutorialStepModelImpl.getPlid()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G_P, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G_P,
                    args);
            }
        }

        EntityCacheUtil.putResult(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
            TutorialStepImpl.class, tutorialStep.getPrimaryKey(), tutorialStep);

        return tutorialStep;
    }

    protected TutorialStep toUnwrappedModel(TutorialStep tutorialStep) {
        if (tutorialStep instanceof TutorialStepImpl) {
            return tutorialStep;
        }

        TutorialStepImpl tutorialStepImpl = new TutorialStepImpl();

        tutorialStepImpl.setNew(tutorialStep.isNew());
        tutorialStepImpl.setPrimaryKey(tutorialStep.getPrimaryKey());

        tutorialStepImpl.setStepId(tutorialStep.getStepId());
        tutorialStepImpl.setCompanyId(tutorialStep.getCompanyId());
        tutorialStepImpl.setGroupId(tutorialStep.getGroupId());
        tutorialStepImpl.setPlid(tutorialStep.getPlid());
        tutorialStepImpl.setSequence(tutorialStep.getSequence());
        tutorialStepImpl.setMessage(tutorialStep.getMessage());
        tutorialStepImpl.setPosition(tutorialStep.getPosition());
        tutorialStepImpl.setNode(tutorialStep.getNode());
        tutorialStepImpl.setAction(tutorialStep.getAction());
        tutorialStepImpl.setActionValue(tutorialStep.getActionValue());

        return tutorialStepImpl;
    }

    /**
     * Returns the tutorial step with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the tutorial step
     * @return the tutorial step
     * @throws com.liferay.tutorial.NoSuchStepException if a tutorial step with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TutorialStep findByPrimaryKey(Serializable primaryKey)
        throws NoSuchStepException, SystemException {
        TutorialStep tutorialStep = fetchByPrimaryKey(primaryKey);

        if (tutorialStep == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchStepException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return tutorialStep;
    }

    /**
     * Returns the tutorial step with the primary key or throws a {@link com.liferay.tutorial.NoSuchStepException} if it could not be found.
     *
     * @param stepId the primary key of the tutorial step
     * @return the tutorial step
     * @throws com.liferay.tutorial.NoSuchStepException if a tutorial step with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TutorialStep findByPrimaryKey(long stepId)
        throws NoSuchStepException, SystemException {
        return findByPrimaryKey((Serializable) stepId);
    }

    /**
     * Returns the tutorial step with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the tutorial step
     * @return the tutorial step, or <code>null</code> if a tutorial step with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TutorialStep fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        TutorialStep tutorialStep = (TutorialStep) EntityCacheUtil.getResult(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
                TutorialStepImpl.class, primaryKey);

        if (tutorialStep == _nullTutorialStep) {
            return null;
        }

        if (tutorialStep == null) {
            Session session = null;

            try {
                session = openSession();

                tutorialStep = (TutorialStep) session.get(TutorialStepImpl.class,
                        primaryKey);

                if (tutorialStep != null) {
                    cacheResult(tutorialStep);
                } else {
                    EntityCacheUtil.putResult(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
                        TutorialStepImpl.class, primaryKey, _nullTutorialStep);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(TutorialStepModelImpl.ENTITY_CACHE_ENABLED,
                    TutorialStepImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return tutorialStep;
    }

    /**
     * Returns the tutorial step with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param stepId the primary key of the tutorial step
     * @return the tutorial step, or <code>null</code> if a tutorial step with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TutorialStep fetchByPrimaryKey(long stepId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) stepId);
    }

    /**
     * Returns all the tutorial steps.
     *
     * @return the tutorial steps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<TutorialStep> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<TutorialStep> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<TutorialStep> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<TutorialStep> list = (List<TutorialStep>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_TUTORIALSTEP);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_TUTORIALSTEP;

                if (pagination) {
                    sql = sql.concat(TutorialStepModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<TutorialStep>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<TutorialStep>(list);
                } else {
                    list = (List<TutorialStep>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the tutorial steps from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (TutorialStep tutorialStep : findAll()) {
            remove(tutorialStep);
        }
    }

    /**
     * Returns the number of tutorial steps.
     *
     * @return the number of tutorial steps
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_TUTORIALSTEP);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the tutorial step persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.tutorial.model.TutorialStep")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<TutorialStep>> listenersList = new ArrayList<ModelListener<TutorialStep>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<TutorialStep>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(TutorialStepImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
