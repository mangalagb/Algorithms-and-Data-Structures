public class SingleObjectDemo
{
	public static void main(String[] args)
	{
		//SingleObject s = new SingleObject();
		//s.printMe();
		
		SingleObject object = SingleObject.getInstance();
		object.printMe();
	}
}
class SingleObject
{
	private static SingleObject instance = new SingleObject();
	
	private SingleObject() {}
	
	public static SingleObject getInstance()
	{
		return instance;
	}
	
	public void printMe()
	{
		System.out.println("hello");
	}
	
	
}