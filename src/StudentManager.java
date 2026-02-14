import java.util.ArrayList;


public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    //add student
    public void addStudent(Student student){
        students.add(student);
        System.out.println("✅ Student added successfully!");

    }


    //view student`

    public void viewStudent(){ 
        if(students.isEmpty()){
            System.out.println("⚠ No students found.");
            return;
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
