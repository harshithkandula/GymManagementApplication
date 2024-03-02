package com.gym.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gym.model.Batch;
import com.gym.model.Participant;

public class Db {
    
	Connection connection;
	PreparedStatement ps;
	
	public Db() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/icon","root","Ias@2025");
		}catch(Exception e) {
			System.out.println("Something went wrong "+e);
		}
	}
	
	public int addBatch(Batch b) {
		int res = 0;
		try {
			String sql = "insert into batch values(?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, b.batchId);
			ps.setString(2, b.batchName);
			ps.setString(3, b.timings);
			ps.setLong(4, b.strength);
			ps.setString(5, b.startdate);
			
			res = ps.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Something went wrong "+e);
		}
		
		return res;
	}
	
	public int addParticipant(Participant p) {
		int res = 0;
		try {
			String sql = "insert into participant values(null, ?, ?, ?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, p.name);
			ps.setString(2, p.dob);
			ps.setString(3, p.gender);
			ps.setString(4, p.batchname);
			ps.setString(5, p.profession);
			ps.setString(6, p.phno);
			ps.setString(7, p.address);
			
			res = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("Something went wrong "+e);
		}
		return res;
	}
	
	public ArrayList<String> fetchAllBatches(){
		ArrayList<String> b = new ArrayList<String>();
		
		String sqlcmd = "select name from batch";
		try {
			ps=connection.prepareStatement(sqlcmd);
			ResultSet set = ps.executeQuery();
			
			while(set.next()) {
				//Batch b1 = new Batch();
				String batchName = set.getString(1);
				
				b.add(batchName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	public ArrayList<String> getBatchName(String bid) {
		ArrayList<String> batchname = new ArrayList<String>();
		String sqlcmd = "select name from batch where id=?";
		try {
			ps=connection.prepareStatement(sqlcmd);
			ps.setString(1, bid);
			
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				String batchName = set.getString(1);
				batchname.add(batchName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return batchname;
		
	}

	
	public ArrayList<Batch> fetchBatchDetails(String bn){
		ArrayList<Batch> bd = new ArrayList<Batch>();
		String sqlcmd = "select * from batch where name=?";
		try {
			ps=connection.prepareStatement(sqlcmd);
			ps.setString(1, bn);
			
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				Batch b = new Batch();
				b.batchId = set.getString(1);
				b.batchName = set.getString(2);
				b.timings = set.getString(3);
				b.strength = set.getInt(4);
				b.startdate = set.getString(5);
				
				bd.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bd;
	}
	
	public ArrayList<Participant> displayParticipantByBatch(String batch_name){
		ArrayList<Participant> pb = new ArrayList<Participant>();
		String sqlcmd = "select * from Participant where name = ?";
		try {
			ps = connection.prepareStatement(sqlcmd);
			ps.setString(1, batch_name);
			
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				Participant p = new Participant();
				p.id = set.getInt(1);
				p.name = set.getString(2);
				p.dob = set.getString(3);
				p.gender = set.getString(4);
				p.batchname = set.getString(5);
				p.profession = set.getString(6);
				p.phno = set.getString(7);
				p.address = set.getString(8);
				
				pb.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pb;
	}
	
	public ArrayList<Participant> displayParticipantByParameters(String p, String val){
		ArrayList<Participant> dpp = new ArrayList<Participant>();
		String sqlcmd1 = "String * from Participant where participant_name=?";
		String sqlcmd2 = "select * from Participant where id = ?";
		int id;
		String name;
		if(p.equalsIgnoreCase("id")) {
			try {
				ps = connection.prepareStatement(sqlcmd2);
				 id = Integer.parseInt(val);
				ps.setInt(1, id);
				ResultSet set = ps.executeQuery();
				while(set.next()) {
					Participant p1 = new Participant();
					p1.id = set.getInt(1);
					p1.name = set.getString(2);
					p1.dob = set.getString(3);
					p1.gender = set.getString(4);
					p1.batchname = set.getString(5);
					p1.profession = set.getString(6);
					p1.phno = set.getString(7);
					p1.address = set.getString(8);
					
					dpp.add(p1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			name = val;
			try {
				ps = connection.prepareStatement(sqlcmd1);
				ps.setString(1, name);
				ResultSet set = ps.executeQuery();
				while(set.next()) {
					Participant p2 = new Participant();
					p2.id = set.getInt(1);
					p2.name = set.getString(2);
					p2.dob = set.getString(3);
					p2.gender = set.getString(4);
					p2.batchname = set.getString(5);
					p2.profession = set.getString(6);
					p2.phno = set.getString(7);
					p2.address = set.getString(8);
					
					dpp.add(p2);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return dpp;
	}
	
	public ArrayList<Participant> displayParticipantByName(String name){
		ArrayList<Participant> pdn = new ArrayList<Participant>();
		String sqlcmd = "select * from participant where  participant_name=?";
		try {
			ps = connection.prepareStatement(sqlcmd);
			ps.setString(1, name);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				Participant p = new Participant();
				p.id = set.getInt(1);
				p.name = set.getString(2);
				p.dob = set.getString(3);
				p.gender = set.getString(4);
				p.batchname = set.getString(5);
				p.profession = set.getString(6);
				p.phno = set.getString(7);
				p.address = set.getString(8);
				
				pdn.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pdn;
	}
	
	public ArrayList<Participant> displayParticipantById(int id){
		ArrayList<Participant> pdi = new ArrayList<Participant>();
		String sqlcmd = "select * from participant where id=?";
		try {
			ps = connection.prepareStatement(sqlcmd);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				Participant p = new Participant();
				p.id = set.getInt(1);
				p.name = set.getString(2);
				p.dob = set.getString(3);
				p.gender = set.getString(4);
				p.batchname = set.getString(5);
				p.profession = set.getString(6);
				p.phno = set.getString(7);
				p.address = set.getString(8);
				
				pdi.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pdi;
	}
	
	public ArrayList<Batch> fetchAllBatchesDetails(){
		ArrayList<Batch> bh = new ArrayList<Batch>();
		String sqlcmd = "select * from batch";
		try {
			ps = connection.prepareStatement(sqlcmd);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				Batch b = new Batch();
				b.batchId = set.getString(1);
				b.batchName = set.getString(2);
				b.timings = set.getString(3);
				b.strength = set.getInt(4);
				b.startdate = set.getString(5);
				
				bh.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bh;
	}
	
	public ArrayList<Participant> displayAllParticipantDetails(){
		ArrayList<Participant> pd = new ArrayList<Participant>();
		String sqlcmd = "Select * from participant";
		try {
			ps = connection.prepareStatement(sqlcmd);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				Participant p =new Participant();
				p.id = set.getInt(1);
				p.name = set.getString(2);
				p.dob = set.getString(3);
				p.gender = set.getString(4);
				p.batchname = set.getString(5);
				p.profession = set.getString(6);
				p.phno = set.getString(7);
				p.address = set.getString(8);
				
				pd.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}
	
	public int updateParticipant(int id, String name, String dob, String gender, String batch, String profession, String phno, String addr) {
		String sqlcmd = "update participant set participant_name = ?, date_of_birth = ?, gender = ?, name = ?, profession=?, phone_number=?, address=? where id=?";
		int res=0;
		try {
			ps = connection.prepareStatement(sqlcmd);
			ps.setString(1, name);
			ps.setString(2, dob);
			ps.setString(3, gender);
			ps.setString(4, batch);
			ps.setString(5, profession);
			ps.setString(6, phno);
			ps.setString(7, addr);
			ps.setInt(8, id);
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public int updateBatch(String id, String name, String timings, int stgth, String sd) {
		String sqlcmd = "update batch set id = ? , timings = ?, strength = ?, start_date = ? where name = ?";
		int res = 0;
		try {
			ps = connection.prepareStatement(sqlcmd);
			ps.setString(1, id);
			ps.setString(2, timings);
			ps.setInt(3, stgth);
			ps.setString(4, sd);
			ps.setString(5, name);
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public int deleteParticipant(int id) {
		String sqlcmd = "Delete from participant where id = ?";
		int res = 0;
		try {
			ps = connection.prepareStatement(sqlcmd);
			ps.setInt(1, id);
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public int deleteBatch(String bn) {
		String sqlcmd = "Delete from batch where name = ?";
		int res = 0;
		try {
			ps = connection.prepareStatement(sqlcmd);
			ps.setString(1, bn);
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public void connection() {
		try {
			connection.close();
		}catch(Exception e) {
			System.out.println("Something went wrong "+e);
		}
	}
	
	
}
