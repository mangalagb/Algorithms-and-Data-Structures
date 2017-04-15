package callcentre;

import java.util.LinkedList;
import java.util.Queue;

/*Imagine you have a call center with three levels of employees:
 fresher, technical lead (TL),product manager(PM) 
There can be multiple employees,but only one TL or PM
An incoming telephone call must be allocated to a fresher who is free
can’t handle the call, he or she must escalate the call to technical lead
not free or not able to handle it, then the call should be escalated to PM
classes and data structures for this problem Implement a method getCallHandler()*/

public class Employee{
	
	
	//Lets say we have 2 freshers
	static Queue<Fresher> freshers = new LinkedList<Fresher>();
	
	public void initializeFreshers() {
		Fresher fresher1 = new Fresher("Alex");
		Fresher fresher2 = new Fresher("Bob");
		freshers.add(fresher1);
		freshers.add(fresher2);
	}
	
	public void printEmployeeDetails() {
		this.printEmployeeDetails();
	}
	
	public void printFreshers() {
		for(Fresher fresher : freshers) {
			fresher.printEmployeeDetails();
		}
	}
	
	public static void main(String[] args)throws InterruptedException {
		Employee employee = new Employee();
	}
}