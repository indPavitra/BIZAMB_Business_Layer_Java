import com.thinking.machines.showcase.dl.*;
import com.thinking.machines.showcase.dl.pojo.*;
import com.thinking.machines.showcase.dl.exceptions.*;
import java.util.*;
public class ProjectListTestCase
{
public static void main(String args[])
{
List<Project> categories= new ProjectDAO().getAll();
categories.forEach((project)->{
System.out.println(project.getCode()+" , "+project.getTitle()+" , "+project.getCategory().getCode()+" , "+project.getCategory().getTitle()+" , "+project.getDomain()+" , "+project.getSynopsis()+" , "+project.getTechnologies());
});
}
}