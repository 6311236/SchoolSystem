package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    /**
     * checks if a department name is valid or not
     * @param departmentName the department name to check
     * @return true if the department name has only letters or spaces and if not false
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }

        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }

        return true;
    }

    /**
     * creates a department with the name given
     * @param departmentName the department name
     */
    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = Util.toTitleCase(departmentName);
        }
        else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * Sets the department name after validating it
     * @param departmentName the department name to set
     */
    public void setDepartmentName(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = Util.toTitleCase(departmentName);
        }
        else {
            this.departmentName = null;
        }
    }
}
