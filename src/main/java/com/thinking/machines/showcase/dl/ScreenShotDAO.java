package com.thinking.machines.showcase.dl;
import org.hibernate.*;
import java.util.*;
import com.thinking.machines.showcase.dl.pojo.*;
import com.thinking.machines.showcase.dl.util.*;
import com.thinking.machines.showcase.dl.exceptions.*;
public class ScreenShotDAO
{

public void add(ScreenShot screenShot) throws DAOException
{
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
transaction =session.beginTransaction();
session.save(screenShot);
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
}	// end of add function

public void update(ScreenShot screenShot) throws DAOException
{
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
transaction=session.beginTransaction();
session.update(screenShot);
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
ScreenShot screenShot=null;
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
transaction=session.beginTransaction();
screenShot=session.get(ScreenShot.class,code);
if(screenShot!=null) session.delete(screenShot);
transaction.commit();
}catch(Exception exception)
{
if(transaction!=null) transaction.rollback();
exception.printStackTrace();
throw new DAOException(exception.getMessage());
}
}	// end of delete function

public ScreenShot getByCode(Integer code) throws DAOException
{
ScreenShot screenShot=null;
Transaction transaction=null;
try(Session session= HibernateUtil.getSessionFactory().openSession())
{
screenShot=session.get(ScreenShot.class,code);
}catch(Exception exception)
{
exception.printStackTrace();
throw new DAOException(exception.getMessage());
}
if(screenShot==null) throw new DAOException("Invalid code : "+code);
return screenShot;
}	// end of getByCode() function

public List<ScreenShot> getAll()
{
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
return session.createQuery("from ScreenShot s order by s.title",ScreenShot.class).list();
}
}	// end of getAll() function.

}	// end of class ScreenShotDAO 