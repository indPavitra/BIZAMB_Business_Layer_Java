package com.thinking.machines.showcase.dl.pojo;
import javax.persistence.*;
@Entity
@Table(name="project")
public class Project implements java.io.Serializable
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="code")
private Integer code;
@Column(name="title",unique=true,nullable=false)
private String title;
@ManyToOne
@JoinColumn(name="category_code")
private Category category;
@Column(name="domain",unique=true,nullable=false)
private String domain;
@Column(name="synopsis",unique=true,nullable=false)
private String synopsis;
@Column(name="technologies",unique=true,nullable=false)
private String technologies;
public Project()
{
this.code=0;
this.title=null;
this.category=null;
this.domain=null;
this.synopsis=null;
this.technologies=null;
}
public void setCode(Integer code)
{
this.code = code;
}
public Integer getCode()
{
return this.code;
}
public void setTitle(String title)
{
this.title = title;
}
public String getTitle()
{
return this.title;
}
public void setCategory(Category category)
{
this.category = category;
}
public Category getCategory()
{
return this.category;
}
public void setDomain(String domain)
{
this.domain = domain;
}
public String getDomain()
{
return this.domain;
}
public void setSynopsis(String synopsis)
{
this.synopsis = synopsis;
}
public String getSynopsis()
{
return this.synopsis;
}
public void setTechnologies(String technologies)
{
this.technologies = technologies;
}
public String getTechnologies()
{
return this.technologies;
}
}