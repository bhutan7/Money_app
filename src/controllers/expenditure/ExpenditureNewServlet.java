package controllers.expenditure;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Expenditure;

/**
 * Servlet implementation class ExpenditureNewServlet
 */
@WebServlet("/expenditure/new")
public class ExpenditureNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpenditureNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setAttribute("_token", request.getSession().getId());

        Expenditure e = new Expenditure();
        e.setPurchase_at(new Date(System.currentTimeMillis()));
        request.setAttribute("expenditure", e);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/expenditures/new.jsp");
        rd.forward(request, response);

}
}