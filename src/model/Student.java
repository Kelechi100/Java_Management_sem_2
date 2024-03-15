package model;

public class Student extends Person{
	//1 Variables  
		private long sID;
		
		
		private static long counter = 1000;
		
		//2. set and getters
		public long getpID() {
			return sID;
		}
		public void setsID()  {
	 		this.sID = counter;
	 		counter++;
		}
		
		//Constructors
		public Student() {  // default constructor
			super();// person() constructor will be called
			setsID();
			
		
		}
		// parameter constructor
		public Student(String name, String surname, String personcode ){
			super(name , surname, personcode); // person() constructor will be called
			setsID();
			
			
		}
		

		//4. toString
		@Override
		public String toString()
		{
			return sID + ": " + super.toString();
		}
		

}
