package BasicPrograms;
public class ParanthesisMatcher{
	
	static void isMatched(String[] values){
		class Stack{
			class Node{
				Node next;
				String data;
				
				public Node(String i){
					data = i;
					next = null;
				}
			}
			
			Node top;
			public Stack(){
				top = null;
			}
			
			public void push(String data){
				if(top == null){
					top = new Node(data);
					return;
				}
				
				Node newNode = new Node(data);
				newNode.next = top;
				top = newNode;
			}
			
			public boolean isEmpty(){
				if(top == null){
					return true;
				}
				return false;
			}
			
			public String pop(){
				if(top == null){
					return null;
				}
				
				Node nodeToBeReturned = top;
				top = top.next;
				return nodeToBeReturned.data;
			}
			
			public void clearStack(){
				while(top != null){
					top = top.next;
				}
			}
		}
	
		Stack stack = new Stack();
		boolean[] result = new boolean[values.length];
		for(int i=0;i<result.length;i++){
			result[i] = true;
		}
		
		for(int i=0;i<values.length;i++){
			String target = values[i];
			stack.clearStack();
			
			if(target.isEmpty()){
				result[i] = false;
				continue;
			}
			
			for(int j=0;j<target.length();j++){
				String charToBeAnalyzed = String.valueOf(target.charAt(j));
				
				if(charToBeAnalyzed.equals("{") || charToBeAnalyzed.equals("(") || charToBeAnalyzed.equals("[")){
					stack.push(charToBeAnalyzed);
				}
				
				if(charToBeAnalyzed.equals("}") || charToBeAnalyzed.equals(")") || charToBeAnalyzed.equals("]")){
					if(stack.isEmpty()){
						result[i] = false;
						continue;
					}
					
					String elementOnTopOfStack = stack.pop();
					
						if(charToBeAnalyzed.equals("}") && !elementOnTopOfStack.equals("{")){
						result[i] = false;
						continue;
					}
					
						if(charToBeAnalyzed.equals("]") && !elementOnTopOfStack.equals("[")){
						result[i] = false;
						continue;
					}
					
						if(charToBeAnalyzed.equals(")") && !elementOnTopOfStack.equals("(")){
						result[i] = false;
						continue;
					}
				}				
			}
			
			if(!stack.isEmpty()){
				result[i] = false;
				continue;
			}			
		}
		
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
	
	
	public static void main(String[] args){
		String[] values = {"[]{}", "{[}]", "[{({[({})]})}]", "{", "", "()[]"};
		isMatched(values);
	}
}