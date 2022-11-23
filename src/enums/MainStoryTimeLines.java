package enums;

import interfaces.Describable;

public enum MainStoryTimeLines implements Describable {
    SIX_PM("Шесть часов вечера:"),
    HALF_SEVEN_PM("Пол седьмого вечера:"),
    SEVEN_PM("Семь вечера:"),
    HALF_EIGHT_PM("Пол восьмого вечера:"),
    EIGHT_PM("Восемь вечера:"),
    NINE_PM("Девять вечера:"),
    TEN_PM("Десять вечера:"),
    ELEVEN_PM("Одиннадцать вечера:"),
    TWELVE_PM("Двенадцать ночи:"),
    ONE_AM("Час ночи:"),
    TWO_AM("Два часа ночи:"),
    THREE_AM("Три часа ночи:"),
    FOUR_AM("Четыре часа утра:"),
    FIVE_AM("Пять часов утра:"),
    SIX_AM("Шесть часов утра:");


    private String description;
    MainStoryTimeLines(String description) {
        this.description = description;
    }
    @Override
    public String describe() {
        return this.description;
    }
}
