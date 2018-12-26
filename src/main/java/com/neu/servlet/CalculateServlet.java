package com.neu.servlet;

import com.neu.Pattern.strategy.Mortgage;
import com.neu.Pattern.strategy.Payment;
import com.neu.service.CalculateService;
import com.neu.util.DateCalculate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CalculateServlet", urlPatterns = "/CalculateServlet")
public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        try {
            Date startDate = DateCalculate.stringToDate(request.getParameter("startDate"));
            Date endDate = DateCalculate.stringToDate(request.getParameter("endDate"));
            String method = request.getParameter("method");
            String loan = request.getParameter("loan");
            String rate = request.getParameter("rate");
            CalculateService calculateService = new CalculateService();
            Mortgage mortgage = calculateService.getMortgage(startDate, endDate, method, loan, rate);
            mortgage.makePayment();
            List<Payment> payments = mortgage.getPayments();
            HttpSession session = request.getSession();
            session.setAttribute("mortgage",mortgage);
            request.setAttribute("payments", payments);
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request,response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
