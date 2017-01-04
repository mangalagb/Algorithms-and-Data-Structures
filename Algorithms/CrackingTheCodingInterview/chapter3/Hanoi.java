package chapter3;

public class Hanoi
{
	public String myHanoi(int N, int fromPeg, int toPeg)
	{
		String sol1,myStep,sol2,finalSol;
		int helperPeg = 6-fromPeg-toPeg;
		
		if(N==1)
			return (fromPeg+"->"+toPeg+"\n");
		else
			{
				sol1 = myHanoi(N-1,fromPeg,helperPeg);
				myStep = fromPeg+"->"+toPeg+"\n";
				sol2 = myHanoi(N-1, helperPeg, toPeg);
				finalSol = sol1+myStep+sol2;
				return finalSol;
			}
	}
	
	public static void main(String[] args)
	{
		Hanoi h = new Hanoi();
		String ans = h.myHanoi(3, 1, 3);
		System.out.println(ans);
		
	}
}