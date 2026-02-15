// Importing required classes
import java.util.ArrayList;
import java.util.Scanner;

// Student class represents individual student data
class Student {

    int id;        // Student ID
    String name;   // Student Name
    int marks;     // Student Marks

    // Constructor to initialize student details
    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    // Method to calculate grade based on marks
    String getGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "Fail";
    }
}
// Main class
public class StudentGradeTracker {
        public static void main(String[] args) {

        // Scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // ArrayList to store student objects
        ArrayList<Student> students = new ArrayList<Student>();

        int choice;        // Variable to store menu choice
        int idCounter = 1; // Auto-increment student ID

        // Menu loop (runs until user selects Exit)
        do {
            System.out.println("\n*********************************");
            System.out.println("      STUDENT GRADE SYSTEM");
            System.out.println("*********************************");
            System.out.println("1. Add New Student");
            System.out.println("2. View Students");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");
            System.out.print("Select Option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Add new student
                    sc.nextLine(); // consume leftover newline

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    // Create Student object and add to list
                    students.add(new Student(idCounter++, name, marks));

                    System.out.println("Student Record Added Successfully!");
                    break;

                case 2:
                    // Display all students
                    displayStudents(students);
                    break;

                case 3:
                    // Generate summary report
                    generateReport(students);
                    break;

                case 4:
                    // Exit program
                    System.out.println("Program Closed Successfully!");
                    break;

                default:
                    // Invalid option handling
                    System.out.println("Invalid Option! Please Try Again.");
            }

        } while (choice != 4);

        sc.close(); // Close scanner
    }
    // Method to display student records
    public static void displayStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No Records Available!");
            return;
        }
        System.out.println("\n----- Student Records -----");
        for (Student s : students) {
            System.out.println("ID: " + s.id +
                    " | Name: " + s.name +
                    " | Marks: " + s.marks +
                    " | Grade: " + s.getGrade());
        }
    }
    // Method to generate summary report
    public static void generateReport(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No Data Available!");
            return;
        }
        int total = 0;
        Student topper = students.get(0);
        // Loop to calculate total and find topper
        for (Student s : students) {
            total += s.marks;

            if (s.marks > topper.marks) {
                topper = s;
            }
        }
        double average = (double) total / students.size();
        // Display summary
        System.out.println("\n========== SUMMARY REPORT ==========");
        System.out.println("Total Students : " + students.size());
        System.out.println("Average Marks  : " + average);
        System.out.println("Topper         : " + topper.name + " (" + topper.marks + ")");
        System.out.println("====================================");
    }
}
