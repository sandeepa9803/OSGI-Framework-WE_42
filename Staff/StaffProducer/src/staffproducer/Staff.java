package staffproducer;

public class Staff {
	
	String staffName, nic, qualification, mobileNo, module, grade;
	

	public Staff() {

	}

	public Staff(String staffName, String nic, String qualification, String mobileNo, String module, String grade) {
		super();
		this.staffName = staffName;
		this.nic = nic;
		this.qualification = qualification;
		this.mobileNo = mobileNo;
		this.module = module;
		this.grade = grade;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}
