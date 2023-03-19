package receptionproducer;

import java.util.HashMap;

public class ReceptionProducerImp implements ReceptionProducer{
	HashMap<String , String> receptionInfo = new HashMap<String, String>();
	int total=0,studentFees=0, teacherSalary=0, discount = 0, discountAmount=0 , savings = 0;

	@Override
	public boolean checkReceptionInfo(String receptionId) {
		if (receptionInfo.get(receptionId) != null)
			return true;
		return false;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public void addReceptionInfo(String receptionId, String receptionName) {
		receptionInfo.put(receptionId, receptionName);
	}

	@Override
	public String getSelectedReceptionInfo(String receptionId) {
		if(checkReceptionInfo(receptionId)) {
			return "Id: "+ receptionId+"\nName: "+receptionInfo.get(receptionId);
		}
		return "No Reception registered under given id";
	}

	@Override
	public void acceptPayment(int noOfMonths, int grade) {
		if(noOfMonths >=3 && noOfMonths < 6) {
			setDiscount(discount*2);
		}else if(noOfMonths>=6 && noOfMonths < 9) {
			setDiscount(discount*3);
		}else {
			setDiscount(discount*4);
		}
		discountAmount = (int) (((studentFees + grade*100)*discount)/100);
		total = (int) (((studentFees + grade*100)*(100-discount))/100);
		savings += total;
	}

	@Override
	public int getEarnings() {
		return savings;
	}

	@Override
	public void makePayment(int noOfMonths, int grade) {
		total = (teacherSalary + grade*noOfMonths*10);
		savings -= (teacherSalary + grade*noOfMonths);
	}

	@Override
	public int calculateTotal() {
		return total;
	}

	@Override
	public int getDiscount() {
		return discountAmount;
	}

	@Override
	public void setTeacherSalary(int teacherSalary) {
		this.teacherSalary= teacherSalary;
	}

	@Override
	public void setStudentFees(int studentFees) {
		this.studentFees = studentFees;
	}

	@Override
	public void setEarnings(int savings) {
		this.savings = savings;
		
	}
}
