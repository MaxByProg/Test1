/**
 * Created by mbikov on 05.07.2017.
 */
public class event {
    private String name;
    private int salary;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int age) {
        this.salary = age;
    }

    @Override
    public String toString() {
        return "event: Name = " + this.name + " Salary = " + this.salary;
    }
}
