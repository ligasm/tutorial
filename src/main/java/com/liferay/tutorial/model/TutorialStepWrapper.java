package com.liferay.tutorial.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TutorialStep}.
 * </p>
 *
 * @author Miroslav Ligas
 * @see TutorialStep
 * @generated
 */
public class TutorialStepWrapper implements TutorialStep,
    ModelWrapper<TutorialStep> {
    private TutorialStep _tutorialStep;

    public TutorialStepWrapper(TutorialStep tutorialStep) {
        _tutorialStep = tutorialStep;
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

    /**
    * Returns the primary key of this tutorial step.
    *
    * @return the primary key of this tutorial step
    */
    @Override
    public long getPrimaryKey() {
        return _tutorialStep.getPrimaryKey();
    }

    /**
    * Sets the primary key of this tutorial step.
    *
    * @param primaryKey the primary key of this tutorial step
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _tutorialStep.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the step ID of this tutorial step.
    *
    * @return the step ID of this tutorial step
    */
    @Override
    public long getStepId() {
        return _tutorialStep.getStepId();
    }

    /**
    * Sets the step ID of this tutorial step.
    *
    * @param stepId the step ID of this tutorial step
    */
    @Override
    public void setStepId(long stepId) {
        _tutorialStep.setStepId(stepId);
    }

    /**
    * Returns the company ID of this tutorial step.
    *
    * @return the company ID of this tutorial step
    */
    @Override
    public long getCompanyId() {
        return _tutorialStep.getCompanyId();
    }

    /**
    * Sets the company ID of this tutorial step.
    *
    * @param companyId the company ID of this tutorial step
    */
    @Override
    public void setCompanyId(long companyId) {
        _tutorialStep.setCompanyId(companyId);
    }

    /**
    * Returns the group ID of this tutorial step.
    *
    * @return the group ID of this tutorial step
    */
    @Override
    public long getGroupId() {
        return _tutorialStep.getGroupId();
    }

    /**
    * Sets the group ID of this tutorial step.
    *
    * @param groupId the group ID of this tutorial step
    */
    @Override
    public void setGroupId(long groupId) {
        _tutorialStep.setGroupId(groupId);
    }

    /**
    * Returns the plid of this tutorial step.
    *
    * @return the plid of this tutorial step
    */
    @Override
    public long getPlid() {
        return _tutorialStep.getPlid();
    }

    /**
    * Sets the plid of this tutorial step.
    *
    * @param plid the plid of this tutorial step
    */
    @Override
    public void setPlid(long plid) {
        _tutorialStep.setPlid(plid);
    }

    /**
    * Returns the sequence of this tutorial step.
    *
    * @return the sequence of this tutorial step
    */
    @Override
    public int getSequence() {
        return _tutorialStep.getSequence();
    }

    /**
    * Sets the sequence of this tutorial step.
    *
    * @param sequence the sequence of this tutorial step
    */
    @Override
    public void setSequence(int sequence) {
        _tutorialStep.setSequence(sequence);
    }

    /**
    * Returns the message of this tutorial step.
    *
    * @return the message of this tutorial step
    */
    @Override
    public java.lang.String getMessage() {
        return _tutorialStep.getMessage();
    }

    /**
    * Returns the localized message of this tutorial step in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param locale the locale of the language
    * @return the localized message of this tutorial step
    */
    @Override
    public java.lang.String getMessage(java.util.Locale locale) {
        return _tutorialStep.getMessage(locale);
    }

    /**
    * Returns the localized message of this tutorial step in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param locale the local of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized message of this tutorial step. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
    */
    @Override
    public java.lang.String getMessage(java.util.Locale locale,
        boolean useDefault) {
        return _tutorialStep.getMessage(locale, useDefault);
    }

    /**
    * Returns the localized message of this tutorial step in the language. Uses the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @return the localized message of this tutorial step
    */
    @Override
    public java.lang.String getMessage(java.lang.String languageId) {
        return _tutorialStep.getMessage(languageId);
    }

    /**
    * Returns the localized message of this tutorial step in the language, optionally using the default language if no localization exists for the requested language.
    *
    * @param languageId the ID of the language
    * @param useDefault whether to use the default language if no localization exists for the requested language
    * @return the localized message of this tutorial step
    */
    @Override
    public java.lang.String getMessage(java.lang.String languageId,
        boolean useDefault) {
        return _tutorialStep.getMessage(languageId, useDefault);
    }

    @Override
    public java.lang.String getMessageCurrentLanguageId() {
        return _tutorialStep.getMessageCurrentLanguageId();
    }

    @Override
    public java.lang.String getMessageCurrentValue() {
        return _tutorialStep.getMessageCurrentValue();
    }

    /**
    * Returns a map of the locales and localized messages of this tutorial step.
    *
    * @return the locales and localized messages of this tutorial step
    */
    @Override
    public java.util.Map<java.util.Locale, java.lang.String> getMessageMap() {
        return _tutorialStep.getMessageMap();
    }

    /**
    * Sets the message of this tutorial step.
    *
    * @param message the message of this tutorial step
    */
    @Override
    public void setMessage(java.lang.String message) {
        _tutorialStep.setMessage(message);
    }

    /**
    * Sets the localized message of this tutorial step in the language.
    *
    * @param message the localized message of this tutorial step
    * @param locale the locale of the language
    */
    @Override
    public void setMessage(java.lang.String message, java.util.Locale locale) {
        _tutorialStep.setMessage(message, locale);
    }

    /**
    * Sets the localized message of this tutorial step in the language, and sets the default locale.
    *
    * @param message the localized message of this tutorial step
    * @param locale the locale of the language
    * @param defaultLocale the default locale
    */
    @Override
    public void setMessage(java.lang.String message, java.util.Locale locale,
        java.util.Locale defaultLocale) {
        _tutorialStep.setMessage(message, locale, defaultLocale);
    }

    @Override
    public void setMessageCurrentLanguageId(java.lang.String languageId) {
        _tutorialStep.setMessageCurrentLanguageId(languageId);
    }

    /**
    * Sets the localized messages of this tutorial step from the map of locales and localized messages.
    *
    * @param messageMap the locales and localized messages of this tutorial step
    */
    @Override
    public void setMessageMap(
        java.util.Map<java.util.Locale, java.lang.String> messageMap) {
        _tutorialStep.setMessageMap(messageMap);
    }

    /**
    * Sets the localized messages of this tutorial step from the map of locales and localized messages, and sets the default locale.
    *
    * @param messageMap the locales and localized messages of this tutorial step
    * @param defaultLocale the default locale
    */
    @Override
    public void setMessageMap(
        java.util.Map<java.util.Locale, java.lang.String> messageMap,
        java.util.Locale defaultLocale) {
        _tutorialStep.setMessageMap(messageMap, defaultLocale);
    }

    /**
    * Returns the position of this tutorial step.
    *
    * @return the position of this tutorial step
    */
    @Override
    public java.lang.String getPosition() {
        return _tutorialStep.getPosition();
    }

    /**
    * Sets the position of this tutorial step.
    *
    * @param position the position of this tutorial step
    */
    @Override
    public void setPosition(java.lang.String position) {
        _tutorialStep.setPosition(position);
    }

    /**
    * Returns the align position of this tutorial step.
    *
    * @return the align position of this tutorial step
    */
    @Override
    public java.lang.String getAlignPosition() {
        return _tutorialStep.getAlignPosition();
    }

    /**
    * Sets the align position of this tutorial step.
    *
    * @param alignPosition the align position of this tutorial step
    */
    @Override
    public void setAlignPosition(java.lang.String alignPosition) {
        _tutorialStep.setAlignPosition(alignPosition);
    }

    /**
    * Returns the node of this tutorial step.
    *
    * @return the node of this tutorial step
    */
    @Override
    public java.lang.String getNode() {
        return _tutorialStep.getNode();
    }

    /**
    * Sets the node of this tutorial step.
    *
    * @param node the node of this tutorial step
    */
    @Override
    public void setNode(java.lang.String node) {
        _tutorialStep.setNode(node);
    }

    /**
    * Returns the action of this tutorial step.
    *
    * @return the action of this tutorial step
    */
    @Override
    public java.lang.String getAction() {
        return _tutorialStep.getAction();
    }

    /**
    * Sets the action of this tutorial step.
    *
    * @param action the action of this tutorial step
    */
    @Override
    public void setAction(java.lang.String action) {
        _tutorialStep.setAction(action);
    }

    /**
    * Returns the action value of this tutorial step.
    *
    * @return the action value of this tutorial step
    */
    @Override
    public java.lang.String getActionValue() {
        return _tutorialStep.getActionValue();
    }

    /**
    * Sets the action value of this tutorial step.
    *
    * @param actionValue the action value of this tutorial step
    */
    @Override
    public void setActionValue(java.lang.String actionValue) {
        _tutorialStep.setActionValue(actionValue);
    }

    @Override
    public boolean isNew() {
        return _tutorialStep.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _tutorialStep.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _tutorialStep.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _tutorialStep.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _tutorialStep.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _tutorialStep.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _tutorialStep.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _tutorialStep.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _tutorialStep.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _tutorialStep.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _tutorialStep.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.String[] getAvailableLanguageIds() {
        return _tutorialStep.getAvailableLanguageIds();
    }

    @Override
    public java.lang.String getDefaultLanguageId() {
        return _tutorialStep.getDefaultLanguageId();
    }

    @Override
    public void prepareLocalizedFieldsForImport()
        throws com.liferay.portal.LocaleException {
        _tutorialStep.prepareLocalizedFieldsForImport();
    }

    @Override
    public void prepareLocalizedFieldsForImport(
        java.util.Locale defaultImportLocale)
        throws com.liferay.portal.LocaleException {
        _tutorialStep.prepareLocalizedFieldsForImport(defaultImportLocale);
    }

    @Override
    public java.lang.Object clone() {
        return new TutorialStepWrapper((TutorialStep) _tutorialStep.clone());
    }

    @Override
    public int compareTo(com.liferay.tutorial.model.TutorialStep tutorialStep) {
        return _tutorialStep.compareTo(tutorialStep);
    }

    @Override
    public int hashCode() {
        return _tutorialStep.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.tutorial.model.TutorialStep> toCacheModel() {
        return _tutorialStep.toCacheModel();
    }

    @Override
    public com.liferay.tutorial.model.TutorialStep toEscapedModel() {
        return new TutorialStepWrapper(_tutorialStep.toEscapedModel());
    }

    @Override
    public com.liferay.tutorial.model.TutorialStep toUnescapedModel() {
        return new TutorialStepWrapper(_tutorialStep.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _tutorialStep.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _tutorialStep.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _tutorialStep.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TutorialStepWrapper)) {
            return false;
        }

        TutorialStepWrapper tutorialStepWrapper = (TutorialStepWrapper) obj;

        if (Validator.equals(_tutorialStep, tutorialStepWrapper._tutorialStep)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public TutorialStep getWrappedTutorialStep() {
        return _tutorialStep;
    }

    @Override
    public TutorialStep getWrappedModel() {
        return _tutorialStep;
    }

    @Override
    public void resetOriginalValues() {
        _tutorialStep.resetOriginalValues();
    }
}
