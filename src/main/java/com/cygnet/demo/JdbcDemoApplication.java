package com.cygnet.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.cygnet.demo.entity.Customer;
import com.cygnet.demo.entity.Student;
import com.cygnet.demo.exception.CustomSQLErrorCodeTranslator;
import com.cygnet.demo.jdbc.StudentJDBCTemplate;
import com.cygnet.demo.mapper.CustomerMapper;
import com.cygnet.demo.mapper.StudentMapper;

@SpringBootApplication
public class JdbcDemoApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(JdbcDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);

		log.info("Application context has been loaded succesfully.");

//		ApplicationContext context = new ClassPathXmlApplicationContext("datasource-bean.xml");
//
//		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
//
//		System.out.println("------Records Creation--------");
//		studentJDBCTemplate.create("S1", 11);
//		studentJDBCTemplate.create("S2", 2);
//		studentJDBCTemplate.create("S3", 15);
//
//		System.out.println("------Listing all the Records--------");
//		List<Student> students = studentJDBCTemplate.listStudents();
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	DataSource dataSource;

	@Override
	public void run(String... strings) throws Exception {

//		log.info("Creating tables");
//
//		jdbcTemplate.execute("DROP TABLE IF EXISTS customers");
//		jdbcTemplate.execute("CREATE TABLE customers(" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
//
//		// Split up the array of whole names into an array of first/last names
//		List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
//				.map(name -> name.split(" ")).collect(Collectors.toList());
//
//		// Use a Java 8 stream to print out each tuple of the list
//		splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
//
//		// Uses JdbcTemplate's batchUpdate operation to bulk load data
//		jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
//
//		List<Customer> customers = jdbcTemplate.query("Select * from customers", new CustomerMapper());
//		for (Customer customer : customers) {
//			log.info("Customer ID:{}, First Name : {}, Last Name : {}", customer.getId(), customer.getFirstName(),
//					customer.getLastName());
//		}

		// Custom exception example

//		CustomSQLErrorCodeTranslator customSQLErrorCodeTranslator = new CustomSQLErrorCodeTranslator();
//		jdbcTemplate.setExceptionTranslator(customSQLErrorCodeTranslator);
//
//		String SQL = "insert into Student (id, name, age) values (?, ?, ?)";
//
//		jdbcTemplate.update(SQL, 1, "John Snow", 30);
//		jdbcTemplate.update(SQL, 1, "John Smith", 30);

		//Stored procedure example.
//		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getCustomer");
//
//		SqlParameterSource in = new MapSqlParameterSource().addValue("customerId", 1);
//		Map<String, Object> out = simpleJdbcCall.execute(in);
//
//		System.out.println("First Name:" + out.get("firstname"));
	}
}
