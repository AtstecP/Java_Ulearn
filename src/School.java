import java.util.ArrayList;

public class School {
    //напишите класс School
    private ArrayList<Pupil> pupils = new ArrayList<>();
    private ArrayList<Teacher> teatchers = new ArrayList<>();

    public String getPeoplesInSchool() {
        /* реализуйте метод получения учителей и учеников в школе
           в формате:

           В школе:
           Игорь Николаев Математика 20
           Иван Иванов 2010
         */
        StringBuilder str = new StringBuilder();
        str.append("В школе:\n");
        for (var human : pupils) {
            if (human.isInSchool())
                str.append(human.toString() + '\n');
        }

        for (var human : teatchers) {
            if (human.isInSchool())
                str.append(human.toString() + '\n');
        }

        return str.toString();
    }

    public void add(Pupil human) {
        pupils.add(human);
    }

    public void add(Teacher human) {
        teatchers.add(human);
    }
    //добавление человека в школу

}

abstract class Human {
    //напишите класс Human
    //goInSchool() — пришел в школу, outFromSchool() — вышел из школы
    // isInSchool() — статус в школе/не в школе типа boolean

    protected final String name;
    protected final String secondName;

    protected int date_info;
    protected boolean inScholl = false;

    public Human(String name, String secondName, int date_info) {
        this.name = name;
        this.secondName = secondName;
        this.date_info = date_info;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return secondName;
    }

    public int getYear() {
        return date_info;
    }

    public void goInSchool() {
        inScholl = true;
    }

    public void outFromSchool() {
        inScholl = false;
    }

    public boolean isInSchool() {
        return inScholl;
    }
}

class Pupil extends Human {


    public Pupil(String name, String secondName, int date) {
        super(name, secondName, date);
    }

    /*напишите класс Pupil
      формат вывода toString(): имя фамилия год поступления
     */
    @Override
    public String toString() {
        return String.format("%s %s %d", name, secondName, date_info);
    }
}

class Teacher extends Human {
    private String major;

    public Teacher(String name, String secondName, String major, int date_info) {
        super(name, secondName, date_info);
        this.major = major;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d", name, secondName, major, date_info);
    }
    /*напишите класс Teacher
      формат вывода toString(): имя фамилия предмет стаж работы
     */
}