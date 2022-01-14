package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import model.User;
import repository.UserDAO;
/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("unused")
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
  
     @Resource(name = "jdbc/ExampleDB")
        private DataSource ds;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getParameter("logout")!= null) {
    	HttpSession session = request.getSession(false); //ei luoda istuntoa, jos sit‰ ei ole ennest‰‰n
    	  if (session != null){
              //jos istunto on ja se halutaan tyhjent‰‰
              session.invalidate();  //lopetetaan istunto
              request.setAttribute("error", "Session has ended.");
          }}
    	request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }
    
    //Pit‰‰ hakea userdao k‰ytt‰j‰n salasana!!
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
        String username = request.getParameter("loginuser");
        String password = request.getParameter("loginpass");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
        UserDAO userdao = new UserDAO(ds);
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            request.setAttribute("error", "Fill in all fields!");
        }else {
            User user = userdao.getUser(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {    
            System.out.println("Login succesfull!");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("Gameshop"); // lis‰ys onnistui, menn‰‰n alkuun
            return;
        }else  {
            request.setAttribute("error", "Passwords have to match!");
        }
        }
        } catch (SQLException e) {
            request.setAttribute("error", "Problems. Try again later.");
            e.printStackTrace();
        } catch (Exception e2) {
            request.setAttribute("error", "Check the fields again!");
        }
    
         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            rd.forward(request, response);
    }

}