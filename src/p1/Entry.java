package p1;

import java.util.ArrayList;

public class Entry {
	
	String company, jobTitle, description, link, date, status, location, clFile;
	
	
	public Entry(ArrayList<String> rowInfo) {
		this.company = rowInfo.get(0);
		this.jobTitle = rowInfo.get(1);
		this.description = rowInfo.get(2);
		this.link = rowInfo.get(3);
		this.date = rowInfo.get(4);
		this.status = rowInfo.get(5);
		this.location = rowInfo.get(6);
		this.clFile = rowInfo.get(7);
		
		
	}

}
