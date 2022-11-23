import java.util.ArrayList;

public abstract class Animal {
    //TODO реализуйте абстрактный класс Animal, с параметрами name и age
    //Формат toString(): '<имя>', age= <age>
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("'%s', age= %d", name, age);
    }
}

class Lion extends Animal {
    //TODO реализуйте класс-наследник от Animal, с дополнительным параметром bodyLength
    private double bodyLength;

    public Lion(String name, int age, double bodyLength) {
        super(name, age);
        this.bodyLength = bodyLength;
    }

    public double getBodyLength() {
        return bodyLength;
    }

    @Override
    public String toString() {
        return String.format("'%s', age= %d, bodyLength= %s", name, age, bodyLength);
    }
}


class Monkey extends Animal {
    //TODO реализуйте класс-наследник от Animal, с дополнительным параметром color
    private String color;

    public Monkey(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("'%s', age= %d, color= %s", name, age, color);
    }

}

class Zoo {
    //TODO реализуйте класс Zoo, который будет хранить список животных, а также методы getSize и getReport
    ArrayList<Animal> animals = new ArrayList<>();

    public void add(Animal animal) {
        animals.add(animal);
    }

    public int getSize() {
        return animals.size();
    }

    public String getReport() {
        StringBuilder str = new StringBuilder();
        int i = 1;
        for (var animal : animals) {
            str.append(String.format("%d %s\n", i, animal.toString()));
            ++i;
        }
        return str.toString();
    }
}
