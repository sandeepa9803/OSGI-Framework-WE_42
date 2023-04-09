package moduleproducer;

import java.util.ArrayList;
import java.util.Scanner;

public class ModuleProducerImpl implements ModuleProducer {
	Scanner sc = new Scanner(System.in);
	String mmoduleId, mmoduleName, mgrade, mmedium, mhours, mmoduleFee; 
	static ArrayList<Module> mod = new ArrayList<Module>();

	@Override
	public void ModuleRegister() {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("---------------------------------Hello------------------------------------");
		System.out.println("---------------Welcome to MSMS Institute Management System----------------");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println();
		
		System.out.println("Are you a new module(y/n)?");
		String input = sc.next();
		
		while (input.equalsIgnoreCase("y")) {
			System.out.println("If you wish to end your proccess and leave the system, type exit ");	
			System.out.println("Enter module id: ");
			mmoduleId = sc.next();
			System.out.println("Enter module name: ");
			mmoduleName = sc.next();
			System.out.println("Enter module grade: ");
			mgrade = sc.next();
			System.out.println("Enter module medium: ");
			mmedium = sc.next();
			System.out.println("Enter module hour: ");
			mhours = sc.next();
			System.out.println("Enter module fee: ");
			mmoduleFee = sc.next();
			mod.add(new Module(mmoduleId, mmoduleName, mgrade, mmedium, mhours,  mmoduleFee));
			System.out.println("Do You Want To Add Another module(y/n)?");
			input = sc.next();
			
			
		}
		
	}

	@Override
	public void UpdateModule(Module module) {
		System.out.print("Do you want to update Module details(y/n)? ");
		String input = sc.next();
		System.out.println("--------------------------------------------------------------------------");
		
		while (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("Y")) {
			
			if (mod.contains(module)) {
				
				System.out.println("What do you want to edit?(grade-1, medium-2, hour-3, fee-4): ");
				int editIn = sc.nextInt();
				
				if (editIn == 1) {
					System.out.println("Enter grade: ");
					mgrade = sc.next();
				}
				else if (editIn == 2) {
					System.out.println("Enter module medium: ");
					mmedium = sc.next();
				}
				else if (editIn == 3) {
					System.out.println("Enter module hour: ");
					mhours = sc.next();
				}
				else if (editIn == 4) {
					System.out.println("Enter new fee: ");
					mmoduleFee = sc.next();
				}
				
				else { 
					System.out.println("Undefined input!");
				}
				mod.set(mod.indexOf(module), new Module(mmoduleId, mmoduleName, mgrade, mmedium, mhours,  mmoduleFee) );
			}
			else if (mod.size() == 0) {
				System.out.println("No record added yet! ");
			}
			else {
				System.out.println("Ivalid module ID!");
			}
			System.out.println("Do you want to update another module details(y/n)?");
			input = sc.next();
		}
		
	}

	@Override
	public void ModuleDelete(String moduleid) {
		System.out.println("Are you sure; do you want to delete this module(y/n)?");
		String input = sc.next();
		
		while (input.equalsIgnoreCase("y")) {
			if(mod.size() !=0) { 
				int x =0;
				for (int y = 0; y < mod.size(); y++) {
					if(mod.get(y).getModuleId() == mmoduleId) { 
					String deleteID = mod.get(y).getModuleId();
					mod.remove(y);
					System.out.println("Subject :" + deleteID + " is module deleted successfully");
					break;
					}	
					x++;
				}
			}else {
				System.out.println("No record added yet!");
			}
			System.out.println("Do you want to delete another module(y/n)?");
			input = sc.next();
		} 
		
	}

	@Override
	public void displayModuleList() {
		System.out.println("-----------------------------------Module Deails-----------------------------------");
		for (Module mod : mod) {
			System.out.println("Module ID: " + mod.getModuleId());
			System.out.println("Module Name: " + mod.getModuleFee());
			System.out.println("Module Grade: " + mod.getGrade());
			System.out.println("Module Medium: " + mod.getMedium());
			System.out.println("Module Hour: " + mod.getHours());
			System.out.println("Module Fee: " + mod.getModuleFee());
			System.out.println("\n");
			
		}
		
	}

	@Override
	public Module getModuleById(String moduleid) {
		System.out.println("-----------------------------------Module Deails-----------------------------------");
		for (Module module : mod) {
			if (module.getModuleId() == mmoduleId) {
				return module;
			}
		}
		return null;
	}

	

}
