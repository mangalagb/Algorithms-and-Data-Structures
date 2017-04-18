package callcentre;

public class Employee{
	boolean free;
	String name;
	
	public void setFree(boolean value) {
		this.free = value;
	}
	
	public boolean isFree() {
		return this.free;
	}
	
	public void printEmployeeDetails() {
		System.out.print(name);
	}
	
	public void getCall() throws InterruptedException {
		if(free) {
			System.out.print(name + " recieving call.\t");
			this.free = false;
			Thread.sleep(1000); 
			System.out.print("Done recieving call.\n");
			this.free = true;
		}
	}
}