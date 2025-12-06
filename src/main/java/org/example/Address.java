package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public enum Province {
        AB, QC, ON, BC, MB, NB, NL, NS, PE
    }

    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }

        for (int i = 0; i < 6; i++) {
            char c = postalCode.charAt(i);
            if (i % 2 == 0) {
                if (!Character.isLetter(c)) {
                    return false;
                }
            }
            else {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
