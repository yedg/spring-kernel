package com.zwy.service;

import com.zwy.beans.Student;
import com.zwy.dao.StudentDao;

public class StudentServiceImpl implements  StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }
}
