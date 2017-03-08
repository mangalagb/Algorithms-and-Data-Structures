package BasicPrograms;
public class Factorial{
	public int facorialIterative(int n){
		if(n == 0){
			return 1;
		}
		int fac = 1;
		for(int i=n; i>0; i--){
			fac = fac * i;
		}
		return fac;
	}
	
	public int facorialRecursive(int n){
		if(n == 0){
			return 1;
		}
		
		return n* facorialRecursive(n-1);
	}
	
	public static void main(String[] args){
		Factorial factorial = new Factorial();
		System.out.println(factorial.facorialIterative(5) + "\n");		
		System.out.println(factorial.facorialRecursive(5) + "\n");
	}
}