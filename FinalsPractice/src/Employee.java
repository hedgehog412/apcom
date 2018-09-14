
public class Employee {
	private String name;
	private static int employeeCount=0;
	
	public Employee(){
		employeeCount++;
	}
	
	public static int getEmployeeCount(){
		return employeeCount;
	}

}
