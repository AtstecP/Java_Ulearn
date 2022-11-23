import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public abstract class AbstractLogger {
    //TODO реализуйте абстрактный класс AbstractLogger с абстрактными методами info, debug, error, warning, toString и необходимыми полями
    String name = "FAKENAME";
    Calendar calendar;

    public AbstractLogger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCalendar(TimeZone timeZone, int year, int month, int day, int hours, int minutes, int seconds) {
        //TODO метод для установки даты для календаря
        TimeZone.setDefault(timeZone);
        calendar = new GregorianCalendar(year, month - 1, day, hours, minutes, seconds);
    }

    public String info(String value) {
        return String.format("[INFO] <%s> %s - Hello", calendar.getTime(), name);
    }

    public String debug(String value) {
        return String.format("[DEBUG] <%s> %s - Hello", calendar.getTime(), name);
    }

    public String warning(String value) {
        return String.format("[WARNING] <%s> %s - Hello", calendar.getTime(), name);
    }

    public String error(String value) {
        return String.format("[ERROR] <%s> %s - Hello", calendar.getTime(), name);
    }

}

class DefaultLogger extends AbstractLogger {
    public DefaultLogger(String name) {
        super(name);
    }

    //TODO реализуйте класс-наследник DefaultLogger, реализуйте все методы
    //Вызов логгирования должен выводить сообщение в таком формате: [LEVEL] <CALENDAR.DATE> NAME - MESSAGE
    //ToString() в формате: NAME — DefaultLogger
    @Override
    public String toString() {
        return String.format("%s — DefaultLogger", name);
    }
}

class InputControlLogger extends AbstractLogger {
    //TODO реализуйте класс-наследник InputControlLogger, реализуйте все методы
    //Примеры вывода различных методов класса:
    //[INFO] <Sat Feb 01 12:15:00 MSK 2020> Вход пользователя: message
    //[DEBUG] <Sat Feb 01 12:15:00 MSK 2020> Обнаружен пользователь: message
    //[ERROR] <Sat Feb 01 12:15:00 MSK 2020> Не удалось найти данные пользователя: message
    //[WARNING] <Sat Feb 01 12:15:00 MSK 2020> Обнаружен неавторизованный доступ в систему: message
    //ToString() в формате: NAME — InputControlLogger
    public InputControlLogger(String name) {
        super(name);
    }

    @Override
    public String info(String value) {
        return String.format("[INFO] <%s> Вход пользователя: message", calendar.getTime());
    }

    @Override
    public String debug(String value) {
        return String.format("[DEBUG] <%s> Обнаружен пользователь: message", calendar.getTime());
    }

    @Override
    public String warning(String value) {
        return String.format("[WARNING] <%s> Обнаружен неавторизованный доступ в систему: message", calendar.getTime());
    }

    @Override
    public String error(String value) {
        return String.format("[ERROR] <%s> Не удалось найти данные пользователя: message", calendar.getTime());
    }

    @Override
    public String toString() {
        return String.format("%s — InputControlLogger", name);
    }
}

class LogManager {
    //TODO реализуйте класс LogManager с методами:
    //1) addLogger — добавить логгер в хранилище менеджера
    //2) getLogger — получить логгер из хранилища менеджера по имени, если Логгер не найден, создать новый DefaultLogger
    //3) printLoggers —  распечатать все логгеры путем вызова их метода toString() и разделяя их переносом строки /n
    ArrayList<AbstractLogger> loggers = new ArrayList<>();

    public void addLogger(AbstractLogger logger) {
        loggers.add(logger);
    }

    public AbstractLogger getLogger(String name) {
        for (var logger : loggers) {
            if (logger.getName() == name) {
                return logger;
            }
        }
        return new DefaultLogger("logger");
    }

    public String printLoggers() {
        StringBuilder str = new StringBuilder();
        for (var logger : loggers) {
            str.append(logger.toString()).append("\n");
        }
        return str.toString();
    }
}