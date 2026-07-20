import java.util.Scanner;

/**
 * StudentGradeCalculator
 * ------------------------------------------------------------
 * DecodeLabs Industrial Training Kit - Java Programming
 * Project 2: Student Grade Calculator
 * ------------------------------------------------------------
 */
public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   DECODELABS - STUDENT GRADE CALCULATOR");
        System.out.println("========================================");

        // Student name (used only for a friendlier report header)
        System.out.print("Enter student name: ");
        String studentName = sc.nextLine().trim();
        if (studentName.isEmpty()) {
            studentName = "Student";
        }

        // ---- Phase I: Input - how many subjects? ----
        int numberOfSubjects = readValidatedInt(
                sc, "Enter number of subjects: ", 1, 50);

        // ---- Phase II: Process (Gear 1 - Accumulator Loop) ----
        int totalMarks = 0;
        String[] subjectNames = new String[numberOfSubjects];
        int[] subjectMarks = new int[numberOfSubjects];

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.println("\n--- Subject " + (i + 1) + " ---");
            System.out.print("Subject name: ");
            String subjectName = sc.nextLine().trim();
            if (subjectName.isEmpty()) {
                subjectName = "Subject " + (i + 1);
            }

            int marks = readValidatedInt(
                    sc, "Marks obtained (out of 100): ", 0, 100);

            subjectNames[i] = subjectName;
            subjectMarks[i] = marks;
            totalMarks += marks;
        }

        // ---- Phase II: Process (Gear 2 - Math & Type Casting) ----
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // ---- Phase II: Process (Gear 3 - The Logic Ladder) ----
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        String remark = getRemark(grade);

        // ---- Phase III: Output - The Presentation Layer ----
        System.out.println("\n========================================");
        System.out.println("           GRADE REPORT CARD");
        System.out.println("========================================");
        System.out.printf("Student Name     : %s%n", studentName);
        System.out.println("----------------------------------------");
        System.out.printf("%-20s %10s%n", "Subject", "Marks");
        System.out.println("----------------------------------------");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.printf("%-20s %6d/100%n", subjectNames[i], subjectMarks[i]);
        }
        System.out.println("----------------------------------------");
        System.out.printf("Total Marks      : %d / %d%n", totalMarks, numberOfSubjects * 100);
        System.out.printf("Average           : %.2f%%%n", averagePercentage);
        System.out.printf("Final Grade      : %c (%s)%n", grade, remark);
        System.out.println("========================================");

        sc.close();
    }

    private static int readValidatedInt(Scanner sc, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.printf("  -> Please enter a value between %d and %d.%n", min, max);
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("  -> Invalid input. Please enter a whole number.");
            }
        }
    }

    private static String getRemark(char grade) {
        switch (grade) {
            case 'A': return "Excellent";
            case 'B': return "Very Good";
            case 'C': return "Good";
            case 'D': return "Needs Improvement";
            default:  return "Fail";
        }
    }
}