package com.zwy.dao;

import com.zwy.beans.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao {


    private JdbcTemplate jdbcTemplate;

    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveStudent(Student student) {
        String sql="insert into student(name,age) values(?,?)";
        jdbcTemplate.update(sql,student.getName(),student.getAge());
    }
}
