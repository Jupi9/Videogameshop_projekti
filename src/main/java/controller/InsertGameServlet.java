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

import model.Game;
import repository.GameDAO;

/**
 * Servlet implementation class InsertGameServlet
 */
@WebServlet("/InsertGame")
public class InsertGameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/ExampleDB")
    private DataSource ds;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/insertgame.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            GameDAO gamedao = new GameDAO(ds);
            String gamename = request.getParameter("gamename");
            String sprice = request.getParameter("price"); // merkkijonona viel‰
            String scategory = request.getParameter("category");
            String sage = request.getParameter("age");
            String sgamepic = request.getParameter("gamepic");
            if (gamename.trim().isEmpty() || sprice.trim().isEmpty() || scategory.trim().isEmpty() || sage.trim().isEmpty()) {
                request.setAttribute("error", "Fill in all fields!");
            } else {
                sprice = sprice.replace(',', '.'); //jos desimaalipilkku, korvataan pisteell‰
                BigDecimal price = new BigDecimal(sprice);
                String category = new String(scategory);
                BigDecimal age = new BigDecimal(sage);
                String gamepic = new String(sgamepic);
                Game agame = new Game(0, gamename, category, age, price, gamepic);
                gamedao.insertGame(agame);
                response.sendRedirect("Gameshop"); // lis‰ys onnistui, menn‰‰n alkuun
                return;
            }
        } catch (SQLException e) {
            request.setAttribute("error", "Problems. Try again later.");
            e.printStackTrace();
        } catch (Exception e2) {
            request.setAttribute("error", "Check price and category!");
        }

        // t‰nne tullaan jos ongelmia
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/insertgame.jsp");
        rd.forward(request, response);
    }
}