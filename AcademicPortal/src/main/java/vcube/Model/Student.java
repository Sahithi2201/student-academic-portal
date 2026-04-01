

package vcube.Model;

public class Student {
    private int id;
    private String firstName,lastName,username,password,mobile,email,course;

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName=firstName;}

    public String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName=lastName;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username=username;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}

    public String getMobile(){return mobile;}
    public void setMobile(String mobile){this.mobile=mobile;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public String getCourse(){return course;}
    public void setCourse(String course){this.course=course;}
}
