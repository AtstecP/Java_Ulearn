public class Hospital {

    //TODO напишите консольное приложение для работы с классом больница, учитывая, что сгенерированные и вычисленные переменные,
    // нельзя будет менять.
    /* Hospital hos1 = new Hospital(5);
        System.out.println(hos1.getAverageTemp());
//        //System.out.println(Arrays.toString(hos1.generatePatientsTemperatures()));
//        System.out.println(hos1.getCountHealthy());
//        System.out.println(hos1.getTemperaturesToString());
//        //System.out.println(Arrays.toString(hos1.generatePatientsTemperatures()));
//        System.out.println(hos1.getAverageTemp());
        System.out.println(hos1.getReport());
        ystem.out.println(Objects.equals("Температуры пациентов: 32,2 34,6 36,0 36,7 36,9 32,9 36,1 35,7 37,9 38,9 38,7 32,0 34,1 35,2 39,6 33,6 32,7 33,4 35,2 38,3 35,5 35,6 36,2 37,7 39,5 33,5 37,7 34,6 34,2 39,7 38,7 37,2 38,7 39,9 38,1 37,0 39,3 34,6 33,0 36,2 37,1 33,0 34,8 38,2 35,8 39,0 32,1 32,9 39,8 36,7 37,6 32,8 33,9 37,6 33,6 38,2 34,9 39,0 38,4 33,6 39,8 36,8 35,5 36,7 32,3 38,5 39,0 39,3 36,7 39,8 38,7 37,9 38,2 40,0 32,3 39,7 35,7 38,1 32,5 38,3 33,3 34,4 32,1 37,3 33,3 37,5 32,2 38,1 33,8 36,0 36,5 33,8 35,7 34,9 34,1 32,2 35,2 33,2 38,9 34,5\n" +

                "Количество здоровых: 8", "Температуры пациентов: 32,2 34,6 36,0 36,7 36,9 32,9 36,1 35,7 37,9 38,9 38,7 32,0 34,1 35,2 39,6 33,6 32,7 33,4 35,2 38,3 35,5 35,6 36,2 37,7 39,5 33,5 37,7 34,6 34,2 39,7 38,7 37,2 38,7 39,9 38,1 37,0 39,3 34,6 33,0 36,2 37,1 33,0 34,8 38,2 35,8 39,0 32,1 32,9 39,8 36,7 37,6 32,8 33,9 37,6 33,6 38,2 34,9 39,0 38,4 33,6 39,8 36,8 35,5 36,7 32,3 38,5 39,0 39,3 36,7 39,8 38,7 37,9 38,2 40,0 32,3 39,7 35,7 38,1 32,5 38,3 33,3 34,4 32,1 37,3 33,3 37,5 32,2 38,1 33,8 36,0 36,5 33,8 35,7 34,9 34,1 32,2 35,2 33,2 38,9 34,5\n" +

                "Количество здоровых: 8"));*/

    private int patientsCount;
    private int CountHealthy;
    private float[] patientsTemperatures;
    private String TemperaturesToString;
    private float AverageTemp;

    public Hospital(int patientsCount) {
        //TODO создание больницы с указанным кол-вом пациентов
        // если значение не верное, бросать IllegalArgumentException с помощью метода throw new <Exception.class>
        if (patientsCount <= 0) throw new IllegalArgumentException();
        this.patientsCount = patientsCount;
    }

    //нужно кол-во пациентов
    public float[] generatePatientsTemperatures() {
        //TODO реализовать генерацию массива температур от 32 до 40 градусов
        if (patientsTemperatures == null) {
            int min = 32;
            int max = 40;
            patientsTemperatures = new float[patientsCount];
            for (int i = 0; i < patientsCount; ++i) {
                patientsTemperatures[i] = (float) ((Math.random() * (max - min)) + min);
            }
        }
        return patientsTemperatures;
    }

    //нужна генерация температур
    public int getCountHealthy() {
        //TODO реализовать подсчёт кол-ва здоровых(36,2 < x < 36,9) в сгенерированном массиве температур
        // если метод уже был вызван ранее, не выполнять подсчет снова, а возращать текущее вычисленное значение
        // если генерация температур не была выполнена, вызвать метод генерации
        if (patientsTemperatures == null)
            generatePatientsTemperatures();
        float minTemp = 36.2f;
        float maxTemp = 36.9f;
        if (CountHealthy == 0)
            for (int i = 0; i < patientsCount; ++i)
                if ((patientsTemperatures[i] > minTemp) & (patientsTemperatures[i] < maxTemp))
                    CountHealthy += 1;
        return CountHealthy;

    }

    //нужна генерация температур
    public String getTemperaturesToString() {
        //TODO реализовать получение массива температур в виде строки <double>, <double>, <double>
        // если метод уже был вызван ранее, не выполнять подсчет снова, а возращать текущее вычисленное значение
        // если генерация температур не была выполнена, вызвать метод генерации
        if (patientsTemperatures == null)
            generatePatientsTemperatures();
        if (TemperaturesToString == null) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < patientsCount; ++i)
                str.append((String.format("%.1f", patientsTemperatures[i])) + " ");
            str.deleteCharAt(str.length() - 1);
            TemperaturesToString = str.toString();
        }
        return TemperaturesToString;
    }

    //Нужна генерация температур
    public double getAverageTemp() {
        //TODO реализовать получение средней температуры из массива
        // если метод уже был вызван ранее, не выполнять подсчет снова, а возращать текущее вычисленное значение
        // если генерация температур не была выполнена, вызвать метод генерации
        float sum = 0;
        if (patientsTemperatures == null)
            generatePatientsTemperatures();
        if (AverageTemp == 0)
            for (int i = 0; i < patientsCount; ++i) {
                sum += patientsTemperatures[i];
                AverageTemp = sum / patientsCount;
            }
        return AverageTemp;
    }


    //нужны температуры, средняя температура и кол-во здоровых
    public String getReport() {
        //TODO реализовать получение отчёта в формате приложенном ниже
        // если метод уже был вызван ранее, не выполнять подсчет снова, а возращать текущее вычисленное значение
        // если все необходимые переменные не были получены ранее, вызвать все методы необходимые для получения отчёта
        /*TODO Формат вывода:
           Температуры пациентов: 37,5 36,9 38,2 33,5 32,2
           Средняя температура: 35,67
           Количество здоровых: 1
         */
        if (AverageTemp == 0)
            getAverageTemp();
        if (CountHealthy == 0)
            getCountHealthy();
        if (TemperaturesToString == null)
            getTemperaturesToString();
        StringBuilder str = new StringBuilder();
        str.append("");

        return String.format("Температуры пациентов: %s\n", TemperaturesToString) +
                String.format("Средняя температура: %.2f\n", AverageTemp) +
                String.format("Количество здоровых: %d", CountHealthy);
    }
}
