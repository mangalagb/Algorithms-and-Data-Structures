package BasicPrograms;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PrimeNumbers {
	
	public boolean isPrime(int number){
		boolean isPrime = true;
		for(int i = 2; i<=Math.sqrt(number); i++){
			if(number % i == 0){
				isPrime = false;
				break;
			}
		}		
		return isPrime;
	}
	
	public void generatePrime(int limit){
		Set<Integer> primeNumbers = new HashSet<Integer>();
		long sum = 0;
		
		for(int i=2; i<limit; i++){
			primeNumbers.add(i);
		}
		
		for(int i=2; i<limit; i++){
			if(isPrime(i)){				
				for (int j = 2; j*i < limit; j++){
					primeNumbers.remove(i*j);
				}
			}
		}
		
		Iterator primeIterator = primeNumbers.iterator();
		while(primeIterator.hasNext()){
			Integer prime = (Integer)primeIterator.next();
			sum += prime;
			//System.out.println(prime);
		}
		System.out.println(sum);
	}
	
	public void find100thPrime(){
		int counter = 0;
		int number = 2;
		while(counter != 10001){
			if(isPrime(number)){
				++counter;
			}
			number = ++number;
		}
		System.out.println(number-1);
	}
	
	public static void main(String[] args){
		PrimeNumbers prime = new PrimeNumbers();
		prime.generatePrime(1000000);
		//prime.generatePrime(2000000);
		
		System.out.println(prime.isPrime(104743));
//		prime.find100thPrime();
	}
}
