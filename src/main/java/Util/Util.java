package Util;

public class Util {

    /**
     * convert words in a string into title case
     * @param str the string to convert
     * @return the string with each word now in title case
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                String firstChar = words[i].substring(0, 1).toUpperCase();
                String otherChar = words[i].substring(1).toLowerCase();
                result.append(firstChar).append(otherChar);
            }

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
