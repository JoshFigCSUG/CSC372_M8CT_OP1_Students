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

                // --- Address Input ---
                System.out.print("Address: ");
                String address = input.nextLine();
                if (address.equalsIgnoreCase("done")) {
                    break;
                }
                while (address.trim().isEmpty()) {
                    System.out.println("Address cannot be empty. Please enter an address.");
                    System.out.print("Address: ");
                    address = input.nextLine();
                }

                // --- GPA Input ---
                double gpa = 0;
                String gpaInput;
                while (true) {
                    System.out.print("GPA: ");
                    gpaInput = input.nextLine(); 
                    if (gpaInput.equalsIgnoreCase("done")) {
                        break; 
                    }
                    try {
                        gpa = Double.parseDouble(gpaInput);
                        if (gpa >= 0 && gpa <= 4.0) {
                            break; // Valid GPA
                        } else {
                            System.out.println("Invalid GPA. Please enter a value between 0 and 4.0.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a numeric value for GPA.");
                    }
                }
                if (gpaInput.equalsIgnoreCase("done")) { 
                    break; 
                }

                studentList.add(new Student(name, address, gpa));
            }
        }
    }
}
