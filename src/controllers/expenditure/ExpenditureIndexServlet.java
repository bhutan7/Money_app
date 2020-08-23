package controllers.expenditure;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Expenditure;
import utils.DBUtil;

/**
 * Servlet implementation class ExpenditureIndexServlet
 */
@WebServlet("/expenditure/index")
public class ExpenditureIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpenditureIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        int page = 1;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(NumberFormatException e) { }
        List<Expenditure> expenditures = em.createNamedQuery("getAllExpenditures", Expenditure.class)
                                     .setFirstResult(15 * (page - 1))
                                     .setMaxResults(15)
                                     .getResultList();

        long expenditures_count = (long)em.createNamedQuery("getExpendituresCount", Long.class)
                                       .getSingleResult();

        long total_expenditure = (long)em.createNamedQuery("getTotalExpenditure", Long.class)
                                         .getSingleResult();

        em.close();

        request.setAttribute("expenditures", expenditures);
        request.setAttribute("expenditures_count", expenditures_count);
        request.setAttribute("total_expenditure", total_expenditure);
        request.setAttribute("page", page);
        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/expenditures/index.jsp");
        rd.forward(request, response);
    }

}
