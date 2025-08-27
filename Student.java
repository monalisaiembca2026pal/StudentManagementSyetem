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