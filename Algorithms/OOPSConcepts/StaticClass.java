
public class StaticClass {
	int data = 0;
	int a;
	int b;
	int c;
	static String college = "VTU";
	
	public StaticClass() {
		data = 5;
	}
	
	public StaticClass(int a, int b) {
		this();
		this.a = a;
		this.b = b;
	}
	
	public StaticClass(int a, int b, int c){
		this(a, b);
		this.c = c;		
	}
	
	static void changeCollegeName(){
		college = "AICTE";
	}
	
	public void printMe(){
		System.out.println(this.data + "\t" + college);
		
		System.out.println(data + "\t" + a + "\t" + b + "\t" + c);
	}
	
	public static void main(String[] args){
		StaticClass myClass = new StaticClass(1,2,3);
		myClass.printMe();
		
		//changeCollegeName();
		//myClass.printMe();
	}
}
