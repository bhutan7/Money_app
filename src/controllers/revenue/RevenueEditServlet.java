package controllers.revenue;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Revenue;
import models.Users;
import utils.DBUtil;

/**
 * Servlet implementation class RevenueEditServlet
 */
@WebServlet("/revenue/edit")
public class RevenueEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevenueEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();

        Revenue r = em.find(Revenue.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        Users login_users = (Users)request.getSession().getAttribute("login_users");
        if(r != null && login_users.getId() == r.getUsers().getId()) {
            request.setAttribute("revenue", r);
            request.setAttribute("_token", request.getSession().getId());
            request.getSession().setAttribute("user_id", r.getId());
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/revenues/edit.jsp");
        rd.forward(request, response);
    }

}