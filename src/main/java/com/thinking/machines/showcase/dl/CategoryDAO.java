package com.thinking.machines.showcase.dl;
import org.hibernate.*;
import java.util.*;
import com.thinking.machines.showcase.dl.pojo.*;
import com.thinking.machines.showcase.dl.util.*;
import com.thinking.machines.showcase.dl.exceptions.*;

public class CategoryDAO
{
public void add(Category category) throws DAOException
{
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
transaction=session.beginTransaction();
session.save(category);
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
}	// end of add function.

public void update(Category category) throws DAOException
{
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
transaction = session.beginTransaction();
session.update(category);
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
}	// update function ends here

public void delete(Integer code) throws DAOException
{
Category category=null;
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
transaction=session.beginTransaction();
category=session.get(Category.class,code);
if(category!=null) session.delete(category);
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
if(category==null) throw new DAOException("Invalid code : "+code);
}	// delete function ends here

public Category getByCode(Integer code) throws DAOException
{
Category category=null;
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
category=session.get(Category.class,code);
}catch(Exception exception)
{
exception.printStackTrace();
throw new DAOException(exception.getMessage());
}
if(category==null) throw new DAOException("Invalid code : "+code);
return category;
}	// end of getByCode function

public List<Category> getAll()
{
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
return session.createQuery("from Category c order by c.title",Category.class).list();
}
}	// end of getAll() function
}