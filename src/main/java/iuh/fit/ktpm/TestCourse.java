/* @description:
 *@author: Huy, Le NNguyen Quoc
 *@version: 1.0
 *@created: 28/08/2024
 */
package iuh.fit.ktpm;

import java.util.Scanner;

public class TestCourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        initData(courseList);

        int choice;
        do{
            System.out.println("1. Add a course");
            System.out.println("2. Display all courses");
            System.out.println("3. Remove a course");
            System.out.println("4. Search a course by id");
            System.out.println("5. Search a course by department");
            System.out.println("6. Find max credit Courses");
            System.out.println("7. Sort Courses by credit");
            System.out.println("8. Find Department With Most Courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 0: return;
                case 1 : {
                    System.out.print("Enter course id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter course credit: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course department: ");
                    String department = sc.nextLine();
                    Course course = new Course(id, title, credit, department);
                    if (courseList.AddCourse(course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Course not added!");
                    }
                    break;
                }
                case 2 : {
                    System.out.println("Course List");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(String.format("%-10s%-30s%2s %-10s", "ID", "Title", "Credit", "Department"));
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : courseList.getCourses()) {
                        if (c != null)
                            System.out.println(c);
                    }
                    System.out.println("-------------------------------------------------------------");
                    break;
                }
                case 3 : {
                    System.out.println("ID :");
                    String id = sc.nextLine();
                    courseList.RemoveCourse(id);
                    break;
                }
                case 4: {
                    System.out.println("ID :");
                    String id = sc.nextLine();
                    System.out.println(courseList.SearchCourseByID(id));
                    break;
                }
                case 5: {
                    System.out.println("Department :");
                    String department = sc.nextLine();
                    System.out.println( courseList.SearchCourseByDepartment(department));
                    break;
                }
                case 6: {
                    System.out.println(courseList.findMaxCreditCourse());
                    break;
                }
                case 7: {
                    courseList.SortCourse();
                    for (Course c : courseList.getCourses()) {
                        if (c != null)
                            System.out.println(c);
                    }
                    break;
                }
                case 8: {
                    System.out.println(courseList.findDepartmentWithMostCourses());
                    break;
                }
                default :
                    System.out.println("Invalid choice!");
            }
        }while (choice !=0);
    }
    private static void initData(CourseList courseList) {
        Course course1 = new Course("FIT101", "Java Programming", 3, "FIT");
        Course course2 = new Course("FIT102", "Web Programming", 3, "FIT");
        Course course3 = new Course("FIT103", "Database Programming", 3, "FIT");
        Course course4 = new Course("FIT104", "Mobile Programming", 3, "FIT");
        Course course5 = new Course("FIT105", "Software Engineering", 2, "FIT");
        Course course6 = new Course("FIT106", "Data Science", 3, "FIT");
        Course course7 = new Course("FIT107", "Machine Learning", 3, "FIT");
        Course course8 = new Course("FIT108", "Artificial Intelligence", 3, "FIT");

        courseList.AddCourse(course1);
        courseList.AddCourse(course2);
        courseList.AddCourse(course3);
        courseList.AddCourse(course4);
        courseList.AddCourse(course5);
        courseList.AddCourse(course6);
        courseList.AddCourse(course7);
        courseList.AddCourse(course8);
    }
}