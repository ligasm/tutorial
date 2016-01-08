package com.liferay.tutorial.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.tutorial.service.ClpSerializer;
import com.liferay.tutorial.service.TutorialStepLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class TutorialStepClp extends BaseModelImpl<TutorialStep>
    implements TutorialStep {
    private long _stepId;
    private long _companyId;
    private long _groupId;
    private long _plid;
    private int _sequence;
    private String _message;
    private String _messageCurrentLanguageId;
    private int _position;
    private String _node;
    private String _action;
    private String _actionValue;
    private BaseModel<?> _tutorialStepRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay.tutorial.service.ClpSerializer.class;

    public TutorialStepClp() {
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
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("stepId", getStepId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("plid", getPlid());
        attributes.put("sequence", getSequence());
        attributes.put("message", getMessage());
        attributes.put("position", getPosition());
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

        Integer position = (Integer) attributes.get("position");

        if (position != null) {
            setPosition(position);
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

    @Override
    public long getStepId() {
        return _stepId;
    }

    @Override
    public void setStepId(long stepId) {
        _stepId = stepId;

        if (_tutorialStepRemoteModel != null) {
            try {
                Class<?> clazz = _tutorialStepRemoteModel.getClass();

                Method method = clazz.getMethod("setStepId", long.class);

                method.invoke(_tutorialStepRemoteModel, stepId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_tutorialStepRemoteModel != null) {
            try {
                Class<?> clazz = _tutorialStepRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_tutorialStepRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_tutorialStepRemoteModel != null) {
            try {
                Class<?> clazz = _tutorialStepRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_tutorialStepRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getPlid() {
        return _plid;
    }

    @Override
    public void setPlid(long plid) {
        _plid = plid;

        if (_tutorialStepRemoteModel != null) {
            try {
                Class<?> clazz = _tutorialStepRemoteModel.getClass();

                Method method = clazz.getMethod("setPlid", long.class);

                method.invoke(_tutorialStepRemoteModel, plid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getSequence() {
        return _sequence;
    }

    @Override
    public void setSequence(int sequence) {
        _sequence = sequence;

        if (_tutorialStepRemoteModel != null) {
            try {
                Class<?> clazz = _tutorialStepRemoteModel.getClass();

                Method method = clazz.getMethod("setSequence", int.class);

                method.invoke(_tutorialStepRemoteModel, sequence);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMessage() {
        return _message;
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

        if (_tutorialStepRemoteModel != null) {
            try {
                Class<?> clazz = _tutorialStepRemoteModel.getClass();

                Method method = clazz.getMethod("setMessage", String.class);

                method.invoke(_tutorialStepRemoteModel, message);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
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

        ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(portalClassLoader);
            }

            setMessage(LocalizationUtil.updateLocalization(messageMap,
                    getMessage(), "Message",
                    LocaleUtil.toLanguageId(defaultLocale)));
        } finally {
            if (contextClassLoader != portalClassLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    @Override
    public int getPosition() {
        return _position;
    }

    @Override
    public void setPosition(int position) {
        _position = position;

        if (_tutorialStepRemoteModel != null) {
            try {
                Class<?> clazz = _tutorialStepRemoteModel.getClass();

                Method method = clazz.getMethod("setPosition", int.class);

                method.invoke(_tutorialStepRemoteModel, position);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNode() {
        return _node;
    }

    @Override
    public void setNode(String node) {
        _node = node;

        if (_tutorialStepRemoteModel != null) {
            try {
                Class<?> clazz = _tutorialStepRemoteModel.getClass();

                Method method = clazz.getMethod("setNode", String.class);

                method.invoke(_tutorialStepRemoteModel, node);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAction() {
        return _action;
    }

    @Override
    public void setAction(String action) {
        _action = action;

        if (_tutorialStepRemoteModel != null) {
            try {
                Class<?> clazz = _tutorialStepRemoteModel.getClass();

                Method method = clazz.getMethod("setAction", String.class);

                method.invoke(_tutorialStepRemoteModel, action);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getActionValue() {
        return _actionValue;
    }

    @Override
    public void setActionValue(String actionValue) {
        _actionValue = actionValue;

        if (_tutorialStepRemoteModel != null) {
            try {
                Class<?> clazz = _tutorialStepRemoteModel.getClass();

                Method method = clazz.getMethod("setActionValue", String.class);

                method.invoke(_tutorialStepRemoteModel, actionValue);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getTutorialStepRemoteModel() {
        return _tutorialStepRemoteModel;
    }

    public void setTutorialStepRemoteModel(BaseModel<?> tutorialStepRemoteModel) {
        _tutorialStepRemoteModel = tutorialStepRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _tutorialStepRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_tutorialStepRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            TutorialStepLocalServiceUtil.addTutorialStep(this);
        } else {
            TutorialStepLocalServiceUtil.updateTutorialStep(this);
        }
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
        return (TutorialStep) ProxyUtil.newProxyInstance(TutorialStep.class.getClassLoader(),
            new Class[] { TutorialStep.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        TutorialStepClp clone = new TutorialStepClp();

        clone.setStepId(getStepId());
        clone.setCompanyId(getCompanyId());
        clone.setGroupId(getGroupId());
        clone.setPlid(getPlid());
        clone.setSequence(getSequence());
        clone.setMessage(getMessage());
        clone.setPosition(getPosition());
        clone.setNode(getNode());
        clone.setAction(getAction());
        clone.setActionValue(getActionValue());

        return clone;
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

        if (!(obj instanceof TutorialStepClp)) {
            return false;
        }

        TutorialStepClp tutorialStep = (TutorialStepClp) obj;

        long primaryKey = tutorialStep.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

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
        StringBundler sb = new StringBundler(34);

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
