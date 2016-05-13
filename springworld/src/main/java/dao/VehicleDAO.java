package dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Vehicle;

public class VehicleDAO {
	
	private DataSource dataSource;	
		
	private JdbcTemplate jdbcTemplateObject;
	
	public Vehicle getVehicleDetails(String vId){		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);		
		Vehicle vehicle = jdbcTemplate.queryForObject("SELECT * FROM Vehicle WHERE V_ID='"+vId+"'", new VehicleMapper());		
		return vehicle;
		
	}

}
