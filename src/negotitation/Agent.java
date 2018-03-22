package negotitation;

import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import issue.Issue;

public class Agent {

	StyledDocument doc = NegotiationAvatar.doc;
	SimpleAttributeSet right = NegotiationAvatar.right;
	private Random randomGenerator = new Random();
	NegotiationAvatar avatarPicture;
	Offer humanOffer;

	ArrayList<String> preferenceValues = new ArrayList<String>();
	ArrayList<Double> agentPreferenceDoubles = new ArrayList<Double>();

	ArrayList<String> humanValues = new ArrayList<String>();
	//ArrayList<Double> humanDoubles = new ArrayList<Double>();

	ArrayList<Double> doublesOfHumanOfferToAgent = new ArrayList<Double>();

	ArrayList<String> agentCounterOfferValues = new ArrayList<String>();
	ArrayList<Double> agentCounterOfferDoubles = new ArrayList<Double>();

	Double humanOfferWeight = 0.0;
	Double agentOfferWeight = 0.0;

	static String agentResult = "";

	String humanResult = "";
	static int checker=0;
	int index = 0;
	int index2 = 0;
	int index3 = 0;
	static int avatarChecker = 0;
	List<Double> issue1Doubles = new ArrayList<Double>();
	List<Double> issue2Doubles = new ArrayList<Double>();
	List<Double> issue3Doubles = new ArrayList<Double>();

	List<String> issue1Values = new ArrayList<String>();
	List<String> issue2Values = new ArrayList<String>();
	List<String> issue3Values = new ArrayList<String>();

	Agent(Offer humanOffer) {
		this.humanOffer = humanOffer;

		humanValues = humanOffer.getValueOfferList();
		

		agentResult = "";

		getDoublePreferences();

		createPreferenceLists();

		issue1Doubles = agentPreferenceDoubles.subList(0, 3);
		issue2Doubles = agentPreferenceDoubles.subList(3, 6);
		issue3Doubles = agentPreferenceDoubles.subList(6, 9);

		if (NegotiationAvatar.offerCounter == 1) {

			makeFirstOffer();

		} else {

			makeCounterOffer();

		}

	}

