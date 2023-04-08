package studentpublisher;

public class Student {
	
	String ID, firstName, lastName, address, contactNo, grade ,gender;
	
	

	public Student() {

	}
	

	public Student(String iD, String firstName, String lastName, String address, String contactNo, String grade , String gender) {
		super();
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactNo = contactNo;
		this.grade = grade;
		this.gender = gender;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGender() {
		return grade;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


}
