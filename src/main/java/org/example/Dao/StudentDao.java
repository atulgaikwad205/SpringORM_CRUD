package org.example.Dao;

import org.example.Entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public int insert(Student student){
        Integer i = (Integer) this.hibernateTemplate.save(student);
        return i;
    }

    //get single data(object)
    public Student getStudent(int studentId){
        Student std = this.hibernateTemplate.get(Student.class,studentId);
        return std;
    }

    //get All Students
    public List<Student> getAllStudent(){
        List<Student> stdlist =  this.hibernateTemplate.loadAll(Student.class);
        return stdlist;
    }

    //delete student data
    @Transactional
    public void deleteStudent(int studnetId){
       Student student = this.hibernateTemplate.get(Student.class,studnetId);
        this.hibernateTemplate.delete(student);
    }

    //update student data
    @Transactional
    public void updateStudent(Student student){
        this.hibernateTemplate.update(student);
    }
}
