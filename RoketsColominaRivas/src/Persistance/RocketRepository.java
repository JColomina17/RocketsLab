package Persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Domain.Rocket;

public class RocketRepository {
	
	public static void storeRocket(Rocket r) throws Exception {
		
		ConnectionBBDD connection=ConnectionRepository.getConnection();
		String sql="Insert into ROCKETS(NAMEOFTHEROCKET,TIME) values (?,?)";
		PreparedStatement pst=connection.prepareStatement(sql);
		pst.setString(1, r.getName());
		pst.setString(2, Integer.toString((int) r.getTime()));
		if(pst.executeUpdate()!=1) {
			throw new Exception();  	
		}
	}
	public static Rocket getRocket(String name) throws Exception {
		ConnectionBBDD connection= ConnectionRepository.getConnection();
		try {
			String sql= "SELECT * FROM ROCKETS WHERE NAMEOFTHEROCKET=?";
			PreparedStatement preparedStatment= connection.prepareStatement(sql);
			preparedStatment.clearParameters();
			preparedStatment.setString(1, name);
			ResultSet rs=preparedStatment.executeQuery();
			if(rs.next()) {
				String rname= rs.getString("NAMEOFTHEROCKET");
				int time=rs.getInt("TIME");
				return new Rocket(rname,time);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
		
		return null;
		
	}

}