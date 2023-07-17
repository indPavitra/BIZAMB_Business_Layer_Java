import com.thinking.machines.showcase.dl.pojo.*;
import com.thinking.machines.showcase.dl.exceptions.*;
import com.thinking.machines.showcase.dl.*;
import java.util.*;

public class CategoryDeleteTestCase
{
public static void main(String args[])
{
int code =Integer.parseInt(args[0]);
try
{
CategoryDAO categoryDAO= new CategoryDAO();
categoryDAO.delete(code);
System.out.println("************ Category is deleted *************");
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}