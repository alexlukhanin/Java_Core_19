/**
 * Homework 19
 */
package ua.lviv.lgs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author alexl
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("----------------------------------------------------");
		System.out.println("Output from file employee1.bin (Object Employee):");
		System.out.println();

		File file = new File("employees1.bin");
		Employee employee = new Employee("Joney Deep", 1568, 7000.0);
		try {
			Methods.serialize(file, employee);
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			System.out.println(Methods.deserialize(file));
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println();

		/* ------------declaration of the collection --------------------- */

		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Patrick Branson", 1522, 6500.0));
		employees.add(new Employee("Andrew Cox", 1402, 5200.0));
		employees.add(new Employee("Jarome Domm", 1200, 9000.5));
		employees.add(new Employee("Olexis Trumper", 815, 12000.0));
		employees.add(new Employee("Dimon Hillton", 2001, 7995));
		employees.add(new Employee("Gomer Sommer", 1302, 6500));
		employees.add(new Employee("Samanta Jones", 1485, 12950.0));

		/* ---- the way when put each object (employee) in the stream --- */
		System.out.println("----------------------------------------------------");
		System.out.println();
		System.out.println("Output from file employee2.bin (Collection of Objects Employee)[1st way] :");
		System.out.println();

		File file2 = new File("employees2.bin");
		Iterator<Employee> iterator = employees.iterator();
		while (iterator.hasNext()) {
			Employee next = (Employee) iterator.next();
			try {
				Methods.serialize(file2, next);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				System.out.println(Methods.deserialize(file2));
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		/* ----- the way when put all collection in the stream ----- */

		File file3 = new File("employees3.bin");

		try {
			Methods.serialize(file3, employees);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ArrayList<Employee> employees2 = null;
		try {
			employees2 = (ArrayList<Employee>) Methods.deserialize(file3);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		/* --- Output from collection to console ---- */
		System.out.println("----------------------------------------------------");
		System.out.println();
		System.out.println("Output from file employee3.bin (Collection of Objects Employee)[2nd  way]:");
		System.out.println();

		Iterator<Employee> iterator2 = employees2.iterator();
		while (iterator2.hasNext()) {
			Employee employee2 = (Employee) iterator2.next();
			System.out.println(employee2);
		}

	}

}
