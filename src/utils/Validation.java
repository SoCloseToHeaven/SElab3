package utils;

import java.util.regex.Pattern;

public final class Validation {
    public static final String UNDEFINED_RESULT = "Undefined";

    private Validation() {}
    public static String validateName(String name) {
        if (isValidName(name) && CachedNames.isNotCached(name)) {
            CachedNames.cacheName(name);
            return name;
        } else if (isValidName(name)){
            System.out.println("Такое имя уже было использовано, установлено неопределённое имя");
            return UNDEFINED_RESULT;
        } else {
            System.out.println("Некорректный формат имени, установлено неопределённое имя");
            return UNDEFINED_RESULT;
        }
    }

    private static boolean isValidName(String nameOrProfession) {
        return Pattern.matches("^[А-Я][а-я]*$", nameOrProfession);
    }

    @Override
    public boolean equals(Object obj) { // не имеет смысла, тк создать объект класса невозможно
        if (obj == null)
            return false;
        if (this.getClass() == obj.getClass())
            return true;
        return false;
    }

    @Override
    public int hashCode() { // у объекта класса нет полей
        return 31;
    }

    @Override
    public String toString() { // тоже смысла не имеет
        return "";
    }
}
