package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String department = sc.next();
		System.out.println("Enter worker data:");
		sc.nextLine();
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.next();
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(department));
		
		System.out.println("How many contracts to this worker");
		int num = sc.nextInt();
		for(int i = 1; i <= num; i++) {
			System.out.println("Enter contract #"+i+" data:");
			System.out.print("Date(DD/MM/YYYY): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration(Hours): ");
			int duration = sc.nextInt();
			HourContract contract = new HourContract(date, valuePerHour, duration);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter the month and year to calculate income (MM/YYYY): ");
		String month_and_year = sc.next();
		int month = Integer.parseInt(month_and_year.substring(0, 2));
		int year = Integer.parseInt(month_and_year.substring(3));
		System.out.println("Name: "+worker.getName());
		System.out.println("Department: "+worker.getDepartment().getName());
		System.out.printf("Income for "+month_and_year+": "+"%.2f", worker.income(year, month));
		
		
		
		
		
		
		sc.close();

	}

}
