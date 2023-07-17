import com.thinking.machines.showcase.dl.pojo.*;
import com.thinking.machines.showcase.dl.exceptions.*;
import com.thinking.machines.showcase.dl.*;
import java.util.*;

public class CategoryListTestCase
{
public static void main(String args[])
{
Collection<Project> projects=null;
List<Category> categories= new CategoryDAO().getAll();
/*categories.forEach((category)->{
System.out.println(category.getCode()+" , "+category.getTitle());
projects=category.getProjects();
for(Project p:projects)
{
System.out.println(p.getTitle());
}
});*/

for(Category category:categories)
{
System.out.println(category.getCode()+" , "+category.getTitle());
projects=category.getProjects();
for(Project p:projects)
{
System.out.println(p.getTitle());
}
}

}
}
