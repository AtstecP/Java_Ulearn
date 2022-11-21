import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        //System.out.println(getRevertString("!д]Ок ТоТэ ьТАсиП Еж кАк У[Н"));
        //System.out.println(a.getClass());
        String x = "asasd";
        System.out.println(calculate("hhhhhhhhhh - hhhh           "));

        //System.out.println((Objects.equals(x.replaceAll("3", ""),x)));
    }

    static boolean isInteger(String str) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
        return true;
    }

    public static String calculate(String input) {
        //TODO напишите метод Calculate, который будет получать строку в формате <первый аргумент> <операция> <второй аргумент>
        //разделенными пробелом и отправлять в нужные методы
        String[] words = input.split(" ");
        if ((words.length != 3) || (input.lastIndexOf(words[2].charAt(words[2].length() - 1)) != input.length() - 1)) // проверка на еоличество элементво и наличие пробелов в конце исходной строки
            throw new IllegalArgumentException();
        if (isInteger(words[0]) && isInteger(words[2])) {
            if (Objects.equals(words[2], "0")) throw new IllegalArgumentException();
            input = Double.toString(calculate(Double.parseDouble(words[0]), Double.parseDouble(words[2]), words[1]));
        } else input = calculate(words[0], words[2], words[1]);
        return input;
    }

    private static String calculate(String a, String b, String operation) {
        //TODO напишите метод для складывания, либо вычитания строк
        //Важно: для вычитания строки, они должны совпадать по регистру
        //String answer = a;
        if (Objects.equals(operation, "-")) {
            String answer = a.replace(b, "");
            if (Objects.equals(answer, a)) throw new IllegalArgumentException();
            return answer;
        } else if (Objects.equals(operation, "+")) return a + b;
        else throw new IllegalArgumentException();
    }

    private static double calculate(double a, double b, String operation) {
        //TODO напишите метод для работы с числами со следующими операциями: +, -, /, *, %
        return switch (operation) {
            case ("+") -> a + b;
            case ("-") -> a - b;
            case ("/") -> a / b;
            case ("*") -> a * b;
            case ("%") -> a % b;
            default -> throw new IllegalArgumentException();
        };
    }

    public static int getNumbers(int a, int b) {
        //TODO напишите метод принимает два аргумента, складывает их и возращает кол-во четных цифр в сумме
        a = Math.abs(a + b);
        int answer = 0;
        int lenght = (int) (Math.log10(a) + 1);
        for (int i = 0; i < lenght; ++i) {
            if (a % 10 % 2 == 0) ++answer;
            a /= 10;
        }
        return answer;
    }

    public static String getMinimalType(String input) {
        //TODO напишите метод получается число в формате строки и возращает минимальный целочисленный тип, к которому его можно привести, Long, Int, Short или Byte
        long x = Long.parseLong(input);
        if (x <= Byte.MAX_VALUE) return "Byte";
        if (x <= Short.MAX_VALUE) return "Short";
        if (x <= Integer.MAX_VALUE) return "Int";
        return "Long";
    }


}