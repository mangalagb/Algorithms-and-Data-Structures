package callcentre;

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