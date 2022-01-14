package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Game;
import repository.GameDAO;

/**
 * Gameshop home page
 */
@WebServlet("/Gameshop")
public class GameshopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
      
    @Resource(name="jdbc/ExampleDB")
    private DataSource ds;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            GameDAO gamedao = new GameDAO(ds);
            List<Game> games = gamedao.getGames();
            request.setAttribute("games", games);
            if (request.getParameter("choice") != null) {
                int gameid = Integer.parseInt(request.getParameter("choice"));
                Game agame = gamedao.getGame(gameid);
                request.setAttribute("agame", agame);									
            }
        } catch (SQLException e) {
            request.setAttribute("error", "Problems. Try again later.");
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/games.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        
    }
}