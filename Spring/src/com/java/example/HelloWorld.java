package com.java.example;

import com.java.dataobj.Machine;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class HelloWorld {
	
	private String name;
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() throws SQLException {
		System.out.println("Spring 3 : Hello ! " + name);
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		int count = jdbcTemplate.queryForObject("select count(*) from macmachines", Integer.class);
		//System.out.println(count);
		String query = "SELECT machine,MacAddress,site,status from macmachines";
		List<Machine> machineList = jdbcTemplate.query(query, new RowMapper<Machine>() {
			
			public Machine mapRow(ResultSet rs, int rowNum) throws SQLException {
				Machine machine = new Machine();
				machine.setName(rs.getString("machine"));
				machine.setAddress(rs.getString("MacAddress"));
				machine.setSite(rs.getString("site"));
				machine.setStatus(rs.getInt("status"));
				return machine;
			}
			
		});
		
		/*for(Machine machines:machineList) {
			System.out.println(machines.getName());
			System.out.println(machines.getAddress());
			System.out.println(machines.getSite());
			System.out.println(machines.getStatus());
			
		}*/
	}
	
	public void getMachineDetails() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "select t.username as username, count(*) as count from tasks t "
				+ "where id in(select task_id from VCDMachines where status=3 )"
			    + " group by t.username";
		System.out.println(query);
		
		List<Machine> machineList = jdbcTemplate.query(query, new RowMapper<Machine>() {
			
			public Machine mapRow(ResultSet rs, int rowNum) throws SQLException {
				Machine machine = new Machine();
				machine.setName(rs.getString("username"));
				machine.setCount(rs.getInt("count"));
				return machine;
			 }
			});
			
			System.out.println(machineList.size());
			
		for(Machine machine: machineList) {
			System.out.println(machine.getName()+":::"+machine.getCount());
		}
		
		FileWriter writer = null;
		try {
		    writer = new FileWriter("C:\\MachineCount.txt");
			int size = machineList.size();
	        for (int i=0;i<size;i++) {
	            writer.write(machineList.get(i).getName());
	            writer.write(machineList.get(i).getCount());
	            if(i < size-1)
	                writer.write("\n");
	        }
	        writer.close();
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}


/*FileWriter writer = null;
try {
    writer = new FileWriter("MachineCount.xls");
	int size = machines.size();
    for (int i=0;i<size;i++) {
        String str = machines.get(i).toString();
        writer.write(str);
        if(i < size-1)
            writer.write("\n");
    }
    writer.close();
	
} catch(IOException ioe) {
	ioe.printStackTrace();
}*/
