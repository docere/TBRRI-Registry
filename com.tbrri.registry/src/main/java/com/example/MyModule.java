package com.example;

import com.example.dao.DaoPerson;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
public class MyModule extends AbstractModule {

	@Override
	protected void configure() {
		install(new JpaPersistModule("home"));
		
		//although explicit binding to classes is not necessary, because bindings become "just in time",
		//there may be an performance improvement by making bindings explicit 
		bind(Person.class);
		bind(DaoPerson.class);
		
	}
	
	public static void main(String[] args) {
		Injector i = Guice.createInjector(new MyModule());
		PersistService service = i.getInstance(PersistService.class);
		service.start();
		Person person = i.getInstance(Person.class);
		DaoPerson dao = i.getInstance(DaoPerson.class);
		person.lastName = "hey";
		dao.save(person);
//		dao.delete(person);
		
		System.out.println("completed");
		
		
	}
}
