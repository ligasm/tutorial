package com.liferay.tutorial.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.tutorial.model.TutorialStep;
import com.liferay.tutorial.service.base.TutorialStepServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the tutorial step remote service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.tutorial.service.TutorialStepService} interface.
 * <p/>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Miroslav Ligas
 * @see com.liferay.tutorial.service.base.TutorialStepServiceBaseImpl
 * @see com.liferay.tutorial.service.TutorialStepServiceUtil
 */
public class TutorialStepServiceImpl extends TutorialStepServiceBaseImpl {

	public void addTutorialSteps(long companyId, long groupId, long plid, String stepsListJson) throws PortalException, SystemException {
		int i = 0;
		JSONArray stepList = JSONFactoryUtil.createJSONArray(stepsListJson);

		temporaryFixCleanUP(companyId,groupId, plid);

		for (int j = 0; j < stepList.length(); j++) {
			JSONObject step = stepList.getJSONObject(j);

			long id = counterLocalService.increment(TutorialStep.class.getName());
			TutorialStep tutorialStep = tutorialStepLocalService.createTutorialStep(id);

			tutorialStep.setCompanyId(companyId);
			tutorialStep.setGroupId(groupId);
			tutorialStep.setPlid(plid);

			tutorialStep.setSequence(i++);
			tutorialStep.setMessage(step.getString("text"));
			tutorialStep.setPosition(step.getInt("position"));
			tutorialStep.setNode(step.getString("elem"));
			JSONObject config = step.getJSONObject("config");

			tutorialStep.setAction(config.getString("option"));
			tutorialStep.setActionValue(config.getString("value"));

			tutorialStepLocalService.addNewTutorialStep(tutorialStep);
		}
	}

	@AccessControlled(guestAccessEnabled = true)
	public List<TutorialStep> getTutorialSteps(long companyId, long groupId, long plid) throws SystemException {
		return super.tutorialStepLocalService.getTutorialSteps(companyId, groupId, plid);
	}

	private void temporaryFixCleanUP(long companyId, long groupId, long plid) {
		try {
			List<TutorialStep> tutorialSteps = tutorialStepLocalService.getTutorialSteps(companyId, groupId, plid);
			for (TutorialStep step : tutorialSteps) {
				tutorialStepLocalService.deleteTutorialStep(step.getStepId());
			}
		} catch (Exception e) {
			LOG.error("Unable to delete entries for plid "+plid, e);
		}
	}

	private final static Log LOG = LogFactoryUtil.getLog(TutorialStepServiceImpl.class);

}
