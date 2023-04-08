package staffconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import staffproducer.Staff;
import staffproducer.StaffProducer;


public class ServiceActivator implements BundleActivator {

	ServiceReference staffReference;
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Staff Consumer >> Start");
		
		staffReference = bundleContext.getServiceReference(StaffProducer.class.getName());
		
		StaffProducer staffproduce = (StaffProducer) bundleContext.getService(staffReference);
		staffproduce.RegisterStaff();
		staffproduce.DisplayStaffList();
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.print("Choose Edit Or Delete (e|E /d|D): "); //choose edit or delete options
		String answer = sc.next();
		System.out.println("--------------------------------------------------------------------------");
		String exit = "no";
		System.out.print("Enter Teacher NIC: "); 
		
		Staff staff = staffproduce.getStaffById(sc.next()); //get teacher by the teacher NIC
		
		System.out.println("--------------------------------------------------------------------------");
		
		if (answer.equalsIgnoreCase("e") || answer.equalsIgnoreCase("E")) {//edit teacher details 
			staffproduce.UpdateStaff(staff);
			staffproduce.DisplayStaffList();
				System.out.println("Do you want exit (y/n)?");
				exit = sc.next();

		} else if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("D")) {// delete existing teacher
			staffproduce.DeleteStaff(staff.getNic());//delete the teacher details according to the NIC
				
		} else {
			System.out.println("Undifine Input!!!");
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Staff Consumer stop");
		bundleContext.ungetService(staffReference);
	}

}
