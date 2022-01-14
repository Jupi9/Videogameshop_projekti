package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import model.User;

import repository.UserDAO;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Resource(name = "jdbc/ExampleDB")
	 private DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       request.setCharacterEncoding("UTF-8");
       try {
           UserDAO userdao = new UserDAO(ds);
           String username = request.getParameter("username");
           String name = request.getParameter("name");
           String password = request.getParameter("password");
           String password2 = request.getParameter("password2");
           BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
           String encrypted = passwordEncoder.encode(password); 
           if (username.trim().isEmpty() || name.trim().isEmpty() || password.trim().isEmpty() ||
        		   password2.trim().isEmpty()) {
               request.setAttribute("error", "Fill in all fields!");
           } else if (!(password.equals(password2))) {
        	   request.setAttribute("error", "Passwords have to match!");
           }else if(userdao.getUser(username) != null) {
        	   request.setAttribute("error", "Username already exists!");
           }else {
        	   User user = new User(username, name, encrypted, true, "ROLE_USER");
        	   userdao.insertUser(user);
        	   System.out.println("Registaration successfull");
               response.sendRedirect("Gameshop"); // lis‰ys onnistui, menn‰‰n alkuun
               return;
           }
        	   
           
       } catch (SQLException e) {
           request.setAttribute("error", "Problems. Try again later.");
           e.printStackTrace();
       } catch (Exception e2) {
           request.setAttribute("error", "Check inputs!");
       }

       // t‰nne tullaan jos ongelmia
       RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
       rd.forward(request, response);
   }

}


