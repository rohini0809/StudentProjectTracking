import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Project> projects = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT PROJECT TRACKING & EVALUATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Project");
            System.out.println("3. Update Project Progress");
            System.out.println("4. Evaluate Project");
            System.out.println("5. View Projects");
            System.out.println("6. Search Projects");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    addProject();
                    break;

                case 3:
                    updateProgress();
                    break;

                case 4:
                    evaluateProject();
                    break;

                case 5:
                    viewProjects();
                    break;

                case 6:
                    searchProject();
                    break;
                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        students.add(new Student(id, name, department));

        System.out.println("Student added successfully!");
    }

    static void addProject() {
        System.out.print("Enter Project ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Project Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student ID: ");
        int studentId = sc.nextInt();

        projects.add(new Project(id, name, studentId));

        System.out.println("Project added successfully!");
    }

    static void updateProgress() {
        System.out.print("Enter Project ID: ");
        int id = sc.nextInt();

        Project project = findProject(id);

        if (project != null) {
            System.out.print("Enter Progress (0-100): ");
            int progress = sc.nextInt();

            if (progress >= 0 && progress <= 100) {
                project.setProgress(progress);

                if (progress == 100) {
                    project.setStatus("Completed");
                } else if (progress > 0) {
                    project.setStatus("In Progress");
                } else {
                    project.setStatus("Not Started");
                }

                System.out.println("Progress updated successfully!");
            } else {
                System.out.println("Progress must be between 0 and 100.");
            }
        } else {
            System.out.println("Project not found!");
        }
    }

    static void evaluateProject() {
        System.out.print("Enter Project ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Project project = findProject(id);

        if (project != null) {
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Feedback: ");
            String feedback = sc.nextLine();

            project.setMarks(marks);
            project.setFeedback(feedback);

            System.out.println("Project evaluated successfully!");
        } else {
            System.out.println("Project not found!");
        }
    }

    static void viewProjects() {
        if (projects.isEmpty()) {
            System.out.println("No projects available.");
            return;
        }

        System.out.println("\n===== PROJECT DETAILS =====");

        for (Project p : projects) {
            System.out.println("----------------------------");
            System.out.println("Project ID   : " + p.getProjectId());
            System.out.println("Project Name : " + p.getProjectName());
            System.out.println("Student ID   : " + p.getStudentId());
            System.out.println("Progress     : " + p.getProgress() + "%");
            System.out.println("Status       : " + p.getStatus());
            System.out.println("Marks        : " + p.getMarks());
            System.out.println("Feedback     : " + p.getFeedback());
        }
    }

    static void searchProject() {

    System.out.print("Enter Project ID: ");
    int id = sc.nextInt();

    Project project = findProject(id);

    if (project != null) {
        System.out.println("\n===== PROJECT DETAILS =====");
        System.out.println("Project ID   : " + project.getProjectId());
        System.out.println("Project Name : " + project.getProjectName());
        System.out.println("Student ID   : " + project.getStudentId());
        System.out.println("Progress     : " + project.getProgress() + "%");
        System.out.println("Status       : " + project.getStatus());
        System.out.println("Marks        : " + project.getMarks());
        System.out.println("Feedback     : " + project.getFeedback());
    } else {
        System.out.println("Project not found!");
    }
}

    static Project findProject(int id) {
        for (Project p : projects) {
            if (p.getProjectId() == id) {
                return p;
            }
        }
        return null;
    }
}
