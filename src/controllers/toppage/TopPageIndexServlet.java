package controllers.toppage;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBUtil;

/**
 * Servlet implementation class TopPageIndexServlet
 */
@WebServlet("/index.html")
public class TopPageIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopPageIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            EntityManager em = DBUtil.createEntityManager();

            long total_expenditure = (long)em.createNamedQuery("getTotalExpenditure", Long.class)
                    .getSingleResult();

            long total_revenue = (long)em.createNamedQuery("getTotalRevenue", Long.class)
                    .getSingleResult();
            em.close();

            request.setAttribute("total_expenditure", total_expenditure);
            request.setAttribute("total_revenue", total_revenue);

            if(request.getSession().getAttribute("flush") != null) {
                request.setAttribute("flush", request.getSession().getAttribute("flush"));
                request.getSession().removeAttribute("flush");

        }

        RequestDispatcher rd =  request.getRequestDispatcher("/WEB-INF/views/topPage/index.jsp");
        rd.forward(request,response);
    }

}
