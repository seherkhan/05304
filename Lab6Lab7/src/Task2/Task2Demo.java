package Task2;

import java.util.Scanner;

/**
 * Created by Seher Khan on 10/1/2017.
 */
public class Task2Demo {
    public static void main(String[] args) {
        Employee[] array=new Employee[3];
        Scanner s = new Scanner(System.in);

        //initializing each employee
        for(int i=1;i<4;i++){
            System.out.println("Create worker "+i+": ");
            System.out.println("Enter name: ");
            String name=s.nextLine();
            System.out.println("Enter NIC number: ");
            String nic=s.nextLine();
            System.out.println("Salaried or Hourly? (s/h)");
            String str=s.nextLine().toLowerCase();
            if(str.equals("s")){
                System.out.println("Enter weekly salary: ");
                double sal=Double.parseDouble(s.nextLine());
                array[i-1]=new SalariedEmployee(name,nic,sal);
            }
            else if(str.equals("h")){
                System.out.println("Enter hourly salary: ");
                double hSal=Double.parseDouble(s.nextLine());
                System.out.println("Enter hours worked: ");
                double h=Double.parseDouble(s.nextLine());
                array[i-1]=new HourlyEmployee(name,nic,hSal,h);
            }
        }

        //calculating earnings of each and calling display method
        for(int i=0;i<3;i++){
            array[i].earnings();
            array[i].displayDetails();

        }



    }
}
