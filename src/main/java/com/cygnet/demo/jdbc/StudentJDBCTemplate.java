package com.cygnet.demo.jdbc;

import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cygnet.demo.dao.StudentDAO;
import com.cygnet.demo.entity.Student;
import com.cygnet.demo.mapper.StudentMapper;

public class StudentJDBCTemplate implements StudentDAO {

//	private DataSource dataSource;

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String name, Integer age) {
		String SQL = "insert into Student (name, age) values (?, ?)";

		jdbcTemplateObject.update(SQL, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);
	}

	public List<Student> listStudents() {
		String SQL = "select * from Student";
		List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		return students;
	}

	@Override
	public Student getStudent(Integer id) {
		String SQL = "select * from Student where id = " + id;
		List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		return Objects.nonNull(students) && students.size() > 0 ? students.get(0) : null;
	}
}