package callcentre;

public class Fresher extends Employee{
	
	boolean free;
	protected String name;
	
	public Fresher(String name) {
		this.name = name;
		free = true;
	}
	
	private void setFree(boolean value) {
		this.free = value;
	}
	
	public void printEmployeeDetails() {
		System.out.print(name);
	}
	
	public void getCall() throws InterruptedException {
		if(free) {
			System.out.print("\nFresher " + name + " recieving call.\t");
			this.free = false;
			Thread.sleep(1000); 
			System.out.print("Done recieving call.\n");
			this.free = true;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Fresher fresher = new Fresher("Alex");
		fresher.getCall();
	}
}