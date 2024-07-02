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

       // std.insert(new Student(222,"Ayush","UP"));

         List<Student> stdlist =  std.getAllStudent();

         for (Student  s : stdlist){
             System.out.println(s.getId()+s.getName()+s.getCity());
         }
         Student s =  std.getStudent(111);
         System.out.println(s.getId()+s.getName()+s.getCity());

         std.deleteStudent(222);

         std.updateStudent(new Student(111,"Pooja","Kolhapur"));

        System.out.println("Done..");
    }
}
