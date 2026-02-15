// Import required classes
import java.util.ArrayList;  // Used to store dynamic list of students
import java.util.Scanner;    // Used to take user input

// Student class represents individual student data
class Student {

    int id;        // Unique Student ID
    String name;   // Student Name
    int marks;     // Student Marks
    // Constructor to initialize student details when object is created
    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    // Method to calculate grade based on marks
    String getGrade() {

        // Grade logic using if-else conditions
        if (marks >= 90)
            return "A";
        else if (marks >= 75)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 40)
            return "D";
        else
            return "Fail";
    }
}
// Main class
public class StudentGradeTracker {
    // Main method - program execution starts here
    public static void main(String[] args) {

        // Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // ArrayList to store multiple Student objects dynamically
        ArrayList<Student> students = new ArrayList<>();

        int choice;        // Stores user menu choice
        int idCounter = 1; // Automatically increments student ID

        // Menu-driven loop (runs until user selects Exit option)
        do {
            // Display menu
            System.out.println("\n*********************************");
            System.out.println("      STUDENT GRADE SYSTEM");
            System.out.println("*********************************");
            System.out.println("1. Add New Student");
            System.out.println("2. View Students");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");
            System.out.print("Select Option: ");
            choice = sc.nextInt();  // Read user choice
            // Switch statement to handle different menu options
            switch (choice) {
                case 1:
                    // Add new student
                    sc.nextLine(); // Clear input buffer

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks (0-100): ");
                    int marks = sc.nextInt();

                    // Validate marks range
                    if (marks < 0 || marks > 100) {
                        System.out.println("Invalid Marks! Enter between 0 and 100.");
                        break;  // Exit case if invalid
                    }

                    // Create new Student object and add to ArrayList
                    students.add(new Student(idCounter++, name, marks));

                    System.out.println("Student Record Added Successfully!");
                    break;

                case 2:
                    // Call method to display all students
                    displayStudents(students);
                    break;

                case 3:
                    // Call method to generate summary report
                    generateReport(students);
                    break;

                case 4:
                    // Exit message
                    System.out.println("Program Closed Successfully!");
                    break;

                default:
                    // Handle invalid menu choice
                    System.out.println("Invalid Option! Please Try Again.");
            }
        } while (choice != 4); // Loop continues until user selects 4

        sc.close(); // Close Scanner to prevent resource leak
    }
    // Method to display all student records
    public static void displayStudents(ArrayList<Student> students) {
        // Check if list is empty
        if (students.isEmpty()) {
            System.out.println("No Records Available!");
            return;
        }
        System.out.println("\n----- Student Records -----");
        // Enhanced for-loop to iterate through ArrayList
        for (Student s : students) {

            System.out.println("ID: " + s.id +
                    " | Name: " + s.name +
                    " | Marks: " + s.marks +
                    " | Grade: " + s.getGrade());
        }
    }
    // Method to generate summary report
    public static void generateReport(ArrayList<Student> students) {
        // Check if list is empty
        if (students.isEmpty()) {
            System.out.println("No Data Available!");
            return;
        }
        int total = 0;  // To calculate total marks
        // Assume first student as highest and lowest initially
        Student highest = students.get(0);
        Student lowest = students.get(0);
        // Loop to calculate total, highest and lowest
        for (Student s : students) {
            total += s.marks;  // Add marks to total

            // Check for highest marks
            if (s.marks > highest.marks) {
                highest = s;
            }
            // Check for lowest marks
            if (s.marks < lowest.marks) {
                lowest = s;
            }
        }
        // Calculate average
        double average = (double) total / students.size();
        // Display summary report
        System.out.println("\n========== SUMMARY REPORT ==========");
        System.out.println("Total Students : " + students.size());
        System.out.println("Average Marks  : " + average);
        System.out.println("Highest Scorer : " + highest.name + " (" + highest.marks + ")");
        System.out.println("Lowest Scorer  : " + lowest.name + " (" + lowest.marks + ")");
        System.out.println("====================================");
    }
}
