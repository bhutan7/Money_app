package controllers.revenue;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Revenue;
import utils.DBUtil;

/**
 * Servlet implementation class RevenueIndexServlet
 */
@WebServlet("/revenue/index")
public class RevenueIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevenueIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        int page;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }
        List<Revenue> revenue = em.createNamedQuery("getAllRevenues", Revenue.class)
                                  .setFirstResult(15 * (page - 1))
                                  .setMaxResults(15)
                                  .getResultList();

        long revenue_count = (long)em.createNamedQuery("getRevenuesCount", Long.class)
                                     .getSingleResult();
        long total_revenue = (long)em.createNamedQuery("getTotalRevenue", Long.class)
                                     .getSingleResult();

        em.close();

        request.setAttribute("revenue", revenue);
        request.setAttribute("revenue_count", revenue_count);
        request.setAttribute("total_revenue", total_revenue);
        request.setAttribute("page", page);
        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/revenues/index.jsp");
        rd.forward(request, response);
    }

}