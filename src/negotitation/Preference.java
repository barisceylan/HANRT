package negotitation;
	import java.util.ArrayList;

	import javax.xml.bind.annotation.XmlAttribute;
	import javax.xml.bind.annotation.XmlElement;
	import javax.xml.bind.annotation.XmlRootElement;

	import issue.Issue;
	import repository.RepositoryItem;

	@XmlRootElement
	public class Preference {

		String id;
		private ArrayList<Issue> issueList;
		
		
		public String getId() {
			return id;
		}

		@XmlElement
		public void setId(String id) {
			this.id = id;
		}
		
		@XmlElement(name = "issue")
		public void setIssueList(ArrayList<Issue> issueList) {
			this.issueList = issueList;
		}

		public ArrayList<Issue> getIssueList() {
			return issueList;
		}

		
		
	
	
}
