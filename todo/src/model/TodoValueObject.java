package model;

import java.sql.Timestamp;

public class TodoValueObject {

	private int id;
	private String title;
	private String task;
	private Timestamp limitdate;
	private Timestamp lastupdate;
	private String userid;
	private String label;
	private String status;
	private int status2;
	private String inputLimitdate;
	private String filename;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public  String getTitle() {
		return title;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public  String getTask() {
		return task;
	}

	public void setLimitdate(Timestamp limitdate) {
		this.limitdate = limitdate;
	}

	public Timestamp getLimitdate() {
		return limitdate;
	}

	public void setLastupdate(Timestamp lastupdate) {
		this.lastupdate = lastupdate;
	}

	public Timestamp getLastupdate() {
		return lastupdate;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus2(int status2) {
		this.status2 = status2;
	}

	public int getStatus2() {
		return status2;
	}

	public void setInputLimitdate(String inputLimitdate) {
		this.inputLimitdate = inputLimitdate;
	}

	public String getInputLimitdate() {
		return inputLimitdate;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}
}
