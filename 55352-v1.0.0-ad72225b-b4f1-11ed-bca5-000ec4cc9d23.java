/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE497_Information_Leak_of_System_Data__leakPathServlet_01.java
Label Definition File: CWE497_Information_Leak_of_System_Data.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 497 Information Leak
* Sinks: leakPathServlet
*    GoodSink: no leaking
*    BadSink : leak the path variable to the user
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE497_Information_Leak_of_System_Data;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE497_Information_Leak_of_System_Data__leakPathServlet_01 extends AbstractTestCaseServlet
{

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FLAW: system information exposed */
        response.getWriter().println("Not in path: " + System.getenv("PATH"));

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FIX: error message is general */
        response.getWriter().println("Not in path");

    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}

