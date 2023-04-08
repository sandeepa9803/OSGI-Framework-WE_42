package staffproducer;

public interface StaffProducer {
	
	public void RegisterStaff();

	public void UpdateStaff(Staff staff);

	public void DeleteStaff(String staffId);

	public void DisplayStaffList();
	
	public Staff getStaffById(String staffId);

}
