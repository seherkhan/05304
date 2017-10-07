package Task2;

/**
 * Used to create objects that represent salaried employees
 */
public class SalariedEmployee extends Employee {
    private double weeklySalary;
    /**
     * Constructor
     * @param name
     * @param nic
     * @param sal
     */
    public SalariedEmployee(String name, String nic, double sal){
        super(name,nic);
        this.weeklySalary=sal;
    }

    /**
     * Calculate earnings
     * @return earnings which is equal to the weekly salary
     */
    @Override
    public double earnings() {
        return weeklySalary;
    }
    /**
     * Display details of the object
     */
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.print(", Earnings: "+earnings()+"\n");
    }
}
