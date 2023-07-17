import com.thinking.machines.showcase.dl.*;
import com.thinking.machines.showcase.dl.pojo.*;
import com.thinking.machines.showcase.dl.exceptions.*;
import java.util.*;

public class CategoryGetByCodeTestCase
{
public static void main(String args[])
{
int code=Integer.parseInt(args[0]);
try
{
CategoryDAO categoryDAO= new CategoryDAO();
Category category=categoryDAO.getByCode(code);
System.out.println("Category is : "+category.getCode()+" , "+category.getTitle());
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}
