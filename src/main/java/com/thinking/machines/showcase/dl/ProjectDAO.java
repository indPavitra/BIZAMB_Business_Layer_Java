package com.thinking.machines.showcase.dl;
import org.hibernate.*;
import java.util.*;
import com.thinking.machines.showcase.dl.pojo.*;
import com.thinking.machines.showcase.dl.util.*;
import com.thinking.machines.showcase.dl.exceptions.*;
public class ProjectDAO
{

public void add(Project project) throws DAOException
{
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
transaction=session.beginTransaction();
session.save(project);
transaction.commit();
}catch(Exception exception)
{
if(transaction!=null)
{
transaction.rollback();
}
exception.printStackTrace();
throw new DAOException(exception.getMessage());
}
}	// end of add()

public void update(Project project) throws DAOException
{
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
transaction=session.beginTransaction();
session.update(project);
transaction.commit();
}catch(Exception exception)
{
if(transaction!=null)
{
transaction.rollback();
}
exception.printStackTrace();
throw new DAOException(exception.getMessage());
}
}	// end of update() function

public void delete(Integer code) throws DAOException
{
Project project=null;
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
transaction=session.beginTransaction();
project=session.get(Project.class,code);
if(project!=null) session.delete(project);
transaction.commit();
}catch(Exception exception)
{
if(transaction!=null)
{
transaction.rollback();
}
exception.printStackTrace();
throw new DAOException(exception.getMessage());
}
if(project==null) throw new DAOException("Invalid code :"+code);
}	// end of delete() function

public Project getByCode(Integer code) throws DAOException
{
Project project=null;
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
project=session.get(Project.class,code);
}catch(Exception exception)
{
exception.printStackTrace();
throw new DAOException(exception.getMessage());
}
if(project==null) throw new DAOException("Invalid code :"+code);
return project;
}	// end of getByCode() function

public List<Project> getAll()
{
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
return session.createQuery("from Project p order by p.title",Project.class).list();
}
}	// end of getAll()
}