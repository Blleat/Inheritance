import java.util.ArrayList;

public class InheritanceDemo {

    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        workers.add(new Worker("001", "John", "Doe", "Mr.", 1990, 20.0));
        workers.add(new Worker("002", "Alice", "Cooper", "Mrs.", 1992, 25.0));
        workers.add(new Worker("003", "Bob", "Builder", "Mr.", 1988, 18.5));

        workers.add(new SalaryWorker("004", "Eve", "Manager", "Ms.", 1985, 60000.0));
        workers.add(new SalaryWorker("005", "Charlie", "Boss", "Mr.", 1980, 80000.0));
        workers.add(new SalaryWorker("006", "Diana", "Director", "Dr.", 1975, 120000.0));

        int[] hoursWorkedPerWeek = {40, 50, 40};

        for (int i = 0; i < hoursWorkedPerWeek.length; i++) {
            int week = i + 1;
            int hours = hoursWorkedPerWeek[i];
            System.out.println("Week " + week + " (Hours worked: " + hours + ")");
            System.out.println("---------------------------------------------------------");
            System.out.printf("%-20s %-20s %-15s\n", "Name", "ID", "Weekly Pay");
            System.out.println("---------------------------------------------------------");

            for (Worker w : workers) {
                System.out.printf("%-20s %-20s $%-15.2f\n",
                        w.getFormalName(),
                        w.getIDNum(),
                        w.calculateWeeklyPay(hours));
            }
            System.out.println();
        }
    }
}