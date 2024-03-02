package com.gym.model;

public class Participant {

	public int id;
	public String name;
	public String dob;
	public String gender;
	public String batchname;
	public String profession;
	public String phno ;
	public String address;
	
	public Participant(){
		
	}

	public Participant(int id, String name, String dob, String gender, String batchname, String profession, String phno,
			String address) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.batchname = batchname;
		this.profession = profession;
		this.phno = phno;
		this.address = address;
	}
	
	
}
