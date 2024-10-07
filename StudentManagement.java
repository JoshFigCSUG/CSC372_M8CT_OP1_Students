import java.util.LinkedList;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            LinkedList<Student> studentList = new LinkedList<>();

            while (true) {
                System.out.println("Enter student data (or type 'done' to finish):");

                // --- Name Input ---
                System.out.print("Name: ");
                String name = input.nextLine();
                if (name.equalsIgnoreCase("done")) {
                    break; 
                }
                while (name.trim().isEmpty()) {
                    System.out.println("Name cannot be empty. Please enter a name.");
                    System.out.print("Name: ");
                    name = input.nextLine();
                }
            }
        }
    }
}
