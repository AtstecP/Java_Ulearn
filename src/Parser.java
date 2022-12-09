import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {
    public static void main(String[] args) {
        Movements info = new Movements("movementList.csv");
        System.out.println(String.format("Расходы = %.2f",info.getExpenseSum()));
        System.out.println(String.format("Доходы = %.2f",info.getIncomeSum()));
        System.out.println("\nСписок проведенных операций: \n");
        for(var transaction: info.getListOfExpenses()){
            System.out.println(transaction);
        }
    }

}

class Movements {

    private ArrayList<String> getInfoTransaction(String line) {
        ArrayList<String> results = new ArrayList<String>();
        try {
            Scanner rowScanner = new Scanner(line);
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                results.add(rowScanner.next());
            }
        } catch (RuntimeException e) {
            System.out.println(e);
        }
        return results;
    }

    private ArrayList<ArrayList<String>> transactions = new ArrayList<>();

    public Movements(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                transactions.add(getInfoTransaction(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    private double convertToDouble(ArrayList<String> info) {
        if (info.size() > 8) {
            String result = info.get(7) + "." + info.get(8);
            return Double.valueOf(result.replace("\"", ""));
        }
        return Double.valueOf(info.get(7));
    }

    public double getIncomeSum() {
        double result = 0;
        for (int i = 1; i < transactions.size(); i++) {
            result += Double.valueOf(transactions.get(i).get(6));
        }
        return result;
    }

    public double getExpenseSum() {
        double res = 0;
        for (int i = 1; i < transactions.size(); ++i) {
            ArrayList<String> data = transactions.get(i);
            res += convertToDouble(data);
        }
        return res;
    }

    private String getOrganization(String info) {
        String[] answer;
        while (!(info.startsWith("/") | info.startsWith("\\"))) {
            info = info.substring(1);
        }
        answer = info.split(" ");
        return String.format("%s %s %s", answer[0], answer[1], answer[2]);
    }

    public ArrayList<String> getListOfExpenses() {
        ArrayList<String> result = new ArrayList<>();
        Map<String, Double> organizations = new HashMap<>();
        for (int i = 1; i < transactions.size(); i++) {
            double value = convertToDouble(transactions.get(i));
            String organization = getOrganization(transactions.get(i).get(5));
            if (organizations.containsKey(organization)) {
                organizations.replace(organization,
                        organizations.get(organization) + value);
            } else {
                organizations.put(organization, value);
            }
        }

        for (var comp : organizations.keySet()) {
            result.add(comp.strip() + " —> " + new java.text.DecimalFormat("#.00").format(organizations.get(comp)) + " руб.");
        }
        return result;
    }
}