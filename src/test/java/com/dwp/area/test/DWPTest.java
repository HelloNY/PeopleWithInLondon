package com.dwp.area.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dwp.area.PeopleWithinArea;
import com.dwp.area.Person;

public class DWPTest {

		static String url = "https://bpdts-test-app.herokuapp.com/";

	 
	
	@Before
	public void setUpTestData(){
		
		
	}
	
	@Test
    public void testPeopleinLondon() {
         
		  int ExpectedNumberOfPeople = 0;
			 	
		PeopleWithinArea peopleWithinLondon = new PeopleWithinArea ();
		List<Person> actualNumberOfPeople = peopleWithinLondon.getPeopleFromCity(url,"London");
		assertEquals( "Number of people in London", ExpectedNumberOfPeople, actualNumberOfPeople.size() );
	
    }
    
	
	@Test
    public void testTotalNumberofRecords() {
            
		int ExpectedNumberOfPeople = 1000;
			 	
		PeopleWithinArea peopleWithinLondon = new PeopleWithinArea ();
		List<Person> actualNumberOfPeople = peopleWithinLondon.getAllPeople(url);
		assertEquals( "Number of people in DB", ExpectedNumberOfPeople, actualNumberOfPeople.size() );
	
    }
	
	@Test
    public void testgetPersonById() {
            
		String expectedFirsName = "Andrew";
		String expectedLastNam = "Seabrocke";	
		PeopleWithinArea peopleWithinLondon = new PeopleWithinArea ();
		Person p = peopleWithinLondon.getPersonById(url, 520);
		assertEquals( "Failed to return correct firstName", expectedFirsName, p.getFirstName() );
		assertEquals( "Failed to return correct lastName", expectedLastNam, p.getLastName());
		
    }
	
	
}
