package org.example;

import Util.Util;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public enum Gender {
        MALE, FEMALE
    }

    /**
     * make a student with name, gender, address and department given
     * @param studentName the name of the student
     * @param gender the gender of the student
     * @param address the address of the student
     * @param department the department of the student
     */
    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     *  converts a student to a simple string with only the studentId, the studentName and the departmentName
     * @return the simplified string student
     */
    public String toSimplifiedString() {
        return studentId + " " + studentName + " (" + department.getDepartmentName() + ")";
    }

    /**
     * sets the student name and then converts it to title case
     * @param studentName the student name to set
     */
    public void setStudentName(String studentName) {
        this.studentName = Util.toTitleCase(studentName);
    }
}
