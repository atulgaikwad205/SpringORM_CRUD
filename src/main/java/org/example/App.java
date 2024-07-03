package org.example;

import org.example.Dao.StudentDao;
import org.example.Entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Boolean go =true;

        while (go) {
            System.out.println("Press 1 to insert Student Data");
            System.out.println("Press 2 to Get All Student Data");
            System.out.println("Press 3 to Get Student Data By Id");
            System.out.println("Press 4 to Delete Student Data");
            System.out.println("Press 5 to Update Student Data");
            System.out.println("Press 6 to Exit");
            try {
                int input = Integer.parseInt(bf.readLine());
                switch (input) {
                    case 1:
                        System.out.println("You Choose Insert Student Data Option");
                        System.out.println("Please Enter Student Id : ");
                        int id = Integer.parseInt(bf.readLine());
                        System.out.println("Please Enter Student Name : ");
                        String name = bf.readLine();
                        System.out.println("Please Enter Student City : ");
                        String city = bf.readLine();
                        std.insert(new Student(id,name,city));
                        break;

                    case 2:
                        System.out.println("You Choose Get All Student Data Option");
                        System.out.println("Below is the List Of All Student");
                        List<Student> stdlist =  std.getAllStudent();
                        for (Student  s : stdlist){
                           System.out.println(s.getId()+"  "+s.getName()+"  "+s.getCity());
                        }
                        break;

                    case 3:
                        System.out.println("You Choose Get Single Student Data Option");
                        System.out.println("Please Enter Student Id To get Data: ");
                        int id1 = Integer.parseInt(bf.readLine());
                        Student s =  std.getStudent(id1);
                         System.out.println(s.getId()+"  "+s.getName()+"  "+s.getCity());
                        break;

                    case 4:
                        System.out.println("You Choose Delete Student Data Option");
                        System.out.println("Please Enter Student Id To Delete Data: ");
                        int id2 = Integer.parseInt(bf.readLine());
                        std.deleteStudent(id2);
                        break;

                    case 5:
                        System.out.println("You Choose Update Student Data Option");
                        System.out.println("Please Enter Student Id : ");
                        int id3 = Integer.parseInt(bf.readLine());
                        System.out.println("Please Enter Student Name : ");
                        String name1 = bf.readLine();
                        System.out.println("Please Enter Student City : ");
                        String city1 = bf.readLine();
                        std.updateStudent(new Student(id3,name1,city1));
                        break;

                    case 6:
                        go = false;
                        System.out.println("Thanks For Using Our App..!");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
