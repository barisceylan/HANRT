package repository;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class RepositoryItem {

	
	String path;
	
	public RepositoryItem(){
		
	}
	
	@XmlAttribute
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
}
