/* @description:
 *@author: Huy, Le NNguyen Quoc
 *@version: 1.0
 *@created: 28/08/2024
 */
package iuh.fit.ktpm;

public class CourseList {
    private Course[] courses;
    private int count = 0;

    public CourseList(int n) {
        if (n<=0) {
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        }
        courses = new Course[n];
    }

    public Course[] getCourses() {
        return courses;
    }

    public boolean AddCourse(Course c) {
        if (c==null) return false;
        if (exist(c)) return false;
        if (count == courses.length) {
            return false;
        }
        courses[count++] = c;
        return true;
    }
    private boolean exist(Course c) {
        for (int i = 0; i < count; i++) {
            if (courses[i]!=null && courses[i].getId().equalsIgnoreCase(c.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean RemoveCourse(String id){
        if(courses == null) return false;
        for(int i = 0; i < count; i++) {
            if(courses[i].getId().equals(id)) {
                courses[i] = courses[count - 1];
                count--;
                return true;
            }
        }
        return false;
    }
    public Course SearchCourseByID(String id){
        if(courses == null) return null;
        for(int i = 0; i < count; i++) {
            if(courses[i].getId().equals(id)) {
                return courses[i];
            }
        }
        return null;
    }
    public Course SearchCourseByDepartment(String department){
        if(courses == null) return null;
        for(int i = 0; i < count; i++) {
            if(courses[i].getDepartment().equals(department)) {
                return courses[i];
            }
        }
        return null;
    }
    public Course findMaxCreditCourse(){
        if(courses == null) return null;
        Course maxCreditCourse = courses[0];
        for(int i = 1; i < count; i++) {
            if(courses[i].getCredit() > maxCreditCourse.getCredit()) {
                maxCreditCourse = courses[i];
            }
        }
        return maxCreditCourse;
    }
    public Course SortCourse(){
        if(courses == null) return null;
        for(int i = 0; i < count - 1; i++) {
            for(int j = count-1; j > i ; j--) {
                if(courses[i].getCredit() > courses[j].getCredit()) {
                    Course temp = courses[i];
                    courses[i] = courses[j];
                    courses[j] = temp;
                }
            }
        }
        return courses[0];
    }
    public String findDepartmentWithMostCourses(){
        int temp = 0;
        String tempString = null;
        for (int i = 0; i < count; i++) {
            if (findDepartment(courses[i].getDepartment()) > temp) {
                temp = findDepartment(courses[i].getDepartment());
                tempString = courses[i].getDepartment();
            }
        }
        return tempString;
    }
    private int findDepartment(String department){
        int n = 0;
        for (int i =0; i<count; i++) {
            if (courses[i].getDepartment().equals(department)) {
                n++;
            }
        }
        return n;
    }
}
