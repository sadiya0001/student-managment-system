import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

//Create file name variable




public class StudentManager {


    private final String FILE_NAME = "students.txt";

    private ArrayList<Student> students = new ArrayList<>();


    //Save students method
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getCourse());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    //Load students method
    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String course = parts[3];

                students.add(new Student(id, name, age, course));
            }
        } catch (IOException e) {
            // file may not exist first time
        }
    }



    //add student
    public void addStudent(Student student){
        if (searchStudentById(student.getId()) != null) {
            System.out.println("❌ Student ID already exists!");

        }

        else{
            students.add(student);
            System.out.println("✅ Student added successfully!");

        }


    }


    //view student`

    public void viewStudents(){
        if(students.isEmpty()){
            System.out.println("⚠ No students found.");

        }else{

        System.out.println("\n--- Student List ---");
        for(Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Age: " + s.getAge() + ", Course: " + s.getCourse());
        }
        }

    }

    //search student
    public Student searchStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        Student s = searchStudentById(id);
        if (s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }
    public boolean updateStudent(int id, String name, int age, String course) {
        Student s = searchStudentById(id);

        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setCourse(course);
            return true;
        }

        return false;
    }


}
