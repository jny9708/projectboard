package com.young.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/data-context.xml"})
public class ConnectionTest {
	
	@Inject
	DataSource datasource; 
	
//	@Inject
//	private SqlSessionFactory sqlsession;
//	
	@Test
	public void test() {
		
		try {
			Connection conn = datasource.getConnection();
			System.out.println("¿¬°á"+conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
