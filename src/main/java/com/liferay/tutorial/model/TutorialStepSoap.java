package com.liferay.tutorial.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.tutorial.service.http.TutorialStepServiceSoap}.
 *
 * @author Miroslav Ligas
 * @see com.liferay.tutorial.service.http.TutorialStepServiceSoap
 * @generated
 */
public class TutorialStepSoap implements Serializable {
    private long _stepId;
    private long _companyId;
    private long _groupId;
    private long _plid;
    private int _sequence;
    private String _message;
    private String _position;
    private String _alignPosition;
    private String _node;
    private String _action;
    private String _actionValue;

    public TutorialStepSoap() {
    }

    public static TutorialStepSoap toSoapModel(TutorialStep model) {
        TutorialStepSoap soapModel = new TutorialStepSoap();

        soapModel.setStepId(model.getStepId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setPlid(model.getPlid());
        soapModel.setSequence(model.getSequence());
        soapModel.setMessage(model.getMessage());
        soapModel.setPosition(model.getPosition());
        soapModel.setAlignPosition(model.getAlignPosition());
        soapModel.setNode(model.getNode());
        soapModel.setAction(model.getAction());
        soapModel.setActionValue(model.getActionValue());

        return soapModel;
    }

    public static TutorialStepSoap[] toSoapModels(TutorialStep[] models) {
        TutorialStepSoap[] soapModels = new TutorialStepSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static TutorialStepSoap[][] toSoapModels(TutorialStep[][] models) {
        TutorialStepSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new TutorialStepSoap[models.length][models[0].length];
        } else {
            soapModels = new TutorialStepSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static TutorialStepSoap[] toSoapModels(List<TutorialStep> models) {
        List<TutorialStepSoap> soapModels = new ArrayList<TutorialStepSoap>(models.size());

        for (TutorialStep model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new TutorialStepSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _stepId;
    }

    public void setPrimaryKey(long pk) {
        setStepId(pk);
    }

    public long getStepId() {
        return _stepId;
    }

    public void setStepId(long stepId) {
        _stepId = stepId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getPlid() {
        return _plid;
    }

    public void setPlid(long plid) {
        _plid = plid;
    }

    public int getSequence() {
        return _sequence;
    }

    public void setSequence(int sequence) {
        _sequence = sequence;
    }

    public String getMessage() {
        return _message;
    }

    public void setMessage(String message) {
        _message = message;
    }

    public String getPosition() {
        return _position;
    }

    public void setPosition(String position) {
        _position = position;
    }

    public String getAlignPosition() {
        return _alignPosition;
    }

    public void setAlignPosition(String alignPosition) {
        _alignPosition = alignPosition;
    }

    public String getNode() {
        return _node;
    }

    public void setNode(String node) {
        _node = node;
    }

    public String getAction() {
        return _action;
    }

    public void setAction(String action) {
        _action = action;
    }

    public String getActionValue() {
        return _actionValue;
    }

    public void setActionValue(String actionValue) {
        _actionValue = actionValue;
    }
}
