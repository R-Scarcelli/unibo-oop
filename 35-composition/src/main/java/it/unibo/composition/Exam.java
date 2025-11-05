package it.unibo.composition;

import java.util.Arrays;

public class Exam {
    private final int id;
    private final int maxStudents;
    private final String courseName;
    private int registeredStudents;
    private ExamRoom room;
    private Professor professor;
    private Student[] students;

    public Exam(final int id, final int maxStudents, final String courseName, final ExamRoom room, final Professor prof) {
        this.id = id;
        this.maxStudents = maxStudents;
        this.registeredStudents = 0;
        this.courseName = courseName;
        this.room = room;
        this.professor = prof;
        this.students = new Student[maxStudents];
    }

    public int getMaxStudents() {
        return this.maxStudents;
    }

    public int getRegisteredStudents() {
        return this.registeredStudents;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getRoom() {
        return this.room.getDescription();
    }

    public String getProfessor() {
        return this.professor.getDescription();
    }

    public void registerStudent(Student student) {
        if ((this.registeredStudents + 1) <= this.maxStudents) {
            students [registeredStudents] = student;
            this.registeredStudents ++;
        }
    }

    public String toString() {
        return "Exam ["
            + "id = " + this.id
            + ", maxStudents = " + this.maxStudents
            + "\n, registeredStudents = " + this.registeredStudents
            + "\n, courseName = " + this.courseName
            + "\n, professor = " + this.professor
            + "\n, room = " + this.room
            + "\n, Students = " +  Arrays . toString(this.students)
            + "]\n";
    }
}
