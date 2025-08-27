// 1. Custom Exception
class StudentNotFoundException extends Exception {
 public StudentNotFoundException(String message) {
 super(message);
 }
}
// 2. Student class
class Student {
 int id;
 String name;
 int age;
 Student(int id, String name, int age) {
 this.id = id;
 this.name = name;
 this.age = age;
 }
 public String toString() {
 return "ID: " + id + ", Name: " + name + ", Age: " + age;
 }
}
// 3. Interface
interface StudentOperations {
 void addStudent(Student s);
 void viewStudents();
 void searchStudent(int id) throws StudentNotFoundException;
 void deleteStudent(int id) throws StudentNotFoundException;
}
// 4. Implementation using Array
class StudentManager implements StudentOperations {
 Student[] students;
 int count;
 StudentManager(int size) {
 students = new Student[size];
 count = 0;
 }
 public void addStudent(Student s) {
 if (count < students.length) {
 students[count++] = s;
 System.out.println("■ Student added successfully!");
 } else {
 System.out.println("■■ Error: Student array is full.");
 }
 }
 public void viewStudents() {
 if (count == 0) {
 System.out.println("■■ No students available.");
 return;
 }
 System.out.println("\n---- Student List ----");
 for (int i = 0; i < count; i++) {
 System.out.println(students[i]);
 }
 }
 public void searchStudent(int id) throws StudentNotFoundException {
 for (int i = 0; i < count; i++) {
 if (students[i].id == id) {
 System.out.println("■ Student Found: " + students[i]);
 return;
 }
 }
 throw new StudentNotFoundException("Student with ID " + id + " not found!");
 }
 public void deleteStudent(int id) throws StudentNotFoundException {
 for (int i = 0; i < count; i++) {
 if (students[i].id == id) {
 System.out.println("■ Deleted: " + students[i]);
 for (int j = i; j < count - 1; j++) {
 students[j] = students[j + 1];
 }
 students[count - 1] = null;
 count--;
 return;
 }
 }
 throw new StudentNotFoundException("Cannot delete. Student with ID " + id + " not found!");
 }
}
// 5. Main class with menu
public class StudentManagementSystem {
 public static void main(String[] args) {
 java.util.Scanner sc = new java.util.Scanner(System.in);
 StudentManager manager = new StudentManager(10); // max 10 students
 int choice;
 do {
 System.out.println("\n===== Student Management Menu =====");
 System.out.println("1. Add Student");
 System.out.println("2. View All Students");
 System.out.println("3. Search Student by ID");
 System.out.println("4. Delete Student by ID");
 System.out.println("5. Exit");
 System.out.print("Enter your choice: ");
 choice = sc.nextInt();
 switch (choice) {
 case 1:
 System.out.print("Enter ID: ");
 int id = sc.nextInt();
 sc.nextLine();
 System.out.print("Enter Name: ");
 String name = sc.nextLine();
 System.out.print("Enter Age: ");
 int age = sc.nextInt();
 manager.addStudent(new Student(id, name, age));
 break;
 case 2:
 manager.viewStudents();
 break;
 case 3:
 System.out.print("Enter Student ID to search: ");
 int searchId = sc.nextInt();
 try {
 manager.searchStudent(searchId);
 } catch (StudentNotFoundException e) {
 System.out.println("■■ Error: " + e.getMessage());
 }
 break;
 case 4:
 System.out.print("Enter Student ID to delete: ");
 int deleteId = sc.nextInt();
 try {
 manager.deleteStudent(deleteId);
 } catch (StudentNotFoundException e) {
 System.out.println("■■ Error: " + e.getMessage());
 }
 break;
 case 5:
 System.out.println("■ Exiting Student Management System...");
 break;
 default:
 System.out.println("■■ Invalid choice! Try again.");
 }
 } while (choice != 5);
 sc.close();
 }
}

