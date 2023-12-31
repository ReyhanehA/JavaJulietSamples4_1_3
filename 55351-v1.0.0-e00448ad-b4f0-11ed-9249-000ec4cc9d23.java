/*
 * @description An object implements a clone method without declaring it final, allowing the
 * possibility of an object hijack in a subclass.
 *  
 * This class contains the "good" version of clone().  There is no need to implement
 * the bad() and good() methods in this test case.
 * 
 * */

package testcases.CWE491_Object_Hijack;

import testcasesupport.*;
import java.util.Date;

public class CWE491_Object_Hijack__basic_01_good1 extends AbstractTestCaseClassIssueGood implements Cloneable 
{
    
	/* Just to have something to do in clone() other than return super.clone() */
	private Date testdate = new Date();
	
	/* FIX: clone() method declared final */
	protected final Object clone() throws CloneNotSupportedException 
    {
        CWE491_Object_Hijack__basic_01_good1 obj = (CWE491_Object_Hijack__basic_01_good1) super.clone();	 
        obj.setDate(new Date(testdate.getTime()));
        return obj;
	}
	
	public void setDate(Date d) 
    {
		testdate = d;
	}
	
	private void good1() { }
	
	public void good() 
    { 
        good1();
	}
		
	/* Below is the main(). It is only used when building this testcase on 
	   its own for testing or for building a binary to use in testing binary 
	   analysis tools. It is not used when compiling all the testcases as one 
	   application, which is how source code analysis tools are tested. */ 
	public static void main(String[] args) 
		throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		mainFromParent(args);
	}

}
