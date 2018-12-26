package com.neu.servlet;

import com.neu.Pattern.strategy.Mortgage;
import com.neu.Pattern.strategy.Payment;
import com.neu.service.SearchPaymentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchPaymentServlet", urlPatterns = "/SearchPaymentServlet")
public class SearchPaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        request.setAttribute("date", date);
        HttpSession session = request.getSession();
        Mortgage mortgage = (Mortgage)session.getAttribute("mortgage");
        SearchPaymentService searchPaymentService = new SearchPaymentService();
        List<Payment> payments = searchPaymentService.searchPaymentByDate(mortgage,date);
        request.setAttribute("payments", payments);
        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
