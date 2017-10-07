package Task2;

/**
 * Used to create objects that represent hourly employees
 */
public class HourlyEmployee extends Employee {
    private double wage;
    private double hours;
    /**
     * Constructor
     * @param name
     * @param nic
     * @param wage
     * @param hours
     */
    public HourlyEmployee(String name, String nic, double wage, double hours){
        super(name,nic);
        this.wage=wage;
        this.hours=hours;
    }

    /**
     * Calculate earnings
     * @return earnings
     */
    @Override
    public double earnings() {
        if(hours<40){
            return wage*hours;
        }
        else{
            return 40*wage+(hours-40)*wage*1.5;
        }
    }
    /**
     * Display details of the object
     */
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.print(", Hourly Wage: "+wage+", Hours Worked: "+hours+", Earnings: "+earnings()+"\n");
    }
}
