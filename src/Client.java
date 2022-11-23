public abstract class Client {
    /*TODO написать классы Client, IndividualBusinessman, PhysicalPerson и LegalPerson
        с методами put(), take(), getAmount()
    */
    float money = 0;

    public void put(float value) {
        if (value > 0)
            money += value;
    }

    public void take(float value) {
        if ((value <= money) && (value > 0))
            money -= value;
    }

    public float getAmount() {
        return money;
    }

}

class PhysicalPerson extends Client {
}

class IndividualBusinessman extends Client {
    @Override
    public void put(float value) {
        if (value > 0) {
            if (value < 1000) value = 0.99f * value;
            else value = 0.995f * value;
            money += value;
        }
    }
}

class LegalPerson extends Client {
    @Override
    public void take(float value) {
        if ((value <= money) && (value > 0)) {
            value = 1.01f * value;
            money -= value;
        }
    }
}