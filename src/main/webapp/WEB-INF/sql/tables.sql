create table Tutorial_TutorialStep (
	stepId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	plid LONG,
	sequence INTEGER,
	message STRING null,
	position VARCHAR(75) null,
	alignPosition VARCHAR(75) null,
	node VARCHAR(255) null,
	action VARCHAR(75) null,
	actionValue VARCHAR(255) null
);