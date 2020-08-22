package controllers.expenditure;

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

import models.Expenditure;
import models.Users;
import models.validators.ExpenditureValidator;
import utils.DBUtil;

/**
 * Servlet implementation class ExpendituresCreateServlet
 */
@WebServlet("/expenditure/create")
public class ExpendituresCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpendituresCreateServlet() {
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

            Expenditure e = new Expenditure();
            e.setUsers((Users)request.getSession().getAttribute("login_users"));

            e.setPurchase_amount(Integer.parseInt(request.getParameter("purchase_amount")));
            e.setCategory(Integer.parseInt(request.getParameter("category")));
            e.setMemo(request.getParameter("memo"));

            Date purchase_at = new Date(System.currentTimeMillis());

            String pa_str = request.getParameter("purchase_at");
            if(pa_str != null && !pa_str.equals("")) {
                purchase_at = Date.valueOf(request.getParameter("purchase_at"));
            }
            e.setPurchase_at(purchase_at);


            List<String> errors = ExpenditureValidator.validate(e);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("expenditure", e);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/expenditures/new.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(e);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                response.sendRedirect(request.getContextPath() + "/expenditure/index");
            }
        }
    }
}


