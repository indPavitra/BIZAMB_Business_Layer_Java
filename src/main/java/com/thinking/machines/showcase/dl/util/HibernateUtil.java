package com.thinking.machines.showcase.dl.util;
import java.util.*;
import org.hibernate.*;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import com.thinking.machines.showcase.dl.pojo.*;
public class HibernateUtil
{
private static SessionFactory sessionFactory;
public static SessionFactory getSessionFactory()
{
if(sessionFactory==null)
{
try
{
Configuration configuration;
configuration=new Configuration();
Properties settings = new Properties();
settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
settings.put(Environment.URL, "jdbc:mysql://localhost:3306/showcasedb?useSSL=false");
settings.put(Environment.USER, "showcase");
settings.put(Environment.PASS, "thinkingmachines");
settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
settings.put(Environment.SHOW_SQL, "true");
settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
configuration.setProperties(settings);
configuration.addAnnotatedClass(Category.class);
configuration.addAnnotatedClass(Project.class);
configuration.addAnnotatedClass(ScreenShot.class);
configuration.addAnnotatedClass(Video.class);
ServiceRegistry serviceRegistry=new
StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
sessionFactory=configuration.buildSessionFactory(serviceRegistry);
}catch(Exception e)
{
e.printStackTrace();
}
}
return sessionFactory;
}
}