package singleton;

public class AccessSingletonObject{
	
	public static void main(String[] args){
		SingleObject singleObject = SingleObject.getTheSingleObject();
		singleObject.print();
	}
}