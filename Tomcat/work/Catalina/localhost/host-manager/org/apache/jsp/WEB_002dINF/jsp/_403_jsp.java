/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.55
 * Generated at: 2014-09-29 17:11:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _403_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n");
      out.write("<html>\n");
      out.write(" <head>\n");
      out.write("  <title>403 Access Denied</title>\n");
      out.write("  <style type=\"text/css\">\n");
      out.write("    <!--\n");
      out.write("    BODY {font-family:Tahoma,Arial,sans-serif;color:black;background-color:white;font-size:12px;}\n");
      out.write("    H1 {font-family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;font-size:22px;}\n");
      out.write("    PRE, TT {border: 1px dotted #525D76}\n");
      out.write("    A {color : black;}A.name {color : black;}\n");
      out.write("    -->\n");
      out.write("  </style>\n");
      out.write(" </head>\n");
      out.write(" <body>\n");
      out.write("   <h1>403 Access Denied</h1>\n");
      out.write("   <p>\n");
      out.write("    You are not authorized to view this page.\n");
      out.write("   </p>\n");
      out.write("   <p>\n");
      out.write("    If you have already configured the Host Manager application to allow access\n");
      out.write("    and you have used your browsers back button, used a saved book-mark or\n");
      out.write("    similar then you may have triggered the cross-site request forgery (CSRF)\n");
      out.write("    protection that has been enabled for the HTML interface of the Host Manager\n");
      out.write("    application. You will need to reset this protection by returning to the\n");
      out.write("    <a href=\"");
      out.print(request.getContextPath());
      out.write("/html\">main Host Manager page</a>.\n");
      out.write("    Once you return to this page, you will be able to continue using the Host\n");
      out.write("    Manager appliction's HTML interface normally. If you continue to see this\n");
      out.write("    access denied message, check that you have the necessary permissions to\n");
      out.write("    access this application.\n");
      out.write("   </p>\n");
      out.write("   <p> If you have not changed\n");
      out.write("    any configuration files, please examine the file\n");
      out.write("    <tt>conf/tomcat-users.xml</tt> in your installation. That\n");
      out.write("    file must contain the credentials to let you use this webapp.\n");
      out.write("   </p>\n");
      out.write("   <p>\n");
      out.write("    For example, to add the <tt>admin-gui</tt> role to a user named\n");
      out.write("    <tt>tomcat</tt> with a password of <tt>s3cret</tt>, add the following to the\n");
      out.write("    config file listed above.\n");
      out.write("   </p>\n");
      out.write("<pre>\n");
      out.write("&lt;role rolename=\"admin-gui\"/&gt;\n");
      out.write("&lt;user username=\"tomcat\" password=\"s3cret\" roles=\"admin-gui\"/&gt;\n");
      out.write("</pre>\n");
      out.write("   <p>\n");
      out.write("    Note that for Tomcat 7 onwards, the roles required to use the host manager\n");
      out.write("    application were changed from the single <tt>admin</tt> role to the\n");
      out.write("    following two roles. You will need to assign the role(s) required for\n");
      out.write("    the functionality you wish to access.\n");
      out.write("   </p>\n");
      out.write("    <ul>\n");
      out.write("      <li><tt>admin-gui</tt> - allows access to the HTML GUI</li>\n");
      out.write("      <li><tt>admin-script</tt> - allows access to the text interface</li>\n");
      out.write("    </ul>\n");
      out.write("   <p>\n");
      out.write("    The HTML interface is protected against CSRF but the text interface is not.\n");
      out.write("    To maintain the CSRF protection:\n");
      out.write("   </p>\n");
      out.write("   <ul>\n");
      out.write("    <li>Users with the <tt>admin-gui</tt> role should not be granted the\n");
      out.write("       <tt>admin-script</tt> role.</li>\n");
      out.write("    <li>If the text interface is accessed through a browser (e.g. for testing\n");
      out.write("        since this interface is intended for tools not humans) then the browser\n");
      out.write("        must be closed afterwards to terminate the session.</li>\n");
      out.write("   </ul>\n");
      out.write(" </body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
