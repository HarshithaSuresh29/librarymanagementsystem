import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String t = req.getParameter("title");
        String a = req.getParameter("author");
        int q = Integer.parseInt(req.getParameter("quantity"));

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO books(title,author,quantity) VALUES(?,?,?)"
            );
            ps.setString(1, t);
            ps.setString(2, a);
            ps.setInt(3, q);

            ps.executeUpdate();
            res.sendRedirect("admin_dashboard.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
