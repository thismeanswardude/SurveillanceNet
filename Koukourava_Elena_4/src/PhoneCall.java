
public class PhoneCall extends Communication{
	
	private int diarkeia;
	
	public PhoneCall (String thl1, String thl2, int mera, int mhnas, int xronos, int diarkeia) {
		
		super(thl1,thl2,mera,mhnas,xronos);
			
		this.diarkeia = diarkeia;
	}
	
	public int getDiarkeia() {
		
		return diarkeia;
	}
	public void printInfo() {
		
		System.out.println("This phone call has the following info");
		System.out.println("Between "+super.getThl1()+" --- "+super.getThl2());
		System.out.println("on "+super.getXronos()+"/"+super.getMhnas()+"/"+super.getMera());
		System.out.println("Duration: "+diarkeia);
	}
}
