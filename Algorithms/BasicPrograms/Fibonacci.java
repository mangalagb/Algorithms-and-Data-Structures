public class Fibonacci{
	public int fibonacciRecursive(int n){
		if (n == 1 || n == 2) {
			return 1;
		}		       
		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
	}
	
	public void fibonacciIterative(int count){
		if(count ==1){
			System.out.print("1" + "\t");
			return;
		}else if(count == 2){
			System.out.print("1" + "\t" + "1" + "\t");
			return;
		}else{
			count = count -2;
			System.out.print("1" + "\t" + "1" + "\t");
			
			int a=1, b=1, c=0;
			for(int i=0; i<count; i++){
				c = a+b;
				System.out.print(c + "\t");
				a=b;
				b=c;
			}
		}
	}
	
	public static void main(String[] args){
		Fibonacci fib = new Fibonacci();
		int count = 10;
		
		//Recursive
		for(int i=1;i<=count;i++){
			System.out.print(fib.fibonacciRecursive(i) + "\t");
		}
		
		System.out.print("\n\n");
		
		//Iterative		
		fib.fibonacciIterative(count);
	}
	
}