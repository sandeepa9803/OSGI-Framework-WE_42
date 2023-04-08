package moduleproducer;

public class Module {
	
	String moduleId, moduleName, grade, medium, hours, moduleFee;
	
	public Module() {

	}

	public Module(String moduleId, String moduleName, String grade, String medium, String hours, String moduleFee) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.grade = grade;
		this.medium = medium;
		this.hours = hours;
		this.moduleFee = moduleFee;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getModuleFee() {
		return moduleFee;
	}

	public void setModuleFee(String moduleFee) {
		this.moduleFee = moduleFee;
	}

}
