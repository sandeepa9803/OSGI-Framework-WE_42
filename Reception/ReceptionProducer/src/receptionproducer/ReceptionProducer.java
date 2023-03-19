package receptionproducer;

public interface ReceptionProducer {
	boolean checkReceptionInfo(String receptionId);
	void addReceptionInfo(String receptionId, String receptionName);
	String getSelectedReceptionInfo(String receptionId);
	
	void makePayment(int noOfMonths, int grade);
	void acceptPayment(int noOfMonths, int grade);
	int calculateTotal();
	int getEarnings();
	int getDiscount();
	
	void setDiscount(int discount);
	void setTeacherSalary(int teacherSalary);
	void setStudentFees(int studentFees);
	void setEarnings(int earnings);
}
