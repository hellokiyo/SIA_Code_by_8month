package mybatis;

public class Emp {

	public int id;
	public String firstName;
	public String lastName;
	public int salary;
	public String jobId;
	
	
	@Override
	public String toString() {
		return "Emp id=" + id + 
				", firstName=" + firstName + ", lastName=" + lastName + ", jobId=" + jobId
				+ ", salary=" + salary;
	}
}
