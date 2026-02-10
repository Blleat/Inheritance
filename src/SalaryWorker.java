public class SalaryWorker extends Worker {

    private double annualSalary;

    public SalaryWorker(String IDNum, String firstName, String lastName, String title, int YOB, double annualSalary) {
        super(IDNum, firstName, lastName, title, YOB, 0);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = annualSalary / 52;
        System.out.printf("Weekly pay is a fraction of the yearly salary: %.2f\n", weeklyPay);
    }

    @Override
    public String toCSV() {
        return super.getIDNum() + ", " + super.getFirstName() + ", " + super.getLastName() + ", " + super.getTitle() + ", " + super.getYOB() + ", " + annualSalary;
    }

    @Override
    public String toXML() {
        return "<SalaryWorker>" +
                "<IDNum>" + super.getIDNum() + "</IDNum>" +
                "<firstName>" + super.getFirstName() + "</firstName>" +
                "<lastName>" + super.getLastName() + "</lastName>" +
                "<title>" + super.getTitle() + "</title>" +
                "<YOB>" + super.getYOB() + "</YOB>" +
                "<annualSalary>" + annualSalary + "</annualSalary>" +
                "</SalaryWorker>";
    }

    @Override
    public String toJSON() {
        return "{" +
                "\"IDNum\":\"" + super.getIDNum() + "\"," +
                "\"firstName\":\"" + super.getFirstName() + "\"," +
                "\"lastName\":\"" + super.getLastName() + "\"," +
                "\"title\":\"" + super.getTitle() + "\"," +
                "\"YOB\":" + super.getYOB() + "," +
                "\"annualSalary\":" + annualSalary +
                "}";
    }
}