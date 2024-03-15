package model;

public class Person {//1. varaibles
	private String name;
	private String surname;
	private String personcode;
	
	//2. get and set
	public String getPersoncode() {
		return personcode;
	}
	public void setPersoncode(String personcode) {
		if(personcode != null && personcode.matches("[0-9]{6}-[0-9]{5}"))
			this.personcode = personcode;
		else
			this.personcode = "undefined";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name != null && name.matches("[A-Z]{1}[a-z]{1,20}"))
			this.name = name;
		else
			this.name = "Undifinied";
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		if(name != null && name.matches("[A-Z]{1}[a-z]{1,20}"))
			this.surname = surname;
		else
			this.name = "Undifinied";
	}
	//3.constructor
	public Person() {
		setName("John");
		setSurname("Smith");
		setPersoncode("234562-34567");
	}
	public Person(String name, String surname, String personcode ){
		setName(name);
		setSurname(surname);
		setPersoncode(personcode);
	}
	//4.to String
		public String toString()
		{
			return  name + " " + surname + "[" + personcode + "]";
		}
	//5.other function

}
