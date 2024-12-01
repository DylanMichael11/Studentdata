package studentmanager;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.io.PrintWriter;
import java.io.IOException;

public class StudentManager {
    public static void main(String[] args) {
        List<StudentRecord> students = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter student name (or 'done' to finish): ");
            String name = scanner.nextLine();
            
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter student address: ");
            String address = scanner.nextLine();

            double gpa;
            while (true) {
                try {
                    System.out.print("Enter GPA (0.0-4.0): ");
                    gpa = Double.parseDouble(scanner.nextLine());
                    
                    if (gpa >= 0.0 && gpa <= 4.0) break;
                    System.out.println("GPA must be between 0.0 and 4.0");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid GPA. Please enter a numeric value.");
                }
            }

            students.add(new StudentRecord(name, address, gpa));
        }

        // Sort students by name
        students.sort(Comparator.comparing(StudentRecord::getName));

        // Write to file
        try (PrintWriter writer = new PrintWriter("students.txt")) {
            for (StudentRecord student : students) {
                writer.println(student);
            }
            System.out.println("Student list saved to students.txt");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        scanner.close();
    }
}