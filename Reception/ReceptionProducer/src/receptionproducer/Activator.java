package receptionproducer;

import java.util.HashMap;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

    private static BundleContext context;

    HashMap<String, String> receptionInfo;

    ServiceRegistration<?> serviceRegistration;
    ServiceReference<?> serviceReference;

    Scanner input = new Scanner(System.in);
    String receptionName = "", receptionId = "", quitChoice = "YES";

    static BundleContext getContext() {
        return context;
    }

    public void start(BundleContext bundleContext) throws Exception {
        ReceptionProducer receptionProducer = new ReceptionProducerImp();
        serviceRegistration = bundleContext.registerService(ReceptionProducer.class.getName(), receptionProducer,
                null);

        System.out.println("=================================================");
        System.out.println();
        System.out.println("      Welcome to Reception Registration Panel      ");
        System.out.println();
        System.out.println("=================================================");
        System.out.println();

        do {
            if (receptionId == "" || receptionName == "") {
                System.out.print("Enter Reception ID: ");
                receptionId = input.nextLine();
                System.out.print("Enter Reception Name: ");
                receptionName = input.nextLine();
                receptionProducer.addReceptionInfo(receptionId, receptionName);
            }

            try {
                System.out.print("Enter Student Discount rate: ");
                receptionProducer.setDiscount(Integer.parseInt(input.nextLine()));
                System.out.print("Enter Student Initial Fee rate: ");
                receptionProducer.setStudentFees(Integer.parseInt(input.nextLine()));
                System.out.print("Enter Teacher Initial Fee rate: ");
                receptionProducer.setTeacherSalary(Integer.parseInt(input.nextLine()));
                System.out.print("Enter Money in the Savings: ");
                receptionProducer.setEarnings(Integer.parseInt(input.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("\nPlease Provivde a Valid Input");
                System.out.println("Error: " + e.getMessage() + "\n");
            } finally {
                System.out.print("\nDo you want to Modify? [Yes/No]: ");
                quitChoice = input.nextLine();
            }
        } while (quitChoice.equalsIgnoreCase("YES"));
    }

    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;

        System.out.println("ReceptionProducer leaving the Premises");

        serviceReference = bundleContext.getServiceReference(ReceptionProducer.class.getName());
        ReceptionProducer receptionProducer = (ReceptionProducer) bundleContext.getService(serviceReference);

        System.out.println("==================================================");
        System.out.println("              History for this Login              ");
        System.out.println("--------------------------------------------------");
        System.out.println("         !!Come back again to earn more!!         ");
        System.out.println("               !!Have a Nice Day!!                ");
        System.out.println();
        System.out.println("==================================================");
        System.out.println();

        serviceRegistration.unregister();
    }

}
