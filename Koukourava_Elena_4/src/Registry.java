import java.util.ArrayList;

public class Registry {

	ArrayList <Suspect> upoptoi = new ArrayList<>();
	private ArrayList <Communication> epikoinwnies = new ArrayList<>();
	private SMS msg;
	private ArrayList<SMS> Messanges = new ArrayList<>();
	
	public void addSuspect(Suspect aSuspect) {
		
		upoptoi.add(aSuspect);
	}
	
	public void addCommunication(Communication aCommunication) {
		
		epikoinwnies.add(aCommunication);
		Suspect upoptos1 = null;
		Suspect upoptos2 = null;
		
		for(int i=0; i<upoptoi.size(); i++) {
			
			ArrayList <String> thlefwna = upoptoi.get(i).getThlefwna();
			
			for(int j=0; j<thlefwna.size();j++) {
				
				if (thlefwna.get(j).equals(aCommunication.getThl1())) {
					upoptos1 = upoptoi.get(i);
				}
			}
		}
		for(int i=0; i<upoptoi.size(); i++) {
			
			ArrayList <String> thlefwna = upoptoi.get(i).getThlefwna();
			
			for(int j=0; j<thlefwna.size();j++) {
				
				if (thlefwna.get(j).equals(aCommunication.getThl2())) {
					upoptos2 = upoptoi.get(i);
				}
			}
		}
		upoptos1.addPithanoiYpoptoi(upoptos2);
	}
	
	public Suspect getSuspectWithMostPartners() {
		
		int max=0;
		int maxsus=0;
		for(int i=0; i<upoptoi.size(); i++) {
			
			if(upoptoi.get(i).getPithanoiYpoptoi().size()>max) {
				max = upoptoi.get(i).getPithanoiYpoptoi().size();
				maxsus = i;
			}
		}
		return upoptoi.get(maxsus);
	}
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2) {
		
		int maxdur=0;
		int maxcall = 0;
		for(int i=0; i<7; i++) {
			
			PhoneCall klhsh = (PhoneCall)epikoinwnies.get(i);
			
			if(epikoinwnies.get(i).getThl1()== number1 && epikoinwnies.get(i).getThl2() == number2) {
				
				if(klhsh.getDiarkeia()>maxdur) {
					maxdur = klhsh.getDiarkeia();
					maxcall = i;
				}
			}
				
		}
		return (PhoneCall)epikoinwnies.get(maxcall);
	}
	public ArrayList <SMS> getMessagesBetween(String number1, String number2) {
		for(Communication i : epikoinwnies) {
			if(i instanceof SMS) {
				if(i.getThl1().equals(number1) && i.getThl2().equals(number2)) {
				
					msg = (SMS) i;                    
					if(msg.getMessage().contains("Bomb")||msg.getMessage().contains("Attack")||msg.getMessage().contains("Explosives")||msg.getMessage().contains("Gun")) {
						Messanges.add(msg);
					}
				}
			}
			
		}

		return Messanges;
	}
	 public void printSuspectsFromCountry(String country) {
		 for(Suspect sus : upoptoi) {
			 if(sus.getXwra() == country) {
				 System.out.println("Suspects coming from "+country+"\n"+sus.getName()+" ("+sus.getCodeName()+")");
			 }
		 }
	 }
	public ArrayList<Suspect> getSuspects(){
		return upoptoi;
	}
}
