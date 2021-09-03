package servlet;

import entry.User;
import jdbc.JDBCDemo2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user_login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String r_user_name = req.getParameter("r_user_name");
        String r_password = req.getParameter("r_password");
        String r_emial = req.getParameter("r_emial");
        String user_name = req.getParameter("user_name");
        String password = req.getParameter("password");
        JDBCDemo2 jdbcDemo2 = new JDBCDemo2();
        User user = jdbcDemo2.selectByUsername(user_name);
        int result = 0;
        if (user == null){
            result = -1;
        }else {
            if(user.getPassword().equals(password)){
                result = 1;
            }
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(result);
        printWriter.flush();



    }
}
