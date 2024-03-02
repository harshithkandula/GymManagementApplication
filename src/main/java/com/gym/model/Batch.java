package com.gym.model;

import java.util.Date;

public class Batch {

	
	public String batchName;
    public String batchId;
    public String timings;
    public int strength;
    public String startdate;
    
    public Batch() {
    	
    }

	public Batch(String batchName, String batchId, String timings, int strength, String startdate) {
		this.batchName = batchName;
		this.batchId = batchId;
		this.timings = timings;
		this.strength = strength;
		this.startdate = startdate;
	}
    
    
}
