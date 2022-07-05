package countries;

import java.util.HashSet;

public class countries {

	public static void main(String[] args) {
		HashSet<String> countriesSet = new HashSet<String>();
		countriesSet.add("Philippines");
		countriesSet.add("Italy");
		countriesSet.add("Singapore");
		countriesSet.add("New Zealand");
		countriesSet.add("Philippines");
		countriesSet.add("Japan");
		
		for(String country: countriesSet){
			System.out.print(country + ", ");
		}
	}//end method main
	
}//end class countries