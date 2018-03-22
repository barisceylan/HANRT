package issue;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Issue {
	private ArrayList<Value> valueList;
	String id;
	public Boolean isDiscrete = true;

	public Issue() {

	}

	public String getId() {
		return id;
	}

	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "value")
	public void setValueList(ArrayList<Value> valueList) {
		this.valueList = valueList;
	}

	public ArrayList<Value> getValueList() {
		return valueList;
	}

}
