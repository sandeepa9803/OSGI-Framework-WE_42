package studentpublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class ImplStudentPublisher implements StudentPublisher {
	
	Scanner ab = new Scanner (System.in);
	String stid, fiName, laName, addr, conNom, grde, gend;
	static ArrayList<Student> std = new ArrayList<Student>();
	
	
	/**
	 * This method is used to register a new student
	 */
	

	@Override
	public void RegisterStudent() {
		
		
		System.out.println("**************************************************************************");
		System.out.println("**************Welcome to MSMS Institute Management System*****************");
		System.out.println("**************************************************************************");
		System.out.println();
		
		
		System.out.println("Are you a new student (y/n)?");
		String input = ab.next();

		while (input.equalsIgnoreCase("y")) {
			System.out.println("If you wish to end your proccess and leave the system, type exit");
			
			System.out.println("Enter student ID: ");
			stid = ab.next();
			
			System.out.println("Enter student first name: ");
			fiName = ab.next();
			
			System.out.println("Enter student last name: ");
			laName = ab.next();
			
			System.out.println("Enter student address: ");
			addr = ab.next();
			
			System.out.println("Enter student contact number: ");
			conNom = ab.next();
			
			System.out.println("Enter student grade: ");
			grde = ab.next();
			
			System.out.println("Enter student gender: ");
			gend = ab.next();
			
			std.add(new Student(stid, fiName, laName, addr, conNom, grde ,gend));
			
			System.out.println("Do you want to add another student(y/n)?");
			input = ab.next();
		}
		
	}
	
	
	/**
	 * This method is used to edit existing student details
	 */
	

	@Override
	public void StudentEdit(Student student) {
		
		System.out.println("Do you want to edit student details(y/n)?");
		String input = ab.next();

		while (input.equalsIgnoreCase("y")) {
			
			if (std.contains(student)) {
				
				System.out.println("What do you want to edit?(first name-1, last name-2, address-3, contact number-4)");
				int editIn = ab.nextInt();
				
				if(editIn == 1){
					System.out.println("Enter student first name: ");
					fiName = ab.next();
				}
				else if(editIn == 2){
					System.out.println("Enter student last name: ");
					laName = ab.next();
				}
				else if(editIn == 3){
					System.out.println("Enter student address: ");
					addr = ab.next();
				}
				else if(editIn == 4){
					System.out.println("Enter student contact number: ");
					conNom = ab.next();
				}
				else{
					System.out.println("Not correct input!");
					
				}
				std.set(std.indexOf(student), new Student(stid, fiName, laName, addr, conNom, grde , gend));

			} else if (std.size() == 0) {
				System.out.println("No record added yet!");
			} else {
				System.out.println("Invalid Student ID !");
			}
			System.out.println("Do you want to edit another student(y/n)?");
			input = ab.next();
		}
		
	}

	
	/**
	 * This method is used to delete existing student details
	 */
	
	
	@Override
	public void StudentDelete(String sid) {
		
		System.out.println("Are you sure you want to delete this student ?(y/n)");
		String input = ab.next();

		while (input.equalsIgnoreCase("y")) {
			if (std.size() != 0) {
				int j = 0;
				for (int i = 0; i < std.size(); i++) {
					if (std.get(i).getID() == stid) {
						String deleteID = std.get(i).getID();
						std.remove(i);
						System.out.println("Student :" + deleteID + " is student deleted successfully");
						break;
					}
					j++;
				}
				if (j == 0) {
					System.out.println("There is no any id equal to your input id!");
				}
			} else {
				System.out.println("No record added yet!");
			}
			
			System.out.println("Do you want to delete another student(y/n)?");
			input = ab.next();
		}
		
	}
	
	
	/**
	 * This method is used to display student list
	 */
	

	@Override
	public void ViewStudentList() {
		
		for (Student std : std) {
			System.out.println("Student ID: " + std.getID());
			System.out.println("Student First Name: " + std.getFirstName());
			System.out.println("Student Last Name: " + std.getLastName());
			System.out.println("Student Address: " + std.getAddress());
			System.out.println("Student Contact Number:" + std.getContactNo());
			System.out.println("Student Grade:" + std.getGrade());
			System.out.println("Student Gender:" + std.getGender());
			System.out.println("\n");
		}
	}
		
	
	/**
	 * This method is used to search student by ID
	 */
	

	@Override
	public Student getStudentById(String sid) {
		
		for (Student student : std) {
			if (student.getID() == stid) {
				return student;
			}
		}
		return null;
	}
	
	

}
