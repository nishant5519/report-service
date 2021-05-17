package com.report.model;

public class Project {

	private String customerId;
	private String contractId;
	private String geozone;
	private String teamcode;
	private String projectcode;
	private String buildduration;

	public Project(ProjectBuilder builder) {
		super();
		this.customerId = builder.customerId;
		this.contractId = builder.contractId;
		this.geozone = builder.geozone;
		this.teamcode = builder.teamcode;
		this.projectcode = builder.projectcode;
		this.buildduration = builder.buildduration;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getGeozone() {
		return geozone;
	}

	public void setGeozone(String geozone) {
		this.geozone = geozone;
	}

	public String getTeamcode() {
		return teamcode;
	}

	public void setTeamcode(String teamcode) {
		this.teamcode = teamcode;
	}

	public String getProjectcode() {
		return projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	public String getBuildduration() {
		return buildduration;
	}

	public void setBuildduration(String buildduration) {
		this.buildduration = buildduration;
	}

	@Override
	public String toString() {
		return "Project [customerId=" + customerId + ", contractId=" + contractId + ", geozone=" + geozone
				+ ", teamcode=" + teamcode + ", projectcode=" + projectcode + ", buildduration=" + buildduration + "]";
	}

	public static class ProjectBuilder {
		private String customerId;
		private String contractId;
		private String geozone;
		private String teamcode;
		private String projectcode;
		private String buildduration;

		public ProjectBuilder(String customerId, String contractId, String geozone, String teamcode, String projectcode,
				String buildduration) {
			this.customerId = customerId;
			this.contractId = contractId;
			this.geozone = geozone;
			this.teamcode = teamcode;
			this.projectcode = projectcode;
			this.buildduration = buildduration;
		}

		public Project build() {
			Project project = new Project(this);
			return project;
		}
	}

}
