
public class StudentGradeManagementSystem {
	static {
		System.out.println("------------------------------- ");
		System.out.println("WELCOME TO CODTECH IT SOLUTIONS ");
		System.out.println("------------------------------- ");
		System.out.println("Student Grade Management System");
		System.out.println("-------------------------------");
	}
	public static Scanner sc = new Scanner(System.in);
	static {
		System.out.print("Enter Maximum Capacity for Student Records: ");
	}
	private static int MaximumNumberOfStudents = sc.nextInt();
	private static Student[] studentRecords = new Student[MaximumNumberOfStudents];
	private static int currentStudentCount = 0;

	public static void main(String[] args) {
		int option;
		while (true) {
			System.out.println("--------------------------------------");
			System.out.print("Choose one of the following Operations \n" 
					+ "	'1' -> ADD\n" 
					+ "	'2' -> UPDATE\n"
					+ "	'3' -> DELETE\n" 
					+ "	'4' -> EXIT\n" 
					+ "	'5' -> DISPLAY DATABSE\n" 
					+ "Choose a Number to access Student Records : ");
			while (true) {
				try {
					option = sc.nextInt();
					if (option != 1 && option != 2 && option != 3 && option != 4 && option != 5) {
						throw new Exception();
					}
					break;
				} catch (InputMismatchException e) {
					System.err.println("ENTER ONLY NUMBERS");
					sc.next();
				} catch (Exception e) {
					System.err.println("NUMBER SHOULD BE BETWEEN 1 AND 5");
					sc.next();
				}
			}
			System.out.println("--------------------------------------");
			switch (option) {
			case 1:
				if (currentStudentCount >= MaximumNumberOfStudents) {
					System.out.println("SORRY...NO SEATS ARE AVAILABLE");
					break;
				} else {
					addStudentDetails();
					break;
				}
			case 2:
				updateStudentDetails();
				break;
			case 3:
				if(currentStudentCount==0) {
					System.out.println("STUDENT RECORD IS EMPTY");
					break;
				}
				else {
					deleteStudentDetails();
					break;
				}
			case 5:
				displayStudentRecords();
				break;
			case 4:
				System.out.println("Thank you. Have a Nice Day!!");
				System.exit(0);
			}
		}
	}

	public static void addStudentDetails() {
		System.out.println("Enter Student Details:");
		System.out.println("----------------------");
		studentRecords[currentStudentCount] = new Student();
		currentStudentCount++;
		System.out.println("One Student Data ADDED");
	}

	public static void updateStudentDetails() {
		if(currentStudentCount<=0) {
			System.err.println("NO STUDENT RECORDS ARE AVAILABLE");
		}
		else {
			System.out.print("Which Student Record you want to Update? Enter position (1 to "+currentStudentCount+") :");
			int position;
			while (true) {
				try {
					position = sc.nextInt();
					if (position <= 0 || position>currentStudentCount) {
						throw new Exception();
					}
					break;
				} catch (InputMismatchException e) {
					System.err.println("ENTER ONLY NUMERIC VALUES");
					sc.next();
				} catch (Exception e) {
					System.err.println("POSITION SHOULD BE IN BETWEEN 1 AND "+currentStudentCount);
					sc.next();
				}
			}
			System.out.println("Choose an Option to Update Student Data\n"
					+ "	'1' -> STUDENT NAME\n" 
					+ "	'2' -> ROLL NUMBER\n"
					+ "	'3' -> MARKS\n" 
					+ "Choose a Number to Update Student Records : ");
			int option;
			while (true) {
				try {
					option = sc.nextInt();
					if (option != 1 && option != 2 && option != 3) {
						throw new Exception();
					}
					break;
				} catch (InputMismatchException e) {
					System.err.println("ENTER ONLY NUMBERS");
					sc.next();
				} catch (Exception e) {
					System.err.println("NUMBER SHOULD BE BETWEEN 1 AND 3");
					sc.next();
				}
			}
			switch(option) {
			case 1:
				System.out.print("Enter StudentName to be Updated: ");
				studentRecords[position-1].setStudentName(sc.nextLine()); sc.next();
				break;
			case 2:
				System.out.print("Enter Student Roll Number to be Updated: ");
				studentRecords[position-1].setRollNumber(sc.nextInt());
				break;
			case 3:
				System.out.println("Enter Student Marks for "+studentRecords[position-1].getMarks().length+" subjects: ");
				int []updatedMarks= new int[studentRecords[position-1].getMarks().length];
				for(int i=0;i<updatedMarks.length;i++) {
					System.out.print("Subject - "+(i+1)+": ");
					updatedMarks[i] = sc.nextInt();
				}
			}
			System.out.println("One Student Data Updated");
		}
	}

