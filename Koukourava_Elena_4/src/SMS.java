
public class SMS extends Communication{
	
private String mhnuma;
	
	public SMS (String thl1, String thl2, int mera, int mhnas, int xronos, String mhnuma) {
		
		super(thl1,thl2,mera,mhnas,xronos);
			
		this.mhnuma = mhnuma;

	}
	public String getTXT() {
		
		return mhnuma;
	}
	
public void printInfo() {
		
		System.out.println("This SMS has the following info");
		System.out.println("Between "+super.getThl1()+" --- "+super.getThl2());
		System.out.println("on "+super.getXronos()+"/"+super.getMhnas()+"/"+super.getMera());
		System.out.println("Text: "+mhnuma);
	}

public String getMessage() {
	return mhnuma;
}
}
