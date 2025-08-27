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