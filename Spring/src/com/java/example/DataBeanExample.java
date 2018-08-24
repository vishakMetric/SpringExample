package com.java.example;
import javax.sql.DataSource;
import java.sql.SQLException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
public class DataBeanExample {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void getDataExample() throws SQLException {
		String query = "SELECT machine,MacAddress,site,status from macmachines where machine=:machine";
		
		
	}

}
