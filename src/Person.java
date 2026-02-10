import java.util.Calendar;
import java.util.Objects;

public class Person {

    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    public Person(String IDNum, String firstName, String lastName, String title, int YOB) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getIDNum() { return IDNum; }
    public void setIDNum(String IDNum) { this.IDNum = IDNum; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getYOB() { return YOB; }
    public void setYOB(int YOB) { this.YOB = YOB; }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFormalName() {
        return title + " " + getFullName();
    }

    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear - YOB);
    }

    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    public String toCSV() {
        return IDNum + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    public String toXML() {
        return "<Person>" +
                "<IDNum>" + IDNum + "</IDNum>" +
                "<firstName>" + firstName + "</firstName>" +
                "<lastName>" + lastName + "</lastName>" +
                "<title>" + title + "</title>" +
                "<YOB>" + YOB + "</YOB>" +
                "</Person>";
    }

    public String toJSON() {
        return "{" +
                "\"IDNum\":\"" + IDNum + "\"," +
                "\"firstName\":\"" + firstName + "\"," +
                "\"lastName\":\"" + lastName + "\"," +
                "\"title\":\"" + title + "\"," +
                "\"YOB\":" + YOB +
                "}";
    }

    @Override
    public String toString() {
        return "Person{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB &&
                Objects.equals(IDNum, person.IDNum) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(title, person.title);
    }
}