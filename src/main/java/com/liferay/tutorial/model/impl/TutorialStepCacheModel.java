package com.liferay.tutorial.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.tutorial.model.TutorialStep;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TutorialStep in entity cache.
 *
 * @author Miroslav Ligas
 * @see TutorialStep
 * @generated
 */
public class TutorialStepCacheModel implements CacheModel<TutorialStep>,
    Externalizable {
    public long stepId;
    public long companyId;
    public long groupId;
    public long plid;
    public int sequence;
    public String message;
    public String position;
    public String alignPosition;
    public String node;
    public String action;
    public String actionValue;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{stepId=");
        sb.append(stepId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", plid=");
        sb.append(plid);
        sb.append(", sequence=");
        sb.append(sequence);
        sb.append(", message=");
        sb.append(message);
        sb.append(", position=");
        sb.append(position);
        sb.append(", alignPosition=");
        sb.append(alignPosition);
        sb.append(", node=");
        sb.append(node);
        sb.append(", action=");
        sb.append(action);
        sb.append(", actionValue=");
        sb.append(actionValue);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public TutorialStep toEntityModel() {
        TutorialStepImpl tutorialStepImpl = new TutorialStepImpl();

        tutorialStepImpl.setStepId(stepId);
        tutorialStepImpl.setCompanyId(companyId);
        tutorialStepImpl.setGroupId(groupId);
        tutorialStepImpl.setPlid(plid);
        tutorialStepImpl.setSequence(sequence);

        if (message == null) {
            tutorialStepImpl.setMessage(StringPool.BLANK);
        } else {
            tutorialStepImpl.setMessage(message);
        }

        if (position == null) {
            tutorialStepImpl.setPosition(StringPool.BLANK);
        } else {
            tutorialStepImpl.setPosition(position);
        }

        if (alignPosition == null) {
            tutorialStepImpl.setAlignPosition(StringPool.BLANK);
        } else {
            tutorialStepImpl.setAlignPosition(alignPosition);
        }

        if (node == null) {
            tutorialStepImpl.setNode(StringPool.BLANK);
        } else {
            tutorialStepImpl.setNode(node);
        }

        if (action == null) {
            tutorialStepImpl.setAction(StringPool.BLANK);
        } else {
            tutorialStepImpl.setAction(action);
        }

        if (actionValue == null) {
            tutorialStepImpl.setActionValue(StringPool.BLANK);
        } else {
            tutorialStepImpl.setActionValue(actionValue);
        }

        tutorialStepImpl.resetOriginalValues();

        return tutorialStepImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        stepId = objectInput.readLong();
        companyId = objectInput.readLong();
        groupId = objectInput.readLong();
        plid = objectInput.readLong();
        sequence = objectInput.readInt();
        message = objectInput.readUTF();
        position = objectInput.readUTF();
        alignPosition = objectInput.readUTF();
        node = objectInput.readUTF();
        action = objectInput.readUTF();
        actionValue = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(stepId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(plid);
        objectOutput.writeInt(sequence);

        if (message == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(message);
        }

        if (position == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(position);
        }

        if (alignPosition == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(alignPosition);
        }

        if (node == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(node);
        }

        if (action == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(action);
        }

        if (actionValue == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(actionValue);
        }
    }
}
