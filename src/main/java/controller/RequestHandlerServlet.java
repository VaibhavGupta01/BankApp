package controller;

import context.Application;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Transaction;

import java.io.IOException;

public class RequestHandlerServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().equals("/transactions")){
            int amount = Integer.parseInt(req.getParameter("amount"));
            String reference = req.getParameter("reference");
            Transaction transactionCreated = Application.transactionService.create(amount, reference);

        }else{
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().equals("/transactions")){
            resp.setContentType("application/json; charset=UTF-8");
            String transactionDetail = Application.objectMapper.writeValueAsString(Application.transactionService.getTransactions());
            resp.getWriter().print(transactionDetail);
        } else if (req.getRequestURI().equals("/")) {
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().print("<html>\n" +
                    "<body>\n" +
                    "<h1>Banking Application</h1>\n" +
                    "<p>A place to keep track of all your transactions.</p>\n" +
                    "</body>\n" +
                    "</html>");
        }
    }
}
