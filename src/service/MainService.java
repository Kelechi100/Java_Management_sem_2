
package service;

import java.util.ArrayList;
import java.util.Arrays;

//import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import model.Course;
import model.Degree;
import model.Grade;
import model.Person;
import model.Professor;
import model.Student;
//comment
public class MainService {
	private static ArrayList<Person> allPersons = new ArrayList<Person>();
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();
	
	
	public static void main(String[] args) {
		Professor pr1 = new Professor(); // John smith -- default Professor
		Professor pr2 = new Professor("Karina", "Skirmante","123456-56789", Degree.Ms);
		Professor pr3 = new Professor("Marcis", "Naktins", "987654-54321",Degree.Ms);
		Professor pr4 = new Professor("Estere", "Vitola", "987654-34215",Degree.Ms);
		allPersons.addAll(Arrays.asList(pr1,pr2, pr3, pr4));
		// TODO  take a look to ArrayList Class in JAVA documentations
		System.out.println("PROFESSOR NAMES");
		
		
		
		 // Outputting for Students
		Student st1 = new Student(); // Agnes Iloghalu student
		Student st2 = new Student("Lara" , "Bernards", "123455-56789");
		Student st3 = new Student("Davyd", "Akimov","345678-19234");
		allPersons.addAll(Arrays.asList(st1,st2,st3));
		
		System.out.println(" NAMES OF STUDENTS");
		for(Person tempP: allPersons) {
			System.out.println(tempP);
		}
		
		System.out.println("------------------------------------------");
		
		// outputting for Courses
		
		Course c1 = new Course();
		Course c2 = new Course("Data Structure", 2, pr3);
		Course c3 = new Course("Networking", 4, pr4);
		Course c4 = new Course("Object Oriented Programming ", 4, pr3);
		allCourses.addAll(Arrays.asList(c1, c2, c3, c4));
		System.out.println("LIST OF COURSES, ITS' CREDIT POINTS  AND ITS PROFESSORS  ");
		
		for(Course tempCr: allCourses) {
			System.out.println(tempCr);
		}
		
		System.out.println("------------------------------------");
		 //  Outputting for grades
		Grade gr1 = new Grade();
		Grade gr2 = new Grade(4, st1, c3);// 4 for Agnes in Networking
		Grade gr3 = new Grade(10, st3, c2);// 10 for Davyd in Data Structure
		Grade gr4 = new Grade(7, st2, c2); //7 for Lara in Data S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tructure
		Grade gr5 = new Grade(8, st1, c3);//8 for Agnes in Networking
		Grade gr6 = new Grade(10, st1, c1);//8 for Agnes in JAVA
		Grade gr7 = new Grade(5, st2, c1);//5 for Lara in JAVA
		allGrades.addAll(Arrays.asList(gr1,gr2, gr3, gr4, gr5, gr6, gr7));
		System.out.println(" STUDENT GRADES IN EACH COURSE");
		for(Grade tempGr: allGrades) {
			System.out.println(tempGr);
		}
		
		try 
		{	System.out.println("AVERAGE GRADE ");
			System.out.println(st2.getName() + " " + st2.getSurname() + " -> "
					+calculateAVGForStudent(st2));
			System.out.println("FINAL GRADE  ");	
			System.out.println(st2.getName() + " " + st2.getSurname() + " -> "
						+calculateWeightedAVGForStudent(st2));
			System.out.println("AVERAGE GRADE ");
			System.out.println(st3.getName() + " " + st3.getSurname() + " -> "
					+calculateAVGForStudent(st3));
			System.out.println("FINAL GRADE ");	
			System.out.println(st3.getName() + " " + st3.getSurname() + " -> "
						+calculateWeightedAVGForStudent(st3));
			System.out.println("------------------------------");
			System.out.println("AVERAGE GRADE FOR EACH COURSE");	
			System.out.println(c2.getTitle() + " -> " + calculateAVGInCourse(c2));
			System.out.println(c3.getTitle() + " -> " + calculateAVGInCourse(c3));
			
			
			// calculating How many Courses the Professor teaches
			System.out.println("--------------------------------");
			System.out.println("PROFESSORS AND COURSES THOUGHT");
			System.out.println(pr4.getName() + " " + pr4.getSurname() + " leads " + 
					calculateHowManyCoursesbyProfessor(pr4) + " courses");
			
			System.out.println(pr3.getName() + " " + pr3.getSurname() + " leads " + 
					calculateHowManyCoursesbyProfessor(pr3) + " courses");
			
			System.out.println("---------------------------");
			System.out.println("STUDENT RESULTS");
			
			for(Person tempP: allPersons) {
				if(tempP instanceof Student)
				{
					Student tempSt = (Student)tempP;
				
					System.out.println(tempSt.getName() + " " + tempSt.getSurname() + " -> "
						+calculateAVGForStudent(tempSt));
				}
			}
			
			
		// function to sort Students
			//sortStudent();
			System.out.println("---------------------");
			System.out.println("STUDENT'S POSITION ");
			for(Person tempP : allPersons) {
				if(tempP instanceof Student)
				{
					Student tempSt = (Student)tempP;
					System.out.println(tempSt.getName() + " " + tempSt.getSurname() + "->"   + calculateAVGForStudent(tempSt));
				}
				
			}
			Student temp = retreiveStudentByPersoncode("123455-56789");
			System.out.println("tretrive student -> "+ temp);
			
			
			createStudent("Agnes", "Iloghalu", "123456-56789");
			System.out.println("create student testing (Agnes) -> ");
			for(Person tempP: allPersons) {
				if(tempP instanceof Student)
				{
					Student tempSt = (Student) tempP;
					System.out.println(tempSt);
				}
				
			}
			
			updateStudentByPersoncode("Lara", "John", "123455-56789");
			System.out.println("Updating Student testing (Lara) ->");
			for (Person tempP: allPersons)  {
				if(tempP instanceof Student)
				{
					Student tempSt = (Student) tempP;
					System.out.println(tempSt);
				}
				
				
			}
			deleteStudentbyPersoncode("123455-56789");
			System.out.println("Delete student testing (Lara) -> ");
			for (Person tempP: allPersons){
				if(tempP instanceof Student)
				{
					Student tempSt = (Student) tempP;
					System.out.println(tempSt);
				}
				
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	// function to calculate AGV for Student.
	public static float calculateAVGForStudent(Student inputStudent) throws Exception{
		if(inputStudent == null) throw new Exception("Problems with input");
		
		float sum = 0;
		int howMany = 0;
		
		for(Grade tempGr : allGrades) {
			if(tempGr.getStudent().equals(inputStudent)) {
				sum = sum + tempGr.getValue();
				howMany++;
			}
		}
		
		return sum/howMany;
	}
	 // the output for the AVG will be Java 6 and DataStrucure 8 AVG = (6 + 8)/2 = 7
	
	//function to calculate weighted Average for each Student
	public static float calculateWeightedAVGForStudent(Student inputStudent) throws Exception {
		
		if(inputStudent == null) throw new Exception("input Error");
		
		float sum = 0;
		int howManyCP = 0;
		
		for(Grade tempGr : allGrades) {
			if(tempGr.getStudent().equals(inputStudent)) {
				sum = sum + tempGr.getValue() *  tempGr.getCourse(). getCreditpoints();
				howManyCP = howManyCP + tempGr.getCourse().getCreditpoints();
			}
		}
	
		return sum/howManyCP;
			
		// The output will be JAVA 6 (4CP) DataStructure 8 (2CP) = ((6 * 4CP) + (8 * 2CP))/ (4CP +2CP) = (24 +16)/6= 40/6 = 6.666
	}
	
	
	 // Function to calculate COurse Average
	public static float calculateAVGInCourse(Course inputCourse) throws Exception {
		if(inputCourse == null) throw new Exception("Problems with input");
		
		
		float sum = 0;
		int howMany = 0;
		
		for(Grade tempGr: allGrades) {
			if(tempGr.getCourse().equals(inputCourse)) {
				sum = sum + tempGr.getValue();
				howMany++;
			}
			
		}
		return sum/howMany;
	}
	
	
	// Function to calculate number of Courses thought by the professors
	public static int calculateHowManyCoursesbyProfessor(Professor inputProfessor) throws Exception {
		if(inputProfessor == null) throw new Exception("Problems with input");
		
		int howMany = 0;
		
		
		for(Course tempCr : allCourses) {
			if(tempCr.getProfessor().equals(inputProfessor)) {
				howMany++;
			}
		}
		
		return howMany;
	}
	
	
	// function to sort a Student offering a course
	/*public static void sortStudent()throws Exception{
		
		for(int i = 0; i < allStudents.size(); i++) {
			for(int j = 0;  j < allStudents.size(); j++) {
				
				Student tempI = allStudents.get(i);
				Student tempJ = allStudents.get(j);
				if(calculateAVGForStudent(tempJ) < calculateAVGForStudent(tempI)) {
					Student temp = allStudents.get(i);
					allStudents.set(i, allStudents.get(j));
					allStudents.set(j,  temp);
				}
			}
				
		}
		
	}
	*/
	
	//TODO
	//Function to Calculate how many Professors have phd as degree
	public static int howManyProfessorsHavePHD() {
		
	
		int howMany = 0;
		for(Person tempP : allPersons) {
			if(tempP instanceof Professor)
			{
				Professor tempPr = (Professor)tempP;
				if(tempPr.getProfDegree().equals(Degree.phd)) {
					howMany++;
				}
			}
			
		}
			
		return howMany;
	}
	
	
	//CRUD C - creates - Retrive, U- update, D - delete
	public static Student retreiveStudentByPersoncode(String personcode)throws Exception{
		
		
		//TODO
		//1. do validation
		if(personcode == null) throw new Exception("Input Error");
		//2. need to go through allStudents list and need to check if this Student is in  the list
		// using for-each loop
		for(Person tempP: allPersons) {
			if(tempP instanceof Student && tempP.getPersoncode().equals(personcode)) {
				//3. if it is need to return this student
				return (Student)tempP;
			}
		}
		// using for loop
		//for (int i = 0; i < allStudents(); i++) {
			//if(allstudents.get(i).getPersoncode.equals.(inputPersoncode))
		//}
		//4.after for loop it is necessary to throw an exception (there is no such student)
		throw new Exception("Sorry student not found");
	}
	public static void createStudent(String inputName, String  inputSurname, String inputPersoncode) throws Exception {
		//TODO Algorithim
		//1. do vaidation
		if(inputName== null || inputSurname == null || inputPersoncode == null) throw new Exception("Wrong input");
		//2. need to go through every student in all the student arraylist
		for(Person tempP: allPersons) {
			//3. need to check if there is already student with thesame persocode
			if(tempP instanceof Student && tempP.getPersoncode().equals(inputPersoncode)) {
				//4. if it is not - throw an exception
				throw new Exception("Error Student already exisits");
			}
			}
		
		//5. if it is not - create a new student
		Student student = new Student (inputName, inputSurname, inputPersoncode);
		allPersons.add(student);
		//6. store this student in allStudents arraylist
		
		}
		
	public static void updateStudentByPersoncode(String Name, String  Surname, String Personcode) throws Exception{
		
	
		// do validation
		if(Name == null || Surname == null || Personcode == null) throw  new Exception("input Error");
		//2. search the student by its personcode
		for(Person tempP: allPersons) {
			if(tempP instanceof Student && tempP.getPersoncode().equals(Personcode)) {
				//3.update name and surname
				tempP.setName(Name);
				tempP.setSurname(Surname);
				return;
			}
			
		}
		//4. throw an exception if there is no student found
		throw new Exception("Student not found");
	}
	public static void deleteStudentbyPersoncode(String personcode)throws Exception {
		if(personcode == null) throw new Exception("imput error");
		// search for students.
		for(Person tempP: allPersons) {
			if(tempP instanceof Student && tempP.getPersoncode().equals(personcode)) {
				allPersons.remove(tempP);
				return;
			}
		}
		throw new Exception("Student not found");
	}
	
}

