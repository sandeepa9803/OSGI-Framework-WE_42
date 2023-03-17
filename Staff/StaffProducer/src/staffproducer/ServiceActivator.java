package staffproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class ServiceActivator implements BundleActivator {

	ServiceRegistration staffRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Staff Producer  >> Start");
		StaffProducer staffProducer = new StaffProducerImpl();
		staffRegistration = bundleContext.registerService(StaffProducer.class.getName(), staffProducer, null);
	
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Staff Producer >> Stop");
		staffRegistration.unregister();
	}

}
