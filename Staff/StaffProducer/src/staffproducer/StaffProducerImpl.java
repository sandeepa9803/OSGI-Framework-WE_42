package staffproducer;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffProducerImpl implements StaffProducer{
	
	Scanner sc = new Scanner (System.in);
	
	String  sstaffName, sNic, sQualification, sMobileNo, sModule, sGrade;
	
	static ArrayList<Staff> sstaff = new ArrayList<Staff>();

	@Override
	public void RegisterStaff() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("---------------------------------Hello------------------------------------");
		System.out.println("--------------Welcome to MSMS Institute Management System-----------------");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println();
		
		
		System.out.print("Are You A New Staff Member (y|Y or n|N)?: ");
		String input = sc.next();
		System.out.println();

		while (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("Y")) {
			
			
			System.out.println("--------------------------------------------------------------------------");
			System.out.println();
			
			System.out.print("Enter Your Name             :");
			sstaffName = sc.next();
			
			System.out.print("Enter Your NIC              :");
			sNic = sc.next();
			
			System.out.print("Enter Your Qualification :");
			sQualification = sc.next();
			
			System.out.print("Enter Your Mobile Number:");
			sMobileNo = sc.next()
					;
			System.out.print("Enter Your Module       :");
			sModule = sc.next();
			
			System.out.print("Enter Your Grade         :");
			sGrade = sc.next();
			
			sstaff.add(new Staff(sstaffName, sNic, sQualification, sMobileNo, sModule, sGrade));
			
			System.out.println();
			System.out.println("--------------------------------------------------------------------------");
			System.out.println();
			System.out.print("Do You Want To Add Another Staff Member (y|Y or n|N)?: ");
			input = sc.next();
			System.out.println();
		}
		
	}

	@Override
	public void UpdateStaff(Staff staff) {
		// TODO Auto-generated method stub
		System.out.print("Do You Want To Update Staff Member Details (y|Y or n|N)?: ");
		String input = sc.next();
		System.out.println("--------------------------------------------------------------------------");

		while (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("Y")) {
			
			if (sstaff.contains(staff)) {
				
				System.out.print("What Do You Want To Edit(Qualification:1, Contact Number:2, Subject:3, Grade:4)?: ");
				int editDetails = sc.nextInt();
				
				if(editDetails == 1){
					System.out.print("Enter Current Qualification: ");
					sQualification = sc.next();
				}
				else if(editDetails == 2){
					System.out.print("Enter Contact Number: ");
					sMobileNo = sc.next();
				}
				else if(editDetails == 3){
					System.out.print("Enter Subject: ");
					sModule = sc.next();
				}
				else if(editDetails == 4){
					System.out.print("Enter Grade: ");
					sGrade = sc.next();
				}
				else {
					System.out.println("You Entered Invalid Number");
				}
				System.out.println("--------------------------------------------------------------------------");
				sstaff.set(sstaff.indexOf(staff), new Staff(sstaffName, sNic, sQualification, sMobileNo, sModule, sGrade));

			} else if (sstaff.size() == 0) {
				System.out.println("No record added yet!");
			} else {
				System.out.println("Invalid Staff Member NIC!");
			}
			System.out.print("Do You Want To Add Another Staff Member(y|Y or n|N)?: ");
			input = sc.next();
		}
		
		
		
	}

	@Override
	public void DeleteStaff(String staffId) {
		// TODO Auto-generated method stub
		System.out.print("Are You Sure; Do You Want To Delete This Staff Member (y|Y or n|N)?: ");
		String input = sc.next();

		while (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("Y")) {
			if (sstaff.size() != 0) {
				int j = 0;
				for (int i = 0; i < sstaff.size(); i++) {
					if (sstaff.get(i).getNic() == sNic) {
						String deleteNIC = sstaff.get(i).getNic();
						sstaff.remove(i);
						System.out.println("Staff Member :" + deleteNIC + " Is Deleted Successfully");
						break;
					}
					j++;
				}
			} else {
				System.out.println("No record added yet!");
			}
			
			System.out.print("Do You Want To Delete Another Student (y|Y or n|N)?: ");
			input = sc.next();
		}
		
	}

	@Override
	public void DisplayStaffList() {
		// TODO Auto-generated method stub
		
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("---------------------------------Hello------------------------------------");
		System.out.println("--------------Welcome to MSMS Institute Management System-----------------");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println();
		
		for (Staff teach : sstaff) {
			System.out.println("--------------------------Staff Details-------------------------------");
			System.out.println("Staff NIC           : " + teach.getNic());
			System.out.println("Staff Name          : " + teach.getStaffName());
			System.out.println("Staff Qualification : " + teach.getQualification());
			System.out.println("Staff Mobile No     : " + teach.getMobileNo());
			System.out.println("Staff Module        : " + teach.getModule());
			System.out.println("Staff Grade         : " + teach.getGrade());
			System.out.println("--------------------------------------------------------------------------");
		}
		
	}

	@Override
	public Staff getStaffById(String staffId) {
		// TODO Auto-generated method stub
		for (Staff teacher : sstaff) {
			if (teacher.getNic() == sNic) {
				return teacher;
			}
		}
		
		return null;
	}
	

}
