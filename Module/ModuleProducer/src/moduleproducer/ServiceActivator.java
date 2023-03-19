package moduleproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration modRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Module Producer Start ");
		ModuleProducer modProducer = new ModuleProducerImpl();
		modRegistration = bundleContext.registerService(ModuleProducer.class.getName(), modProducer, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Module Producer Stop");
		modRegistration.unregister();
	}

}
 