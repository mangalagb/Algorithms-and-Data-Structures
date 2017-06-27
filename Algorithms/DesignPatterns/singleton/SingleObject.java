package singleton;
/*
 * This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. 
 * This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.
 */

public class SingleObject{
	
	//Private constructor
	private SingleObject(){};
	
	//Private static object
	private static SingleObject onlyOneObject = new SingleObject();
	
	
	public static SingleObject getTheSingleObject(){
		return onlyOneObject;
	}
	
	public void print(){
		System.out.println("I'm in SingleObject class");
	}	
}