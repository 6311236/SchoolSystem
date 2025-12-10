package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private String departmentId;
    @Setter private String departmentName;
    private static int nextId = 1;

    /**
     * checks if a department name is valid or not
     * @param departmentName the department name to check
     * @return true if the department name has only letters or spaces and if not false
     */
    public static boolean isDepartmentValid(String departmentName) {
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

    public Department(String departmentName) {
        if (isDepartmentValid(departmentName)) {
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName =
        }
    }
}
