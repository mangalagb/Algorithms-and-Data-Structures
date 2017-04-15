package callcentre;

/*Imagine you have a call center with three levels of employees:
fresher, technical lead (TL),product manager(PM) 
There can be multiple employees,but only one TL or PM
An incoming telephone call must be allocated to a fresher who is free
can’t handle the call, he or she must escalate the call to technical lead
not free or not able to handle it, then the call should be escalated to PM
classes and data structures for this problem Implement a method getCallHandler()*/

public class Company{
	static String companyName = "Google";
	Fresher[] freshers;
	ProductLead productLead;
	TechnicalLead technicalLead;
	
	public void initializeEmployees(){
		freshers = new Fresher[2];
		productLead = new ProductLead();
		technicalLead = new TechnicalLead();
	}
	
	public void getCall() throws InterruptedException{
		boolean callHandled = false;
		
		for(int i=0;i<freshers.length; i++){
			Fresher currentfresher = freshers[i];
			if(currentfresher.isFree()){
				callHandled = true;
				currentfresher.getCall();
				return;
			}else{
				continue;
			}
		}
		
		if(!callHandled){
			if(technicalLead.isFree()){
				callHandled = true;
				technicalLead.getCall();
				return;
			}
		}
		
		if(!callHandled){
			if(productLead.isFree()){
				callHandled = true;
				productLead.getCall();
				return;
			}
		}
		
		if(!callHandled){
			System.out.println("All of our employees are currently busy. Please hold.");
			waitForFreeEmployee();
		}
	}
	
	public void waitForFreeEmployee() throws InterruptedException{
		Thread.sleep(1000);
		getCall();
	}
	
	
}