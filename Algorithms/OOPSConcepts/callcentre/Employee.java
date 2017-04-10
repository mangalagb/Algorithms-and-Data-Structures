package callcentre;

public class Employee{
	String name;
	int employeeNumber;
	boolean free;
	
	public boolean isFree(){
		return free;
	}
	
	public void setFree(boolean value){
		this.free = value;
	}
	
	public void getCall(){
		//Before handling call, set free to false
		this.free = false;
		
		System.out.println("Fresher handling call");
		
		//After handling call, set free to true
		this.free = true;
	}
	
}