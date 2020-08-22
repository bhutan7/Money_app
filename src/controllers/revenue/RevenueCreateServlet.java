package controllers.revenue;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Revenue;
import models.Users;
import models.validators.RevenueValidator;
import utils.DBUtil;

/**
 * Servlet implementation class RevenueCreateServlet
 */
@WebServlet("/revenue/create")
public class RevenueCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RevenueCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String _token = (String)request.getParameter("_token");

        if(_token != null && _token.equals(request.getSession().getId())) {

            EntityManager em = DBUtil.createEntityManager();

            Revenue r = new Revenue();
            r.setUsers((Users)request.getSession().getAttribute("login_users"));

            r.setRevenue_amount(Integer.parseInt(request.getParameter("revenue_amount")));
            r.setCategory(Integer.parseInt(request.getParameter("category")));
            r.setMemo(request.getParameter("memo"));

            Date income_at = new Date(System.currentTimeMillis());

            String pa_str = request.getParameter("income_at");
            if(pa_str != null && !pa_str.equals("")) {
                income_at = Date.valueOf(request.getParameter("income_at"));
            }
            r.setIncome_at(income_at);


            List<String> errors = RevenueValidator.validate(r);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("revenue", r);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/revenues/new.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(r);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                response.sendRedirect(request.getContextPath() + "/revenue/index");
            }
        }
    }
}



