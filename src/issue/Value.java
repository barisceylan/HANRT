package issue;

import javax.xml.bind.annotation.XmlElement;

public class Value {

	String id;
    Double preference;
	
	public Value() {

	}

	public String getId() {
		return id;
	}

	@XmlElement
	public void setId(String id) {
		this.id = id;
	}
	
	
	public Double getPreference() {
		return preference;
	}

	public void setPreference(Double preference) {
		this.preference = preference;
	}
}
