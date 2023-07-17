import com.thinking.machines.showcase.dl.*;
import com.thinking.machines.showcase.dl.pojo.*;
import com.thinking.machines.showcase.dl.exceptions.*;

public class CategoryAddTestCase
{
public static void main(String args[])
{
String title=args[0];
try
{
Category category= new Category();
category.setTitle(title);
CategoryDAO categoryDAO=new CategoryDAO();
categoryDAO.add(category);
System.out.println("Category added with title :"+category.getTitle());
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}