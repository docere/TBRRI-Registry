package com.example;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
@NamedQueries({
	@NamedQuery(name = ProjectPersonAssociation.FIND_ALL_PROJECT_PERSON_ASSOCIATIONS, query = "SELECT p FROM ProjectPersonAssociation p")
})

@Entity
@IdClass(ProjectPersonAssociationId.class)
public class ProjectPersonAssociation {
	
	public final static String FIND_ALL_PROJECT_PERSON_ASSOCIATIONS ="ProjectPersonAssociation.findAll";
	
	@Id
	private long projectid;
	
	@Id
	private long personid;

	@Enumerated(EnumType.STRING)
	RoleType roleType;
	
	@Basic
	String notes;

	


	@ManyToOne
	@PrimaryKeyJoinColumn(name="Projectid",referencedColumnName="id")
	private Project project;
	
	


	@ManyToOne
	@PrimaryKeyJoinColumn(name = "Personid",referencedColumnName="id")
	private Person person;



	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
		this.projectid = project.getId();
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
		this.personid = person.getId();
	}


	
	
	


	public RoleType getRoleType() {
		return roleType;
	}


	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}

	

}
