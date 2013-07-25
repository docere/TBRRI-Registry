package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.MyModule;
import com.example.Person;
import com.example.Project;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class MockTestingModule extends AbstractModule {

	private String projectNames[] ={"Hello World Project", "NLIRI", "Cassandra"};
	
	private String lastNames[] = {"Kim", "Smith", "Turner","Clinton"};
	private String firstNames[] = {"Joe", "John", "Pete","Harry"};
	private String cities[] = {"Thunder Bay", "Toronto", "Little Rock","Hollywood"};
	private String countries[] = {"Canada", "Canada", "USA","USA"};
	
	@Override
	protected void configure() {
		install(new MyModule());
		assert(lastNames.length == firstNames.length);
		assert(lastNames.length == cities.length);
		assert(lastNames.length == countries.length);
	}
	
	
	@Provides Project[] provideProjectList()
	{
		ArrayList<Project> array = new ArrayList<Project>();
		for(String n:projectNames)
		{
			Project p = new Project();
			p.setName("Hello World Project");
			array.add(p);
		}
		
		Project[] a = (Project[]) array.toArray(new Project[array.size()]);
		return a;
	}
	
	@Provides Person[] providePersonList()
	{
	   ArrayList<Person> array = new ArrayList<Person>();
	   for(int i = 0 ; i < lastNames.length; i++)
	   {
		   Person p = new Person();
		   p.setLastName(lastNames[i]);
		   p.setFirstName(firstNames[i]);
		   p.setCity(cities[i]);
		   p.setCountry(countries[i]);
		   array.add(p);
	   }
	   
	   Person[] a = (Person[]) array.toArray(new Person[array.size()]);
	   return a;
	}
	
	
	

}
