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
import models.validators.ExpenditureValidator;
import utils.DBUtil;

/**
 * Servlet implementation class ExpenditureUpdateServlet
 */
@WebServlet("/expenditure/update")
public class ExpenditureUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpenditureUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Expenditure e = em.find(Expenditure.class, (Integer)(request.getSession().getAttribute("user_id")));

            e.setPurchase_at(Date.valueOf(request.getParameter("purchase_at")));
            e.setMemo(request.getParameter("memo"));
            e.setPurchase_amount(Integer.parseInt(request.getParameter("purchase_amount")));


            List<String> errors = ExpenditureValidator.validate(e);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("expenditure", e);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/expenditures/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                request.getSession().removeAttribute("user_id");

                response.sendRedirect(request.getContextPath() + "/expenditure/index");
            }
        }
    }


}
