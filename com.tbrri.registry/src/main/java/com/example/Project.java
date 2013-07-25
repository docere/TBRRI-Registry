package com.example;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@NamedQueries({
	@NamedQuery(name = Project.FIND_ALL_PROJECTS, query = "SELECT p FROM Project p")
})

@Entity
public class Project {
	
	public final static String FIND_ALL_PROJECTS = "find_all_projects";
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Basic
	private String name;
	

	@OneToMany(mappedBy="project")
	private List<ProjectPersonAssociation> projectAssociation;



	public List<ProjectPersonAssociation> getProjectAssociation() {
		return projectAssociation;
	}

	public void setProjectAssociation(
			List<ProjectPersonAssociation> projectAssociation) {
		this.projectAssociation = projectAssociation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
