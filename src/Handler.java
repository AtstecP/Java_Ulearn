public class Handler {
    //создайте новые классы ошибок NullHandlerException, HandlerException и HandlerResultException, наследуемые от RuntimeException
    public int handleResults(String input) {
        //реализуйте код метода handleResults
        if (input.length() == 0) throw new NullHandlerException();
        if (input.contains("error")) throw new HandlerException();
        var x = input.split("\\.");
        try {
            int answer = Integer.parseInt(x[0])+Integer.parseInt(x[1])-Integer.parseInt(x[2])*Integer.parseInt(x[3]);
            if (answer < 0) throw new HandlerResultException();
            return answer;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            return 0;
        }
        }
    class HandlerException extends RuntimeException{}
    class HandlerResultException  extends RuntimeException{}
    class NullHandlerException extends RuntimeException{}
    }

