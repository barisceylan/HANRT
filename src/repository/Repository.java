package repository;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Repository {



	private ArrayList<RepositoryItem> repItemList;


	public Repository() {

	}

	@XmlElement(name = "repositoryNames")
	public void setRepository(ArrayList<RepositoryItem> repItemList) {
		this.repItemList = repItemList;
	}

	public ArrayList<RepositoryItem> getRepository() {
		return repItemList;
	}

	
}
