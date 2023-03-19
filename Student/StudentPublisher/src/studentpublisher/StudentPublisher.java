package studentpublisher;

public interface StudentPublisher {
	
	public void RegisterStudent();

	public void StudentEdit(Student std);

	public void StudentDelete(String sid);

	public void ViewStudentList();
	
	public Student getStudentById(String sid);

}