	public static void deleteStudentDetails() {
		if(currentStudentCount==1) {
			currentStudentCount--;
			System.out.println("One Student Data DELETED.");
		}
		else if(currentStudentCount<1){
			System.out.println("Student Records are already Empty");
		}
		else {
			System.out.print("Which Student Record you want to Delete? Enter position (1 to "+currentStudentCount+") :");
			int position;
			while (true) {
				try {
					position = sc.nextInt();
					if (position <= 0 || position>currentStudentCount) {
						throw new Exception();
					}
					break;
				} catch (InputMismatchException e) {
					System.err.println("ENTER ONLY NUMERIC VALUES");
					sc.next();
				} catch (Exception e) {
					System.err.println("POSITION SHOULD BE IN BETWEEN 1 AND "+currentStudentCount);
					sc.next();
				}
			}
			for(int i=position;i<currentStudentCount;i++) {
				studentRecords[i-1]=studentRecords[i];
			}
			System.out.println("One Student Data DELETED");
			currentStudentCount--;
		}
	}
	public static void displayStudentRecords() {
		if(currentStudentCount<=0) {
			System.err.println("STUDENTS RECORD IS EMPTY");
		}else {
			for(int i=0;i<currentStudentCount;i++) {
				System.out.println("Student No."+(i+1)+" : "+studentRecords[i].getStudentData());
			}
		}
	}
}

class Student {
	private String studentName;
	private int rollNumber;
	private int numberOfSubjects;
	private int[] marks;
	
	//NON STATIC BLOCK START
	{	
		Scanner sc = StudentGradeManagementSystem.sc;
		
		System.out.println("Enter student name: ");
		
		while(true) {
			try {
				studentName = sc.next();
				if(studentName=="") {
					throw new Exception();
				}
				break;
			}catch(Exception e) {
				System.err.println("Name should not be Empty");
				sc.next();
			}
		}
		

		System.out.println("Enter Roll Number: ");
		while (true) {
			try {
				rollNumber = sc.nextInt();
				if (rollNumber <= 0) {
					throw new Exception();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("ENTER ONLY NUMERIC VALUES");
				sc.next();
			} catch (Exception e) {
				System.err.println("NEGATIVE NUMBERS NOT ALLOWED");
				sc.next();
			}
		}
		System.out.println("Enter number of subjects: ");
		while (true) {
			try {
				numberOfSubjects = sc.nextInt();
				if (numberOfSubjects <= 0) {
					throw new Exception();
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("ENTER ONLY NUMERIC VALUES");
				sc.next();
			} catch (Exception e) {
				System.err.println("NEGATIVE NUMBERS NOT ALLOWED");
				sc.next();
			}
		}
		marks = new int[numberOfSubjects];
		System.out.println("Enter marks: ");
		for (int i = 0; i < numberOfSubjects; i++) {
			System.out.print("Subject " + (i + 1) + " : \n");
			try {
				marks[i] = sc.nextInt();
				if (marks[i] < 0 || marks[i] > 100) {
					throw new Exception();
				}
			} 
			catch (InputMismatchException e) {
				System.err.println("ENTER ONLY NUMERIC VALUES");
				sc.next();
			} 
			catch (Exception e) {
				System.err.println("MARKS SHOULD BE IN BETWEEN 1 AND 100");
				sc.next();
			}
		}
	}//NON STATIC BLOCK END
	
	public Student() {
		super();
	}

	public Student(String studentName, int rollNumber, int numberOfSubjects) {
		super();
		this.studentName = studentName;
		this.rollNumber = rollNumber;
		this.numberOfSubjects = numberOfSubjects;
	}
	
	private double percentage = calculatePercentage();
	private char grade = calculateGrade();
	public double calculatePercentage() {
		int obtainedMarks = 0;
		int totalMarks = 100 * numberOfSubjects;
		for (int i = 0; i < numberOfSubjects; i++) {
			obtainedMarks += marks[i];
		}
		return (obtainedMarks / (double) totalMarks) * 100;
	}

	public char calculateGrade() {
		if (percentage >= 90)
			return 'A';
		else if (percentage >= 80)
			return 'B';
		else if (percentage >= 70)
			return 'C';
		else if (percentage >= 60)
			return 'D';
		else if (percentage >= 50)
			return 'E';
		else
			return 'F';
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public int getNumberOfSubjects() {
		return numberOfSubjects;
	}

	public void setNumberOfSubjects(int numberOfSubjects) {
		this.numberOfSubjects = numberOfSubjects;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}
	public String getStudentData() {
		return "[ Name: "+studentName+", RollNumber: "+this.rollNumber+", Percentage: "+percentage+"%, Grade: "+this.grade+" ]";
	}
}