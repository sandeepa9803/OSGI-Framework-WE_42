package studentsubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import studentpublisher.Student;
import studentpublisher.StudentPublisher;

public class ServiceActivator implements BundleActivator {

	ServiceReference studentReference;
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Student subscriber start");
		studentReference = context.getServiceReference(StudentPublisher.class.getName());
		StudentPublisher stdPublish = (StudentPublisher) context.getService(studentReference);
		stdPublish.RegisterStudent();
		stdPublish.ViewStudentList();
		System.out.println("Choose edit or delete: (e/d)"); //choose edit or delete options
		String answer = sc.next();
		String exit = "no";
		System.out.println("Enter Student ID: "); 
		Student std = stdPublish.getStudentById(sc.next()); //get student by the student id
		
		if (answer.equalsIgnoreCase("e")) {//edit student details 
				stdPublish.StudentEdit(std);
				stdPublish.ViewStudentList();
				System.out.println("Do you want exit (y/n)?");
				exit = sc.next();

		} else if (answer.equalsIgnoreCase("d")) {// delete existing student 
				stdPublish.StudentDelete(std.getID());//delete the student details according to the id
				
		} else {
			System.out.println("Not correct Input!!!");
		}
		
	}

	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Student subscriber stop");
		context.ungetService(studentReference);
	}

}
