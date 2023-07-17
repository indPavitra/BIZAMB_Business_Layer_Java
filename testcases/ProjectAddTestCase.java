import com.thinking.machines.showcase.dl.pojo.*;
import com.thinking.machines.showcase.dl.exceptions.*;
import com.thinking.machines.showcase.dl.*;

public class ProjectAddTestCase
{
public static void main(String args[])
{
Integer categoryCode=Integer.parseInt(args[0]);
String title=args[1];
String domain=args[2];
String synopsis=args[3];
String technologies=args[4];

try
{
CategoryDAO categoryDAO= new CategoryDAO();
Category category=categoryDAO.getByCode(categoryCode);
Project project= new Project();
project.setCategory(category);
project.setTitle(title);
project.setDomain(domain);
project.setSynopsis(synopsis);
project.setTechnologies(technologies);
ProjectDAO projectDAO= new ProjectDAO();
projectDAO.add(project);
System.out.println("Project added with code as : "+project.getCode());
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}