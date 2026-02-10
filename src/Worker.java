public class Worker extends Person {

    private double hourlyPayRate;

    public Worker(String IDNum, String firstName, String lastName, String title, int YOB, double hourlyPayRate) {
        super(IDNum, firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        double pay = 0.0;
        if (hoursWorked <= 40) {
            pay = hoursWorked * hourlyPayRate;
        } else {
            double regularPay = 40 * hourlyPayRate;
            double overtimePay = (hoursWorked - 40) * (hourlyPayRate * 1.5);
            pay = regularPay + overtimePay;
        }
        return pay;
    }

    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = hoursWorked > 40 ? 40 : hoursWorked;
        double overtimeHours = hoursWorked > 40 ? hoursWorked - 40 : 0;
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * (hourlyPayRate * 1.5);
        double totalPay = regularPay + overtimePay;

        System.out.printf("Regular Hours: %.2f, Regular Pay: %.2f\n", regularHours, regularPay);
        System.out.printf("Overtime Hours: %.2f, Overtime Pay: %.2f\n", overtimeHours, overtimePay);
        System.out.printf("Total Pay: %.2f\n", totalPay);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + hourlyPayRate;
    }

    @Override
    public String toXML() {
        String baseXML = super.toXML();
        return baseXML.replace("</Person>", "") +
                "<hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate>" +
                "</Person>";
    }

    @Override
    public String toJSON() {
        String baseJSON = super.toJSON();
        return baseJSON.substring(0, baseJSON.length() - 1) +
                ", \"hourlyPayRate\":" + hourlyPayRate + "}";
    }
}