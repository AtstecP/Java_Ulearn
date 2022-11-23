public interface TimeUnit {
    //TODO реализуйте интерфейс TimeUnit
    /*Создать интерфейс TimeUnit, который содержит методы toMillis, toSeconds, toMinutes, toHours, возвращающие тип long.*/

    long toMillis();

    long toSeconds();

    long toMinutes();

    long toHours();


}

class TimeUnitUtils {
    //TODO реализуйте методы toMillis(), toSeconds() и toHours()
    /*Создать статический класс TimeUnitUtils
    с методами toMillis, toSeconds, toHours, которые принимают любой класс, реализующий интерфейс TimeUnit,
    и возвращают значение в Миллисекундах, Секундах и Часах соответственно.*/
    public static Milliseconds toMillis(TimeUnit timeUnit) {
        return new Milliseconds(timeUnit.toMillis());
    }

    public static Seconds toSeconds(TimeUnit timeUnit) {
        return new Seconds(timeUnit.toSeconds());
    }

    public static Hours toHours(TimeUnit timeUnit) {
        return new Hours(timeUnit.toHours());
    }
}

class Seconds implements TimeUnit {
    //TODO реализуйте класс Seconds, который наследует интерфейс TimeUnit
    private long value;

    public Seconds(long value) {
        this.value = value;
    }

    @Override
    public long toSeconds() {
        return value;
    }

    @Override
    public long toMillis() {
        return value * 1000;
    }

    @Override
    public long toMinutes() {
        return  Math.round(value / 60.0);
    }

    @Override
    public long toHours() {
        return Math.round(value / 3600.0);
    }

}

class Minutes implements TimeUnit {
    //TODO реализуйте класс Minutes, который наследует интерфейс TimeUnit

    private long value;

    public Minutes(long value) {
        this.value = value;
    }

    @Override
    public long toMinutes() {
        return value;
    }

    @Override
    public long toMillis() {
        return value * 60_000;
    }

    @Override
    public long toSeconds() {
        return value * 60;
    }

    @Override
    public long toHours() {
        return  Math.round(value / 60.0);
    }
}

class Milliseconds implements TimeUnit {
    //TODO реализуйте класс Milliseconds, который наследует интерфейс TimeUnit
    private long value;


    public Milliseconds(long value) {
        this.value = value;
    }

    @Override
    public long toMillis() {
        return value;
    }

    @Override
    public long toSeconds() {
        return  Math.round(value / 1000.0);
    }

    @Override
    public long toMinutes() {
        return  Math.round(value / 60_000.0);
    }

    @Override
    public long toHours() {
        return  Math.round(value / 3_600_000.0);
    }
}

class Hours implements TimeUnit {
    //TODO реализуйте класс Hours, который наследует интерфейс TimeUnit
    private long value;

    public Hours(long value) {
        this.value = value;
    }

    @Override
    public long toHours() {
        return value;
    }

    @Override
    public long toMillis() {
        return value * 3_600_000;
    }

    @Override
    public long toMinutes() {
        return value * 60;
    }

    @Override
    public long toSeconds() {
        return value * 3600;
    }
}