	public void getDoublePreferences() {
		try {
			File file = new File("./Preferences/travel_preference.xml");

			JAXBContext jaxbContext = JAXBContext.newInstance(Preference.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Preference preference = (Preference) jaxbUnmarshaller.unmarshal(file);
			ArrayList<Issue> list = preference.getIssueList();

			for (int k = 0; k < list.size(); k++) {
				Issue tempIssue = list.get(k);

				for (int m = 0; m < tempIssue.getValueList().size(); m++) {

					agentPreferenceDoubles.add(tempIssue.getValueList().get(m).getPreference());
					// System.out.println(tempIssue.getValueList().get(m).getPreference());

				}
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void makeCounterOffer() {

		issue1Values = preferenceValues.subList(0, 3);
		issue2Values = preferenceValues.subList(3, 6);
		issue3Values = preferenceValues.subList(6, 9);

		

		for (int i = 0; i < humanValues.size(); i++) {

			for (int j = 0; j < preferenceValues.size(); j++) {

				if (preferenceValues.get(j).equals(humanValues.get(i))) {
					
					humanOfferWeight = humanOfferWeight + agentPreferenceDoubles.get(j);
				}
			}
		}

	

		if (humanOfferWeight > 2.4) {
		
			// ACCEPT OFFER

			for (int i = 0; i < humanValues.size(); i++) {
				humanResult = humanResult + NegotiationAvatar.negoDomain.getIssueList().get(i).getId() + ": "
						+ humanValues.get(i).toUpperCase() + " ";
			}

			ResultPage resultPage = new ResultPage(humanResult);
			resultPage.setVisible(true);
		
			 NegotiationAvatar.frame.dispose();

		} else if (1.8 < humanOfferWeight & humanOfferWeight <= 2.4) {

			// SMILE
			checker = checker + 1;
			NegotiationAvatar.changer(checker);
			
			// gýve counter OFFER
			checker--;
			getRandomOfferDoubles();

			writeAgentOffer();

		} else if (1.0 < humanOfferWeight & humanOfferWeight <= 1.8) {

			// NORMAL FACE
			checker = checker + 2;
			NegotiationAvatar.changer(checker);
			
			// gýve counter OFFER
			checker = checker -2;
			getRandomOfferDoubles();

			writeAgentOffer();

		} else if (humanOfferWeight <= 1.0) {

			// SAD FACE
			checker = checker + 3;
			NegotiationAvatar.changer(checker);
			
			// gýve counter OFFER
			checker = checker-3;
			getRandomOfferDoubles();

			writeAgentOffer();
		}

	}

	public void writeAgentOffer() {
		if (agentOfferWeight > 1.0) {
			try {
				doc.setParagraphAttributes(doc.getLength(), 1, right, false);
				doc.insertString(doc.getLength(), "\nAGENT: My Offer is; \n", right);

				agentResult = NegotiationAvatar.negoDomain.getIssueList().get(0).getId() + ": "
						+ issue1Values.get(index).toUpperCase() + " "
						+ NegotiationAvatar.negoDomain.getIssueList().get(1).getId() + ": "
						+ issue2Values.get(index2).toUpperCase() + " "
						+ NegotiationAvatar.negoDomain.getIssueList().get(2).getId() + ": "
						+ issue3Values.get(index3).toUpperCase();

				doc.insertString(doc.getLength(), agentResult, right);
				doc.setParagraphAttributes(doc.getLength(), 1, right, false);

				doc.insertString(doc.getLength(), "\n", right);

				agentCounterOfferDoubles.clear();
			} catch (Exception e) {

			}

		} else {
			getRandomOfferDoubles();
		}
	}

	private void getRandomOfferDoubles() {
		// System.out.println(issue1Doubles.size() + " BURDAYIM");
		index = randomGenerator.nextInt(issue1Doubles.size());
		Double counterOfferDouble1 = issue1Doubles.get(index);

		index2 = randomGenerator.nextInt(issue2Doubles.size());
		Double counterOfferDouble2 = issue2Doubles.get(index2);

		index3 = randomGenerator.nextInt(issue3Doubles.size());
		Double counterOfferDouble3 = issue3Doubles.get(index);

		agentOfferWeight = counterOfferDouble3 + counterOfferDouble3 + counterOfferDouble3;
	}

	public void makeFirstOffer() {

		
		issue1Doubles = agentPreferenceDoubles.subList(0, 3);
		issue2Doubles = agentPreferenceDoubles.subList(3, 6);
		issue3Doubles = agentPreferenceDoubles.subList(6, 9);

		issue1Values = preferenceValues.subList(0, 3);
		issue2Values = preferenceValues.subList(3, 6);
		issue3Values = preferenceValues.subList(6, 9);

		Double maxIssue1 = Collections.max(issue1Doubles);
		for (int a = 0; a < issue1Doubles.size(); a++) {
			if (issue1Doubles.get(a) == maxIssue1) {
				agentCounterOfferValues.add(preferenceValues.get(a));
			}
		}

		Double maxIssue2 = Collections.max(issue2Doubles);
		for (int a = 0; a < issue2Doubles.size(); a++) {
			if (issue2Doubles.get(a) == maxIssue2) {
				agentCounterOfferValues.add(preferenceValues.get(3 + a));
			}
		}
		Double maxIssue3 = Collections.max(issue3Doubles);
		for (int a = 0; a < issue3Doubles.size(); a++) {
			if (issue3Doubles.get(a) == maxIssue3) {
				agentCounterOfferValues.add(preferenceValues.get(6 + a));
			}
		}

		agentCounterOfferDoubles.add(maxIssue1);
		agentCounterOfferDoubles.add(maxIssue2);
		agentCounterOfferDoubles.add(maxIssue3);
		// YAZDIRMA
		try {
			doc.setParagraphAttributes(doc.getLength(), 1, right, false);
			doc.insertString(doc.getLength(), "\nAGENT: My Offer is; \n", right);
			for (int i = 0; i < agentCounterOfferDoubles.size(); i++) {

				doc.insertString(doc.getLength(), NegotiationAvatar.negoDomain.getIssueList().get(i).getId() + ": "
						+ agentCounterOfferValues.get(i).toUpperCase() + " ", right);
				doc.setParagraphAttributes(doc.getLength(), 1, right, false);
			}
			doc.insertString(doc.getLength(), "\n", right);

			agentCounterOfferDoubles.clear();
		} catch (Exception e) {

		}

	}

	public void createPreferenceLists() {
		preferenceValues.add("grand");
		preferenceValues.add("medium");
		preferenceValues.add("low");
		preferenceValues.add("january");
		preferenceValues.add("june");
		preferenceValues.add("september");
		preferenceValues.add("barcelona");
		preferenceValues.add("paris");
		preferenceValues.add("antalya");
	}
}
