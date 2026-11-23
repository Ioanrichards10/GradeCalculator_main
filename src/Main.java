
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        GradeCalculator calculator = new GradeCalculator();

        System.out.println("==============================");
        System.out.println("   STUDENT GRADE MANAGER");
        System.out.println("==============================");

        boolean addingStudents = true;

        while (addingStudents) {

            System.out.print("\nEnter student name: ");
            String name = scanner.nextLine().trim();

            while (name.isEmpty()) {
                System.out.print("Name cannot be empty. Try again: ");
                name = scanner.nextLine().trim();
            }

            int mark1 = getValidMark(scanner, "Module 1");
            int mark2 = getValidMark(scanner, "Module 2");
            int mark3 = getValidMark(scanner, "Module 3");

            Student student = new Student(name, mark1, mark2, mark3);

            students.add(student);

            System.out.println("\nStudent added successfully!");

            System.out.print("Add another student? (yes/no): ");
            String answer = scanner.nextLine().trim();

            addingStudents = answer.equalsIgnoreCase("yes")
                    || answer.equalsIgnoreCase("y");
        }

        System.out.println("\n========== CLASS REPORT ==========");

        double totalAverage = 0;

        for (Student student : students) {

            double average = calculator.calculateAverage(
                    student.getMark1(),
                    student.getMark2(),
                    student.getMark3()
            );

            String grade = calculator.getGrade(average);

            System.out.println("\nStudent: " + student.getName());
            System.out.println("Module 1: " + student.getMark1());
            System.out.println("Module 2: " + student.getMark2());
            System.out.println("Module 3: " + student.getMark3());
            System.out.printf("Average: %.2f%n", average);
            System.out.println("Classification: " + grade);

            totalAverage += average;
        }

        double classAverage = totalAverage / students.size();

        System.out.println("\n==================================");
        System.out.println("Total students: " + students.size());
        System.out.printf("Class average: %.2f%n", classAverage);
        System.out.println("==================================");

        scanner.close();
    }

    public static int getValidMark(Scanner scanner, String module) {

        int mark;

        while (true) {

            System.out.print("Enter " + module + " mark (0-100): ");

            try {
                mark = Integer.parseInt(scanner.nextLine());

                if (mark >= 0 && mark <= 100) {
                    return mark;
                }

                System.out.println("Please enter a mark between 0 and 100.");

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
