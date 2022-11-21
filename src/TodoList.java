import java.util.ArrayList;

public class TodoList {

    ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        TodoList info = new TodoList();
        info.add("KIll Bill");
        info.add("Become developer");
        info.add("Wash the disches");
        info.add("Do homework");
        info.add("Make relationship");
        info.add(3, "Make money");
        info.edit("---ready---", 2);
        info.delete(4);
        for (Object item : info.getTodos()) {
            System.out.println(item);
        }
    }

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        list.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index <= list.size())
            list.add(index, todo);
        else throw new IllegalArgumentException();

    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index < list.size())
            list.set(index, todo);
        else throw new IllegalArgumentException();
    }

    public void delete(int index) {
//         TODO: удалить дело находящееся по переданному индексу,
//          проверьте возможность удаления дела
        if (index < list.size())
            list.remove(index);
        else throw new IllegalArgumentException();
    }

    public ArrayList<String> getTodos() {
        return list;
    }
}