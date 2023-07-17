package com.thinking.machines.showcase.dl;
import org.hibernate.*;
import java.util.*;
import com.thinking.machines.showcase.dl.pojo.*;
import com.thinking.machines.showcase.dl.util.*;
import com.thinking.machines.showcase.dl.exceptions.*;
public class VideoDAO
{

public void add(Video video) throws DAOException
{
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
transaction =session.beginTransaction();
session.save(video);
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

public void update(Video video) throws DAOException
{
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
transaction=session.beginTransaction();
session.update(video);
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
Video video=null;
Transaction transaction=null;
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
transaction=session.beginTransaction();
video=session.get(Video.class,code);
if(video!=null) session.delete(video);
transaction.commit();
}catch(Exception exception)
{
if(transaction!=null) transaction.rollback();
exception.printStackTrace();
throw new DAOException(exception.getMessage());
}
}	// end of delete function

public Video getByCode(Integer code) throws DAOException
{
Video video=null;
Transaction transaction=null;
try(Session session= HibernateUtil.getSessionFactory().openSession())
{
video=session.get(Video.class,code);
}catch(Exception exception)
{
exception.printStackTrace();
throw new DAOException(exception.getMessage());
}
if(video==null) throw new DAOException("Invalid code : "+code);
return video;
}	// end of getByCode() function

public List<Video> getAll()
{
try(Session session=HibernateUtil.getSessionFactory().openSession())
{
return session.createQuery("from Video s order by s.title",Video.class).list();
}
}	// end of getAll() function.

}	// end of class VideoDAO 