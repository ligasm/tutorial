package com.liferay.tutorial.model.impl;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.tutorial.model.TutorialStep;
import com.liferay.tutorial.model.TutorialStepModel;
import com.liferay.tutorial.model.TutorialStepSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the TutorialStep service. Represents a row in the &quot;Tutorial_TutorialStep&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.tutorial.model.TutorialStepModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TutorialStepImpl}.
 * </p>
 *
 * @author Miroslav Ligas
 * @see TutorialStepImpl
 * @see com.liferay.tutorial.model.TutorialStep
 * @see com.liferay.tutorial.model.TutorialStepModel
 * @generated
 */
@JSON(strict = true)
public class TutorialStepModelImpl extends BaseModelImpl<TutorialStep>
    implements TutorialStepModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a tutorial step model instance should use the {@link com.liferay.tutorial.model.TutorialStep} interface instead.
     */
    public static final String TABLE_NAME = "Tutorial_TutorialStep";
    public static final Object[][] TABLE_COLUMNS = {
            { "stepId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "plid", Types.BIGINT },
            { "sequence", Types.INTEGER },
            { "message", Types.VARCHAR },
            { "position", Types.VARCHAR },
            { "alignPosition", Types.VARCHAR },
            { "node", Types.VARCHAR },
            { "action", Types.VARCHAR },
            { "actionValue", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table Tutorial_TutorialStep (stepId LONG not null primary key,companyId LONG,groupId LONG,plid LONG,sequence INTEGER,message STRING null,position VARCHAR(75) null,alignPosition VARCHAR(75) null,node VARCHAR(255) null,action VARCHAR(75) null,actionValue VARCHAR(255) null)";
    public static final String TABLE_SQL_DROP = "drop table Tutorial_TutorialStep";
    public static final String ORDER_BY_JPQL = " ORDER BY tutorialStep.sequence ASC";
    public static final String ORDER_BY_SQL = " ORDER BY Tutorial_TutorialStep.sequence ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.liferay.tutorial.model.TutorialStep"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.liferay.tutorial.model.TutorialStep"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.liferay.tutorial.model.TutorialStep"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long GROUPID_COLUMN_BITMASK = 2L;
    public static long PLID_COLUMN_BITMASK = 4L;
    public static long SEQUENCE_COLUMN_BITMASK = 8L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.liferay.tutorial.model.TutorialStep"));
    private static ClassLoader _classLoader = TutorialStep.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            TutorialStep.class
        };
    private long _stepId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private long _plid;
    private long _originalPlid;
    private boolean _setOriginalPlid;
    private int _sequence;
    private String _message;
    private String _messageCurrentLanguageId;
    private String _position;
    private String _alignPosition;
    private String _node;
    private String _action;
    private String _actionValue;
    private long _columnBitmask;
    private TutorialStep _escapedModel;

    public TutorialStepModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static TutorialStep toModel(TutorialStepSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        TutorialStep model = new TutorialStepImpl();

        model.setStepId(soapModel.getStepId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setGroupId(soapModel.getGroupId());
        model.setPlid(soapModel.getPlid());
        model.setSequence(soapModel.getSequence());
        model.setMessage(soapModel.getMessage());
        model.setPosition(soapModel.getPosition());
        model.setAlignPosition(soapModel.getAlignPosition());
        model.setNode(soapModel.getNode());
        model.setAction(soapModel.getAction());
        model.setActionValue(soapModel.getActionValue());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<TutorialStep> toModels(TutorialStepSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<TutorialStep> models = new ArrayList<TutorialStep>(soapModels.length);

        for (TutorialStepSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _stepId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setStepId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _stepId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return TutorialStep.class;
    }

    @Override
    public String getModelClassName() {
        return TutorialStep.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("stepId", getStepId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("plid", getPlid());
        attributes.put("sequence", getSequence());
        attributes.put("message", getMessage());
        attributes.put("position", getPosition());
        attributes.put("alignPosition", getAlignPosition());
        attributes.put("node", getNode());
        attributes.put("action", getAction());
        attributes.put("actionValue", getActionValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long stepId = (Long) attributes.get("stepId");

        if (stepId != null) {
            setStepId(stepId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long plid = (Long) attributes.get("plid");

        if (plid != null) {
            setPlid(plid);
        }

        Integer sequence = (Integer) attributes.get("sequence");

        if (sequence != null) {
            setSequence(sequence);
        }

        String message = (String) attributes.get("message");

        if (message != null) {
            setMessage(message);
        }

        String position = (String) attributes.get("position");

        if (position != null) {
            setPosition(position);
        }

        String alignPosition = (String) attributes.get("alignPosition");

        if (alignPosition != null) {
            setAlignPosition(alignPosition);
        }

        String node = (String) attributes.get("node");

        if (node != null) {
            setNode(node);
        }

        String action = (String) attributes.get("action");

        if (action != null) {
            setAction(action);
        }

        String actionValue = (String) attributes.get("actionValue");

        if (actionValue != null) {
            setActionValue(actionValue);
        }
    }

    @JSON
    @Override
    public long getStepId() {
        return _stepId;
    }

    @Override
    public void setStepId(long stepId) {
        _stepId = stepId;
    }

    @JSON
    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @JSON
    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _columnBitmask |= GROUPID_COLUMN_BITMASK;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = _groupId;
        }

        _groupId = groupId;
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
    }

    @JSON
    @Override
    public long getPlid() {
        return _plid;
    }

    @Override
    public void setPlid(long plid) {
        _columnBitmask |= PLID_COLUMN_BITMASK;

        if (!_setOriginalPlid) {
            _setOriginalPlid = true;

            _originalPlid = _plid;
        }

        _plid = plid;
    }

    public long getOriginalPlid() {
        return _originalPlid;
    }

    @JSON
    @Override
    public int getSequence() {
        return _sequence;
    }

    @Override
    public void setSequence(int sequence) {
        _columnBitmask = -1L;

        _sequence = sequence;
    }

    @JSON
    @Override
    public String getMessage() {
        if (_message == null) {
            return StringPool.BLANK;
        } else {
            return _message;
        }
    }

    @Override
    public String getMessage(Locale locale) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getMessage(languageId);
    }

    @Override
    public String getMessage(Locale locale, boolean useDefault) {
        String languageId = LocaleUtil.toLanguageId(locale);

        return getMessage(languageId, useDefault);
    }

    @Override
    public String getMessage(String languageId) {
        return LocalizationUtil.getLocalization(getMessage(), languageId);
    }

    @Override
    public String getMessage(String languageId, boolean useDefault) {
        return LocalizationUtil.getLocalization(getMessage(), languageId,
            useDefault);
    }

    @Override
    public String getMessageCurrentLanguageId() {
        return _messageCurrentLanguageId;
    }

    @JSON
    @Override
    public String getMessageCurrentValue() {
        Locale locale = getLocale(_messageCurrentLanguageId);

        return getMessage(locale);
    }

    @Override
    public Map<Locale, String> getMessageMap() {
        return LocalizationUtil.getLocalizationMap(getMessage());
    }

    @Override
    public void setMessage(String message) {
        _message = message;
    }

    @Override
    public void setMessage(String message, Locale locale) {
        setMessage(message, locale, LocaleUtil.getDefault());
    }

    @Override
    public void setMessage(String message, Locale locale, Locale defaultLocale) {
        String languageId = LocaleUtil.toLanguageId(locale);
        String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

        if (Validator.isNotNull(message)) {
            setMessage(LocalizationUtil.updateLocalization(getMessage(),
                    "Message", message, languageId, defaultLanguageId));
        } else {
            setMessage(LocalizationUtil.removeLocalization(getMessage(),
                    "Message", languageId));
        }
    }

    @Override
    public void setMessageCurrentLanguageId(String languageId) {
        _messageCurrentLanguageId = languageId;
    }

    @Override
    public void setMessageMap(Map<Locale, String> messageMap) {
        setMessageMap(messageMap, LocaleUtil.getDefault());
    }

    @Override
    public void setMessageMap(Map<Locale, String> messageMap,
        Locale defaultLocale) {
        if (messageMap == null) {
            return;
        }

        setMessage(LocalizationUtil.updateLocalization(messageMap,
                getMessage(), "Message", LocaleUtil.toLanguageId(defaultLocale)));
    }

    @JSON
    @Override
    public String getPosition() {
        if (_position == null) {
            return StringPool.BLANK;
        } else {
            return _position;
        }
    }

    @Override
    public void setPosition(String position) {
        _position = position;
    }

    @JSON
    @Override
    public String getAlignPosition() {
        if (_alignPosition == null) {
            return StringPool.BLANK;
        } else {
            return _alignPosition;
        }
    }

    @Override
    public void setAlignPosition(String alignPosition) {
        _alignPosition = alignPosition;
    }

    @JSON
    @Override
    public String getNode() {
        if (_node == null) {
            return StringPool.BLANK;
        } else {
            return _node;
        }
    }

    @Override
    public void setNode(String node) {
        _node = node;
    }

    @JSON
    @Override
    public String getAction() {
        if (_action == null) {
            return StringPool.BLANK;
        } else {
            return _action;
        }
    }

    @Override
    public void setAction(String action) {
        _action = action;
    }

    @JSON
    @Override
    public String getActionValue() {
        if (_actionValue == null) {
            return StringPool.BLANK;
        } else {
            return _actionValue;
        }
    }

    @Override
    public void setActionValue(String actionValue) {
        _actionValue = actionValue;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            TutorialStep.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public String[] getAvailableLanguageIds() {
        Set<String> availableLanguageIds = new TreeSet<String>();

        Map<Locale, String> messageMap = getMessageMap();

        for (Map.Entry<Locale, String> entry : messageMap.entrySet()) {
            Locale locale = entry.getKey();
            String value = entry.getValue();

            if (Validator.isNotNull(value)) {
                availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
            }
        }

        return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
    }

    @Override
    public String getDefaultLanguageId() {
        String xml = getMessage();

        if (xml == null) {
            return StringPool.BLANK;
        }

        Locale defaultLocale = LocaleUtil.getDefault();

        return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
    }

    @Override
    public void prepareLocalizedFieldsForImport() throws LocaleException {
        prepareLocalizedFieldsForImport(null);
    }

    @Override
    @SuppressWarnings("unused")
    public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
        throws LocaleException {
        Locale defaultLocale = LocaleUtil.getDefault();

        String modelDefaultLanguageId = getDefaultLanguageId();

        String message = getMessage(defaultLocale);

        if (Validator.isNull(message)) {
            setMessage(getMessage(modelDefaultLanguageId), defaultLocale);
        } else {
            setMessage(getMessage(defaultLocale), defaultLocale, defaultLocale);
        }
    }

    @Override
    public TutorialStep toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (TutorialStep) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        TutorialStepImpl tutorialStepImpl = new TutorialStepImpl();

        tutorialStepImpl.setStepId(getStepId());
        tutorialStepImpl.setCompanyId(getCompanyId());
        tutorialStepImpl.setGroupId(getGroupId());
        tutorialStepImpl.setPlid(getPlid());
        tutorialStepImpl.setSequence(getSequence());
        tutorialStepImpl.setMessage(getMessage());
        tutorialStepImpl.setPosition(getPosition());
        tutorialStepImpl.setAlignPosition(getAlignPosition());
        tutorialStepImpl.setNode(getNode());
        tutorialStepImpl.setAction(getAction());
        tutorialStepImpl.setActionValue(getActionValue());

        tutorialStepImpl.resetOriginalValues();

        return tutorialStepImpl;
    }

    @Override
    public int compareTo(TutorialStep tutorialStep) {
        int value = 0;

        if (getSequence() < tutorialStep.getSequence()) {
            value = -1;
        } else if (getSequence() > tutorialStep.getSequence()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TutorialStep)) {
            return false;
        }

        TutorialStep tutorialStep = (TutorialStep) obj;

        long primaryKey = tutorialStep.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        TutorialStepModelImpl tutorialStepModelImpl = this;

        tutorialStepModelImpl._originalCompanyId = tutorialStepModelImpl._companyId;

        tutorialStepModelImpl._setOriginalCompanyId = false;

        tutorialStepModelImpl._originalGroupId = tutorialStepModelImpl._groupId;

        tutorialStepModelImpl._setOriginalGroupId = false;

        tutorialStepModelImpl._originalPlid = tutorialStepModelImpl._plid;

        tutorialStepModelImpl._setOriginalPlid = false;

        tutorialStepModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<TutorialStep> toCacheModel() {
        TutorialStepCacheModel tutorialStepCacheModel = new TutorialStepCacheModel();

        tutorialStepCacheModel.stepId = getStepId();

        tutorialStepCacheModel.companyId = getCompanyId();

        tutorialStepCacheModel.groupId = getGroupId();

        tutorialStepCacheModel.plid = getPlid();

        tutorialStepCacheModel.sequence = getSequence();

        tutorialStepCacheModel.message = getMessage();

        String message = tutorialStepCacheModel.message;

        if ((message != null) && (message.length() == 0)) {
            tutorialStepCacheModel.message = null;
        }

        tutorialStepCacheModel.position = getPosition();

        String position = tutorialStepCacheModel.position;

        if ((position != null) && (position.length() == 0)) {
            tutorialStepCacheModel.position = null;
        }

        tutorialStepCacheModel.alignPosition = getAlignPosition();

        String alignPosition = tutorialStepCacheModel.alignPosition;

        if ((alignPosition != null) && (alignPosition.length() == 0)) {
            tutorialStepCacheModel.alignPosition = null;
        }

        tutorialStepCacheModel.node = getNode();

        String node = tutorialStepCacheModel.node;

        if ((node != null) && (node.length() == 0)) {
            tutorialStepCacheModel.node = null;
        }

        tutorialStepCacheModel.action = getAction();

        String action = tutorialStepCacheModel.action;

        if ((action != null) && (action.length() == 0)) {
            tutorialStepCacheModel.action = null;
        }

        tutorialStepCacheModel.actionValue = getActionValue();

        String actionValue = tutorialStepCacheModel.actionValue;

        if ((actionValue != null) && (actionValue.length() == 0)) {
            tutorialStepCacheModel.actionValue = null;
        }

        return tutorialStepCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{stepId=");
        sb.append(getStepId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", plid=");
        sb.append(getPlid());
        sb.append(", sequence=");
        sb.append(getSequence());
        sb.append(", message=");
        sb.append(getMessage());
        sb.append(", position=");
        sb.append(getPosition());
        sb.append(", alignPosition=");
        sb.append(getAlignPosition());
        sb.append(", node=");
        sb.append(getNode());
        sb.append(", action=");
        sb.append(getAction());
        sb.append(", actionValue=");
        sb.append(getActionValue());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(37);

        sb.append("<model><model-name>");
        sb.append("com.liferay.tutorial.model.TutorialStep");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>stepId</column-name><column-value><![CDATA[");
        sb.append(getStepId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>plid</column-name><column-value><![CDATA[");
        sb.append(getPlid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sequence</column-name><column-value><![CDATA[");
        sb.append(getSequence());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>message</column-name><column-value><![CDATA[");
        sb.append(getMessage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>position</column-name><column-value><![CDATA[");
        sb.append(getPosition());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>alignPosition</column-name><column-value><![CDATA[");
        sb.append(getAlignPosition());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>node</column-name><column-value><![CDATA[");
        sb.append(getNode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>action</column-name><column-value><![CDATA[");
        sb.append(getAction());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>actionValue</column-name><column-value><![CDATA[");
        sb.append(getActionValue());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
