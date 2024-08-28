/* @description:
 *@author: Huy, Le NNguyen Quoc
 *@version: 1.0
 *@created: 28/08/2024
 */
package iuh.fit.ktpm;

public class Course {
    private int credit;
    private String department;
    private String id;
    private String title;

    public Course() {
    }
    public Course(String id, String title, int credit, String department) {
        this.credit = credit;
        this.department = department;
        this.id = id;
        this.title = title;
    }

    public int getCredit() {
        return credit;
    }
    public String getDepartment() {
        return department;
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setCredit(int credit) {
        if (credit <0) {
            throw new IllegalArgumentException("credit must be greater than 0");
        }
        this.credit = credit;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setId(String id) {
        if (id==null||id.length()<3) {
            throw new IllegalArgumentException("id must have at least 3 characters");
        }
        for (int i =0; i<id.length(); i++) {
            if (!Character.isLetterOrDigit(id.charAt(i))) {
                throw new IllegalArgumentException("id must contain only letters and numbers");
            }
        }
        this.id = id;
    }

    public void setTitle(String title) {
        if (title==null||title.isEmpty()) {
            throw new IllegalArgumentException("title must not be empty");
        }
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-30s%2d %-10s",id,title,credit,department);
    }
}