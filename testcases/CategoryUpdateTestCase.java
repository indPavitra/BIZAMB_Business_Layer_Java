import com.thinking.machines.showcase.dl.exceptions.*;
import com.thinking.machines.showcase.dl.pojo.*;
import com.thinking.machines.showcase.dl.*;

public class CategoryUpdateTestCase
{
public static void main(String args[])
{
int code=Integer.parseInt(args[0]);
String title=args[1];

try
{
Category category=new Category();
category.setCode(code);
category.setTitle(title);
CategoryDAO categoryDAO=new CategoryDAO();
categoryDAO.update(category);
System.out.println("**** Category is updated ****");
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}