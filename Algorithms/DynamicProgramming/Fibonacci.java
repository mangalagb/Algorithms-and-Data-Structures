import java.util.Scanner;

public class Fibonacci {
	
	public void findFibonacciDynamically(int n) {
		if(n <= 1) {
			System.out.println("Ans = 1");
			return;
		}
		int[] previousValues = new int[n+1];
		previousValues[0] = 0;
		previousValues[1] = 1;
		
		for(int i=2; i<=n; i++){
			previousValues[i] = previousValues[i-1] + previousValues[i-2];
		}
		
		for(int i=0;i<previousValues.length;i++) {
			System.out.print(previousValues[i] + "\t");
		}
		System.out.println("\nAns = " + previousValues[n]);
	}
	
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number : ");
		int n = scanner.nextInt();
		fibonacci.findFibonacciDynamically(n);
	}
}
