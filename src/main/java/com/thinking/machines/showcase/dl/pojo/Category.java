package com.thinking.machines.showcase.dl.pojo;
import java.util.*;
import javax.persistence.*;
@Entity
@Table(name="category")
public class Category implements java.io.Serializable
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="code")
private Integer code;
@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
private Collection<Project> projects;
@Column(name="title",unique=true,nullable=false)
private String title;
public Category()
{ 
this.code=0;
this.title=null;
this.projects=null;
}
public void setCode(Integer code)
{ 
this.code=code;
}
public Integer getCode()
{
return this.code;
}
public void setTitle(String title)
{
this.title=title;
}
public String getTitle()
{
return this.title;
}
public void setProjects(Collection<Project> projects)
{
this.projects=projects;
}
public Collection<Project> getProjects()
{
return this.projects;
}
}