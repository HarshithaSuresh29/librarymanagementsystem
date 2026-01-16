import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String u = req.getParameter("username");
        String p = req.getParameter("password");

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(username,password,role) VALUES(?,?,?)"
            );
            ps.setString(1, u);
            ps.setString(2, p);
            ps.setString(3, "user");

            ps.executeUpdate();
            res.sendRedirect("login.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
