package model;

public class Professor extends Person {
	 //1 Variables  
	private long pID;
	
	private Degree profDegree;
	
	
	private static long counter = 0;
	
	//2. set and get
	public long getpID() {
		return pID;
	}
	public void setpID()  {
 		this.pID = counter;
 		counter++;
	}
	
	public Degree getProfDegree() {
		return profDegree;
	}
	public void setProfDegree(Degree profDegree) {
		if( profDegree != null)
			this.profDegree = profDegree;
		else
			this.profDegree = Degree.other;
	}
	
	
	
	
	
	//3.constructors
	public Professor() {
		super(); // person() is called
		setpID();
		
		setProfDegree(Degree.other);
	}
	
	public Professor(String name, String surname,String personcode, Degree profDegree) {
		super(name, surname, personcode);
		setpID();
		
		setProfDegree(profDegree);
	}
	

	//4. toString
	@Override
	public String toString()
	{
		return pID + ": " + super.toString() + "(" + profDegree + ")";
	}
	

}
