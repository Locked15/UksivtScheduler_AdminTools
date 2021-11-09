package com.uksivt;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Класс, предоставляющий логику для расписания одного конкретного дня.
 */
public class DaySchedule
{
    /**
     * Поле, содержащее день, который описывается.
     */
    public final Days day;

    /**
     * Поле, содержащее пары, проводимые в этот день.
     */
    public final ArrayList<Lesson> lessons;

    /**
     * Конструктор класса.
     *
     * @param day День недели.
     * @param lessons Пары этого дня.
     */
    public DaySchedule(Days day, ArrayList<Lesson> lessons)
    {
        this.day = day;
        this.lessons = lessons;
    }
}

/**
 * Перечисление, нужное для отображения дня.
 */
enum Days
{
    //region Элементы перечисления.
    /**
     * Понедельник.
     */
    Monday,

    /**
     * Вторник.
     */
    Tuesday,

    /**
     * Среда.
     */
    Wednesday,

    /**
     * Четверг.
     */
    Thursday,

    /**
     * Пятница.
     */
    Friday,

    /**
     * Суббота.
     */
    Saturday,

    /**
     * Воскресенье.
     */
    Sunday;
    //endregion

    /**
     * Метод для получения дня по указанному индексу.
     *
     * @param i Индекс по которому нужно получить значение.
     *
     * @return Значение, соответствующее данному индексу.
     *
     * @throws IndexOutOfBoundsException Введенный индекс превышает количество значений.
     */
    public static Days getValueByIndex(Integer i) throws IndexOutOfBoundsException
    {
        return switch (i)
        {
            case 0 -> Monday;

            case 1 -> Tuesday;

            case 2 -> Wednesday;

            case 3 -> Thursday;

            case 4 -> Friday;

            case 5 -> Saturday;

            case 6 -> Sunday;

            default -> throw new IndexOutOfBoundsException("Введен слишком большой индекс.");
        };
    }

    /**
     * Метод для преобразования Enum-значения в строковый вид.
     *
     * @param day Элемент перечисления Enum.
     *
     * @return Строковое представление перечисления.
     */
    public static String toString(Days day)
    {
        String newDay = "";

        switch (day)
        {
            case Monday -> newDay = "Monday";

            case Tuesday -> newDay = "Tuesday";

            case Wednesday -> newDay = "Wednesday";

            case Thursday -> newDay = "Thursday";

            case Friday -> newDay = "Friday";

            case Saturday -> newDay = "Saturday";

            case Sunday -> newDay = "Sunday";
        }

        return translateToRussianLanguage(newDay);
    }

    /**
     * Метод для преобразования Enum-значения в строковый вид.
     *
     * @param day Элемент перечисления Enum.
     *
     * @return Строковое представление перечисления.
     */
    public static Days fromString(String day)
    {
        day = translateToOriginalLanguage(day);

        return switch (day)
        {
            case "Monday" -> Monday;

            case "Tuesday" -> Tuesday;

            case "Wednesday" -> Wednesday;

            case "Thursday" -> Thursday;

            case "Friday" -> Friday;

            case "Saturday" -> Saturday;

            case "Sunday" -> Sunday;

            default -> null;
        };
    }

    /**
     * Метод для перевода русскоязычных названий дней в оригинальный (английский) язык.
     *
     * @param day День недели на русском.
     *
     * @return День недели на английском.
     */
    public static String translateToOriginalLanguage(String day)
    {
        day = day.toLowerCase(Locale.ROOT);

        return switch (day)
        {
            case "понедельник" -> "Monday";

            case "вторник" -> "Tuesday";

            case "среда" -> "Wednesday";

            case "четверг" -> "Thursday";

            case "пятница" -> "Friday";

            case "суббота" -> "Saturday";

            case "воскресенье" -> "Sunday";

            default -> day;
        };
    }

    /**
     * Метод для перевода англоязычных названий дней в русский язык.
     *
     * @param day День недели на английском.
     *
     * @return День недели на русском.
     */
    public static String translateToRussianLanguage(String day)
    {
        return switch (day)
        {
            case "Monday" -> "Понедельник";

            case "Tuesday" -> "Вторник";

            case "Wednesday" -> "Среда";

            case "Thursday" -> "Четверг";

            case "Friday" -> "Пятница";

            case "Saturday" -> "Суббота";

            case "Sunday" -> "Воскресенье";

            default -> day;
        };
    }
}
