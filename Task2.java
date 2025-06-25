//STUDENT RECORD MANAGEMENT SYSTEM

import java.util.*;

class Student
{
	int id;
	String name;
	double marks;

	Student(int id, String name, double marks)
	{
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	public String toString()
	{
		return "ID : " + id + ", Name : " + name + ", Marks :" + marks;
	}

}

class Task2
{
	static ArrayList<Student> students = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[])
	{
		int choice;

		System.out.println("\t......Student Record Management System.......");

		do{
			
			System.out.println("Menu");
			System.out.println("1. Add Student");
			System.out.println("2. View Students");
			System.out.println("3. Update Students");
			System.out.println("4. Delete Students");
			System.out.println("5. Exit");
			
			System.out.print("Enter your choice (1 to 5) : ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:addStudent();
					break;
				case 2:viewStudent();
					break;
				case 3:updateStudent();
					break;
				case 4:deleteStudent();
					break;
				case 5:System.out.println("Exiting.....");
					break;
				default:System.out.println("Invalid choice...plz choose among 1-5 ");
			}
		}
		while(choice!=5);		
	}

	static void addStudent()
	{
		System.out.print("Enter Student ID : ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Student Name : ");
		String name = sc.nextLine();
		System.out.print("Enter Student Marks : ");
		double marks = sc.nextDouble();

		students.add(new Student(id, name, marks));
		System.out.println("\t...Record Added!...");
		
	}
	static void viewStudent()
	{
		if(students.isEmpty())
		{
			System.out.println("\t...No records found!...");
		}
		else
		{
			System.out.println("\nStudent Records:\n");
			for(Student s : students)
			{
				System.out.println(s);
			}
		}
	}
	static void updateStudent()
	{
		if(students.isEmpty())
		{
			System.out.println("\t...No records found!...");
		}
		else{
			System.out.print("Enter Student ID to update : ");
			int id = sc.nextInt();
			boolean found = false;
			
			for(Student s : students)
			{
				if(s.id == id)
				{
					found = true;
					System.out.print("Enter new Name : ");
					sc.nextLine();
					s.name = sc.nextLine();
					System.out.print("Enter new Marks : ");
					s.marks = sc.nextDouble();
					System.out.println("\t...Record Updated!...");
					break;
				}
			}
			
			if(!found)
				System.out.println("\t....Record not found!....");
		}
	}
	static void deleteStudent()
	{
		if(students.isEmpty())
		{
			System.out.println("\t...No records found!...");
		}
		else{
			System.out.print("Enter ID to delete : ");
			int id = sc.nextInt();
			boolean found = false;

			for(int i=0 ; i<students.size(); i++)
			{
				if(students.get(i).id == id)
				{
					students.remove(i);
					found = true;
					System.out.println("\t...Record deleted!...");
					break;
				}
			}
			if(!found)
			{
				System.out.println("\t...Record not found!...");
			}
		}
	}
}