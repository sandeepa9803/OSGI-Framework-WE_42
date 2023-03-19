package receptionconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import receptionproducer.ReceptionProducer;

public class Activator implements BundleActivator {

    private static BundleContext context;
    ServiceReference<?> serviceReference;

    Scanner input = new Scanner(System.in);
    String receptionName, receptionId, selectedChoice = "", quitChoice = "YES";
    boolean isVerified = false;

    static BundleContext getContext() {
        return context;
    }

    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        serviceReference = bundleContext.getServiceReference(ReceptionProducer.class.getName());
        ReceptionProducer receptionProducer = (ReceptionProducer) bundleContext.getService(serviceReference);

        System.out.println();
        System.out.println("=================================================");
        System.out.println();
        System.out.println("                 Welcome Reception               ");
        System.out.println();
        System.out.println("=================================================");
        System.out.println();

        do {
            String name = "", id = "", noOfMonths = "0", grade = "0";
            System.out.println("[1]. Make Monthly Payment to Staff");
            System.out.println("[2]. Make Monthly Payment to  Student");
            System.out.println("[3]. Get Total Earnings");

            System.out.print("\nChoice: ");
            selectedChoice = input.nextLine();

            if (selectedChoice.equals("1")) {
            	quitChoice = "YES";
                while (quitChoice.equalsIgnoreCase("YES")) {
                    if (!isVerified) {
                        System.out.println("Enter Reception Credentials:");
                        System.out.print("Enter ID:");
                        receptionId = input.nextLine();
                    }
                    if (receptionProducer.checkReceptionInfo(receptionId)) {
                        System.out.println("\nReception Details: ");
                        System.out.println("\n" + receptionProducer.getSelectedReceptionInfo(receptionId) + "\n");
                        isVerified = true;
                        do {
                            System.out.println("Teacher Details: ");
                            System.out.print("Enter ID: ");
                            id = input.nextLine();
                            System.out.print("Enter Name: ");
                            name = input.nextLine();
                            System.out.print("Enter Grade: ");
                            grade = input.nextLine();
                            System.out.print("No of Months worked: ");
                            noOfMonths = input.nextLine();
                            try {
                                receptionProducer.makePayment(Integer.parseInt(noOfMonths), Integer.parseInt(grade));
                            } catch (NumberFormatException e) {
                                System.out.println("Please Provivde a Valid Input");
                                System.out.println("Error: " + e.getMessage());
                            }
                            System.out.print("Do you have any Salary Pendings [Mr/Mrs]. " + name + "? [Yes/No]: ");
                        } while (input.nextLine().equalsIgnoreCase("YES"));

                        System.out.println("==================================================");
                        System.out.println("               Bill for the Payment               ");
                        System.out.println();
                        System.out.println("ID               :          " + id);
                        System.out.println("Name             :          " + name);
                        System.out.println("No Of Months     :          " + noOfMonths);
                        System.out.println("Grade            :          " + grade);
                        System.out.println("Designation      :          Teacher");
                        System.out.println();
                        System.out.println("Total Cost       :          " + receptionProducer.calculateTotal());
                        System.out.println("==================================================");
                        System.out.println();

                        System.out.print("Do you want to make Payment to another Teacher? [Yes/No]: ");
                        quitChoice = input.nextLine();
                    } else {
                        System.out.println("Invalid Reception Credentials");
                    }
                }
                quitChoice = "YES";
            } else if (selectedChoice.equals("2")) {
                quitChoice = "YES";
                while (quitChoice.equalsIgnoreCase("YES")) {
                    if (!isVerified) {
                        System.out.println("Enter Reception Credentials:");
                        System.out.print("Enter ID: ");
                        receptionId = input.nextLine();
                    }
                    if (receptionProducer.checkReceptionInfo(receptionId)) {
                        System.out.println("\nReception Details: ");
                        System.out.println("\n" + receptionProducer.getSelectedReceptionInfo(receptionId) + "\n");
                        isVerified = true;
                        do {
                            System.out.println("Student Details: ");
                            System.out.print("Enter ID: ");
                            id = input.nextLine();
                            System.out.print("Enter Name: ");
                            name = input.nextLine();
                            System.out.print("Enter Grade: ");
                            grade = input.nextLine();
                            System.out.print("No of Months to be paid: ");
                            noOfMonths = input.nextLine();
                            try {
                                receptionProducer.acceptPayment(Integer.parseInt(noOfMonths), Integer.parseInt(grade));
                            } catch (NumberFormatException e) {
                                System.out.println("Please Provivde a Valid Input");
                                System.out.println("Error: " + e.getMessage());
                            }
                            System.out.print("Do you want to make another Payment " + name + "? [Yes/No]: ");
                        } while (input.nextLine().equalsIgnoreCase("YES"));

                        System.out.println("==================================================");
                        System.out.println("               Bill for the Payment               ");
                        System.out.println();
                        System.out.println("ID                :          " + id);
                        System.out.println("Name              :          " + name);
                        System.out.println("No Of Months      :          " + noOfMonths);
                        System.out.println("Grade             :          " + grade);
                        System.out.println("Designation       :          Student");
                        System.out.println();
                        System.out.println("Total Cost        :          "
                                + (receptionProducer.calculateTotal() + receptionProducer.getDiscount()));
                        System.out.println("Total Discount    :          " + receptionProducer.getDiscount());
                        System.out.println("Amount to be paid :          " + receptionProducer.calculateTotal());
                        System.out.println();
                        System.out.println("--------------------------------------------------");
                        System.out.println("Reception Details: ");
                        System.out.println(receptionProducer.getSelectedReceptionInfo(receptionId));
                        System.out.println("==================================================");
                        System.out.println();

                        System.out.print("Do you want to accept Payment from another Student? [Yes/No]: ");
                        quitChoice = input.nextLine();
                    } else {
                        System.out.println("\nNote: Invalid Reception Credentials");
                    }
                }
            } else if (selectedChoice.equals("3")) {
            	quitChoice = "YES";
                while (quitChoice.equalsIgnoreCase("YES")) {
                    if (!isVerified) {
                        System.out.println("Enter Reception Credentials:");
                        System.out.print("Enter ID: ");
                        receptionId = input.nextLine();
                    }
                    if (receptionProducer.checkReceptionInfo(receptionId)) {
                        System.out.println("Total Earnings : " + receptionProducer.getEarnings());
                        quitChoice = "No";
                    } else {
                        System.out.println("\nNote: Invalid Reception Credentials");
                    }
                }
                quitChoice = "YES";
            } else {
                System.out.println("Invalid Input");
            }
            System.out.print("Do you want to Exit? [Yes/No]: ");
            quitChoice = input.nextLine();
        } while (!quitChoice.equalsIgnoreCase("YES"));

        System.out.println();
    }

    public void stop(BundleContext bundleContext) throws Exception {

        System.out.println("===================================================");
        System.out.println();
        System.out.println("     ReceptionSubscriber is leaving the premises     ");
        System.out.println("                !!Have a nice day!!                ");
        System.out.println();
        System.out.println("===================================================");

        Activator.context = null;

    }

}
