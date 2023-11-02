package com.flow.blockfileextension.util;

public class NameValidation {
    public static boolean isValidNameLength(String extensionName) {
        if (extensionName.length() > 20) {
            return false;
        }
        return true;
    }

    public static boolean isLowerCase(String extensionName) {
        return extensionName.matches("^[a-z]+$");
    }
}
