package studentpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator{

	ServiceRegistration stdRegistration;

	public void start(BundleContext context) throws Exception {

		System.out.println("Student Publisher Start");
		StudentPublisher stdPublisher = new ImplStudentPublisher();
		stdRegistration = context.registerService(StudentPublisher.class.getName(), stdPublisher, null);
	}

	public void stop(BundleContext cnotext) throws Exception {
		System.out.println("Student Publisher Stop");
		stdRegistration.unregister();
	}

}

