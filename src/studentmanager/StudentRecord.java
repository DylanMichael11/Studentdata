package studentmanager;

public class StudentRecord {
    private String name;
    private String address;
    private double gpa;

    public StudentRecord(String name, String address, double gpa) {
        this.name = name;
        this.address = address;
        this.gpa = gpa;
    }

    public String getName() { 
        return name; 
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %.2f", name, address, gpa);
    }
}