package org.example;

import org.example.Dao.StudentDao;
import org.example.Entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        StudentDao std = context.getBean("studentDao" , StudentDao.class);

        //insert method call
        std.insert(new Student(111,"Atul","Pune"));

        // getAllStudent method call
         List<Student> stdlist =  std.getAllStudent();

         //printed list of student
         for (Student  s : stdlist){
             System.out.println(s.getId()+s.getName()+s.getCity());
         }

         // get single student method call
         Student s =  std.getStudent(111);
         System.out.println(s.getId()+s.getName()+s.getCity());

         // delete studnet method call
         std.deleteStudent(111);

         //update student method call
         std.updateStudent(new Student(111,"Pooja","Kolhapur"));

        System.out.println("Done..");
    }
}
