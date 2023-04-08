package moduleconsumer;

import java.util.Scanner;
import moduleproducer.Module;
import moduleproducer.ModuleProducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ServiceActivator implements BundleActivator {

	
	ServiceReference moduleReference;
	Scanner sc = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println("Module Consumer >> Start");
		
		moduleReference = bundleContext.getServiceReference(ModuleProducer.class.getName());
		
		ModuleProducer modProduce = (ModuleProducer) bundleContext.getService(moduleReference);
		modProduce.ModuleRegister();
		modProduce.displayModuleList();
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.print("Choose Edit Or Delete (e|E /d|D): "); //choose edit or delete options
		String answer = sc.next();
		System.out.println("--------------------------------------------------------------------------");
		String exit = "no";
		
		System.out.print("Enter module id: "); 
		Module module = modProduce.getModuleById(sc.next()); //get module by the module id
		System.out.println("--------------------------------------------------------------------------");
		
		if (answer.equalsIgnoreCase("e") || answer.equalsIgnoreCase("E")) {//edit module details 
			modProduce.UpdateModule(module);
			modProduce.displayModuleList();
				System.out.println("Do you want exit (y/n)?");
				exit = sc.next();

		} else if (answer.equalsIgnoreCase("d") || answer.equalsIgnoreCase("D")) {// delete existing module
			modProduce.ModuleDelete(module.getModuleId());//delete the module details according to the id
			System.out.println("Do you want exit (y/n)?");
			exit = sc.next();
				
		} else {
			System.out.println("Undifine Input!!!");
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Module Consumer >> Stop");
		bundleContext.ungetService(moduleReference);
	}

}
