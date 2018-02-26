package com.bootmongo.starter.model;

public class ResponseUnit {
	private int reponseCode;
	private String messsageBody;
	
	public ResponseUnit(int responseCode, String messageBody) {
		this.reponseCode = responseCode;
		this.messsageBody = messageBody;
	}

	public int getReponseCode() {
		return reponseCode;
	}

	public void setReponseCode(int reponseCode) {
		this.reponseCode = reponseCode;
	}

	public String getMesssageBody() {
		return messsageBody;
	}

	public void setMesssageBody(String messsageBody) {
		this.messsageBody = messsageBody;
	}

}
