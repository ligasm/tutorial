package com.liferay.tutorial.service.impl;

import com.liferay.counter.model.Counter;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.tutorial.model.TutorialStep;
import com.liferay.tutorial.service.base.TutorialStepLocalServiceBaseImpl;

/**
 * The implementation of the tutorial step local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.tutorial.service.TutorialStepLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Miroslav Ligas
 * @see com.liferay.tutorial.service.base.TutorialStepLocalServiceBaseImpl
 * @see com.liferay.tutorial.service.TutorialStepLocalServiceUtil
 */
public class TutorialStepLocalServiceImpl
    extends TutorialStepLocalServiceBaseImpl {

	public TutorialStep addNewTutorialStep(TutorialStep tutorialStep) throws SystemException, PortalException {
		long id = counterLocalService.increment(TutorialStep.class.getName());
		tutorialStep.setStepId(id);
		return addTutorialStep(tutorialStep);
	}
}
