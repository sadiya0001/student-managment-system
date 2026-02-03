public class Student {
    private int id ;
    private String name ;
    private int age;
    private String course ;

    //constructor
public Student (int id,String name,int age, String course){

    this.id=id;
    this.name=name;
    this.age=age;
    this.course=course;

  }


    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setName(String name) {
        this.name = name;
    }
}
