package negotitation;

import java.util.ArrayList;
import java.util.List;

import issue.Issue;
import issue.Value;



public class Offer {

	ArrayList<String> valueOfferList = new ArrayList<String>();
	ArrayList<Double> doubleOfferList = new ArrayList<Double>();
	
	
	Offer(ArrayList<String> valueList,ArrayList<Double> doubleOfferList ){
		
		this.valueOfferList = valueList;
		this.doubleOfferList = doubleOfferList;
		
	}
	
	public void setValueOfferList(ArrayList<String> valueOfferList) {
		this.valueOfferList = valueOfferList;
	}

	public ArrayList<String> getValueOfferList() {
		return valueOfferList;
	}
	
	
}
