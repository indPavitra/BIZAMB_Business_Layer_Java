package com.thinking.machines.showcase.dl.pojo;
import javax.persistence.*;
@Entity
@Table(name="screen_shot")
public class ScreenShot implements java.io.Serializable
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="code")
private Integer code;
@ManyToOne
@JoinColumn(name="project_code")
private Project project;
@Column(name="serial_number",nullable=false)
private Integer serialNumber;
@Column(name="title",nullable=false)
private String title;
@Column(name="file",nullable=false,unique=true)
private String file;
@Column(name="note",nullable=false)
private String note;
public ScreenShot()
{
this.code=0;
this.project=null;
this.serialNumber=0;
this.title=null;
this.file=null;
this.note=null;
}
public void setCode(Integer code)
{
this.code = code;
}
public Integer getCode()
{
return this.code;
}
public void setProject(Project project)
{
this.project = project;
}
public Project getProject()
{
return this.project;
}
public void setSerialNumber(Integer serialNumber)
{
this.serialNumber = serialNumber;
}
public Integer getSerialNumber()
{
return this.serialNumber;
}
public void setTitle(String title)
{
this.title = title;
}
public String getTitle()
{
return this.title;
}
public void setFile(String file)
{
this.file = file;
}
public String getFile()
{
return this.file;
}
public void setNote(String note)
{
this.note = note;
}
public String getNote()
{
return this.note;
}
}