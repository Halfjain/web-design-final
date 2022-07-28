package Servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "datasvingServlet", value = "/datasvingServlet")
public class datasvingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String expName = request.getParameter("expName");
        String expCategory = request.getParameter("expCategory");
        String expAmount = request.getParameter("expAmount");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/3306/money", "root","NOMI11ty");

            String sql = "INSERT INTO expenses_table(expName, expCategory, expAmount) VALUES ('" + expName + "','"+ expCategory +"','"+expAmount +"')";
            PreparedStatement prep = con.prepareStatement(sql);

            prep.setString(1, expName);
            prep.setString(2, expCategory);
            prep.setString(3, expAmount);
            prep.executeUpdate();
            prep.close();

            System.out.println("Debug: data inserted!");
        } catch (Exception E) {
            System.out.println("The error is an error");
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("analysis.jsp");
        requestDispatcher.forward(request, response);

    }
}
