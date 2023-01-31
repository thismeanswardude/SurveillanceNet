import java.util.ArrayList;

public class Suspect {
	
		private String onoma,pseudwnumo,xwra,polh;
		public Suspect (String onoma, String pseudwnumo, String xwra,String polh) {
			
			this.onoma = onoma;
			this.pseudwnumo = pseudwnumo;
			this.xwra = xwra;
			this.polh = polh;
			
		}
		private ArrayList <String> thlefwno = new ArrayList<>();
		
		public void addNumber(String number) {
			
			thlefwno.add(number);
		}
		
		private ArrayList <Suspect> pithanoiupoptoi = new ArrayList<>();
		
		public void addPithanoiYpoptoi(Suspect aSuspect) {
			
			int count=0;
			for(int i=0; i<pithanoiupoptoi.size(); i++) {
				
				if(pithanoiupoptoi.get(i).onoma.equals(aSuspect.onoma)) {
					
					count=1;	
				}
			}
			if (count==0) {
				pithanoiupoptoi.add(aSuspect);
			}
		}
		
		
		public boolean isConnectedTo(Suspect aSuspect) {
			
			for(int i=0; i<pithanoiupoptoi.size(); i++) {
				
				if(pithanoiupoptoi.get(i).onoma.equals(aSuspect.onoma))
					
					return true;
					
			}
			return false;
		}
		
		private ArrayList <Suspect> koinufoftoi = new ArrayList<>();
		
		public ArrayList <Suspect> getCommonPartners(Suspect aSuspect) {
			
			for(int i=0; i<pithanoiupoptoi.size(); i++) {
				
				if(pithanoiupoptoi.get(i).isConnectedTo(aSuspect)) {
					
					koinufoftoi.add(pithanoiupoptoi.get(i));
				}
			}
			return koinufoftoi;
		}
		
		public void printSUS() {
			
			for(int i=0; i<pithanoiupoptoi.size();i++) {
				
				System.out.println(pithanoiupoptoi.get(i).onoma+" "+pithanoiupoptoi.get(i).pseudwnumo);
			}
		}
		public String getName() {
			
			return onoma;
		}
		public String getCodeName() {
			
			return pseudwnumo;
		}
		
		public String getXwra() {
			
			return xwra;
		}		
			
		private ArrayList<Suspect> suggestedParteners = new ArrayList<>();
		
		public ArrayList<Suspect> sort(ArrayList<Suspect> s){
			for(int i = 0; i < s.size(); i++) {
				for(int j=s.size()-1 ; j > i ; j--) {
					if(s.get(j).getName().compareTo(s.get(i).getName()) < 0) {
						Suspect temp = s.get(i);
						s.set(i,s.get(j));
						s.set(j, temp);
					}
				}
			}
			return s;
		}
		
		public ArrayList<Suspect> addSuggestedParteners(){
			for(Suspect s : pithanoiupoptoi) {
				for(Suspect s1 : s.pithanoiupoptoi) {
					if(!this.isConnectedTo(s1) && !this.equals(s1)) {
						suggestedParteners.add(s1);
					}
				}
			}
			this.sort(suggestedParteners);
			for(Suspect i : suggestedParteners) {
				System.out.println(i.onoma);
			}
			return suggestedParteners;
		}
		
		public ArrayList<Suspect> getSuggestedParteners(){
			
			return suggestedParteners;
		}	
		public ArrayList <String> getThlefwna(){
			
			return thlefwno;
		}
		public ArrayList <Suspect> getPithanoiYpoptoi(){
			
			return pithanoiupoptoi;
		}
		
		public ArrayList<Suspect> getPossibleSuspects() {
			return pithanoiupoptoi;
		}
		
		public ArrayList<String> getTelephoneNum() {
			return thlefwno;
		}
}
