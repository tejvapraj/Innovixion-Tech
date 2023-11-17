import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private Map<String, Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(String subject, double grade) {
        grades.put(subject, grade);
    }

    public void removeGrade(String subject) {
        grades.remove(subject);
    }

    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double totalGrade = 0.0;
        for (double grade : grades.values()) {
            totalGrade += grade;
        }

        return totalGrade / grades.size();
    }

    public void printReport() {
        System.out.println("Student: " + name);
        System.out.println("Grades:");
        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("GPA: " + calculateGPA());
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String name) {
        students.removeIf(student -> student.getName().equals(name));
    }

    public Student findStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Record Grades");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.next();
                    sms.addStudent(new Student(studentName));
                    break;

                case 2:
                    System.out.print("Enter student name to remove: ");
                    String nameToRemove = scanner.next();
                    sms.removeStudent(nameToRemove);
                    break;

                case 3:
                    System.out.print("Enter student Name to Add Grades: ");
                    String studentNameForGrades = scanner.next();
                    Student student = sms.findStudent(studentNameForGrades);

                    if (student != null) {
                        System.out.print("Enter subject: ");
                        String subject = scanner.next();
                        System.out.print("Enter grade: ");
                        double grade = scanner.nextDouble();
                        student.addGrade(subject, grade);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student name for report: ");
                    String studentNameForReport = scanner.next();
                    Student studentReport = sms.findStudent(studentNameForReport);

                    if (studentReport != null) {
                        studentReport.printReport();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }
}
