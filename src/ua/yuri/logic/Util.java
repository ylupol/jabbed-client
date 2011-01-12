package ua.yuri.logic;

/**
 * User: yuri
 * Date: May 16, 2010
 */
public class Util {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();       
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String null2Blank(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }
}
