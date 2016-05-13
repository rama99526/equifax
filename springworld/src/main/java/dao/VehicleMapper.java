package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Vehicle;

public class VehicleMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vehicle vehicle = new Vehicle();
		vehicle.setvId(rs.getString("vId"));
		vehicle.setVModleName(rs.getString("VModelName"));
		vehicle.setvModelYear(rs.getString("vModelYear"));
		return vehicle;
	}
	
	

}
