import java.util.ArrayList;


public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    //add student
    public void addStudent(Student student){
        students.add(student);
        System.out.println("✅ Student added successfully!");

    }


    //view student

    public void viewStudent(){ 
        if(students.isEmpty()){
            System.out.println("⚠ No students found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for(Student s : students){
            System.out.println("ID: "+s.getId()+", Name: "+ s.getName() + ", Age: " + s.getAge() + ", Course: " + s.getCourse());
        }

    }
}
