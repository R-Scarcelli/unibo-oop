package it.unibo.composition;

import java.util.Arrays;

public class Professor implements User {
    private final int id;
    private final String name;
    private final String surname;
    private String password;
    private String[] courses;

    public Professor(final int id, final String name, final String surname, final String password, final String courses []) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.courses = courses;
    }

    public String getUsername() {
        return this.name + "." + this.surname;
    }

    public String getPassword() {
        return this.password;
    }

    public String toString() {
        return "Professor ["
            + "name=" + this.name
            + ", surname=" + this.surname
            + ", id=" + this.id
            + ", userName= " + getUsername()
            + ", courses=" + Arrays.toString(this.courses)
            + "]";
    }

    public String getDescription() {
        return this.toString();
    }

    public void replaceCourse(String course, int index) {
        if (index <= courses.length) {
            courses[index] = course;
        }
    }

    public void replaceAllCourses(String courses[]) {
        this.courses = courses;
    }
}
