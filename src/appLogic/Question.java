package appLogic;

public class Question {
	
	private String qContents;
	private String qAnswer;
	private int qNumber;
	private String imageFilePath;
	
	public Question(String qName, String qAns, int qNum) {
		qContents = qName;
		qAnswer = qAns;
		qNumber = qNum;
	}
	
	public void setImageFilePath(String path) {
		imageFilePath = path;
	}
	public String getImageFilePath() {
		return imageFilePath;
	}
	public int getqNumber() {
		return qNumber;
	}
	public String getAnswer() {
		return qAnswer;
	}
	public String getContents() {
		return qContents;
	}

}
