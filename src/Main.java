import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        manager.loadFromFile();


        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student student = new Student(id, name, age, course);
                    manager.addStudent(student);
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    int searchId = sc.nextInt();

                    Student found = manager.searchStudentById(searchId);
                    if (found != null) {
                        System.out.println(
                                "ID: " + found.getId() +
                                        ", Name: " + found.getName() +
                                        ", Age: " + found.getAge() +
                                        ", Course: " + found.getCourse()
                        );
                    } else {
                        System.out.println("❌ Student not found.");
                    }
                    break;


                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = manager.deleteStudent(deleteId);

                    if (deleted) {
                        System.out.println("✅ Student deleted successfully.");
                    } else {
                        System.out.println("❌ Student not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new course: ");
                    String newCourse = sc.nextLine();

                    boolean updated = manager.updateStudent(updateId, newName, newAge, newCourse);

                    if (updated) {
                        System.out.println("✅ Student updated successfully.");
                    } else {
                        System.out.println("❌ Student not found.");
                    }
                    break;



                case 6:
                    manager.saveToFile();
                    System.out.println("👋 Exiting program...");
                    sc.close();
                    return;


                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
