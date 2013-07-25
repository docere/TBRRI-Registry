package com.example;

import java.io.Serializable;

public class ProjectPersonAssociationId implements Serializable{
  

	private long projectid;
  

	private long personid;
    
	
	public ProjectPersonAssociationId()
	{
		
	}
	
	public ProjectPersonAssociationId(long _projectid, long _personid)
	{
		this.personid = _personid;
		this.projectid = _projectid;
	}
	
	public long getPersonid() {
		return personid;
	}

	public void setPersonid(long personid) {
		this.personid = personid;
	}

	public long getProjectid() {
		return projectid; 	
	}
	
	public void setProjectid(long projectid) {
		this.projectid = projectid;
	}
	
	
	public int hashCode()
    {
    	return (int)(projectid + personid);
    }
    
    public boolean equals(Object object)
    {
    	boolean result = false;
    	
    	if(object instanceof ProjectPersonAssociationId)
    	{
    		ProjectPersonAssociationId otherid = (ProjectPersonAssociationId) object;
    		result = ((otherid.projectid == this.projectid) && (otherid.personid == this.personid));
    	}
    	
		return result;
    }
  
  
}
