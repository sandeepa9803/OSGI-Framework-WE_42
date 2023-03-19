package moduleproducer;

public interface ModuleProducer {
	
	public void ModuleRegister();
	
	public void UpdateModule(Module module);
	
	public void ModuleDelete(String moduleid);
	
	public void displayModuleList();
	
	public Module getModuleById(String moduleid);

}
