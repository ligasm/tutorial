create table Tutorial_TutorialStep (
	stepId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	plid LONG,
	sequence INTEGER,
	message STRING null,
	position INTEGER,
	node VARCHAR(255) null,
	action VARCHAR(75) null,
	actionValue VARCHAR(255) null
);