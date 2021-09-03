package servlet;

import entry.Admin;
import jdbc.DBTools;
import jdbc.JDBCDemo2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/***
 *
 */
@WebServlet("/admin_login")
public class AdminLoginServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        JDBCDemo2 jdbcDemo2 = new JDBCDemo2();
//        jdbcDemo2.select(1,name);
//        System.out.println(name+"==="+password);
        String sql = "select * from admin where username=?";
        Admin admin = DBTools.queryOne(Admin.class,sql,name);
//        System.out.println(admin.getUsername()+admin.getPassword());
        int result = 0;
        if (admin == null){
            result = -1;
        }else {
            if(admin.getPassword().equals(password)){
                    result = 1;
            }
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(result);
        printWriter.flush();

    }
}
