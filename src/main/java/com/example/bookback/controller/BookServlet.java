package com.example.bookback.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.example.bookback.entity.Book;
import Util.HibernateUtil;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BookServlet() {
        super();
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<title>Servlet BookServlet</title>");
            out.println("</head>");
            out.println("<body>");

            Long lookId=Long.parseLong ((String) request.getParameter("id"));

            System.out.println("get id!");
            System.out.println(lookId);
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            Book aBook =session.load(Book.class, lookId);
            System.out.println("get book");


            out.println("id: " + aBook.getBookId() + "<br>" + "isbn: "
                        +aBook.getIsbn()+"<br>"+"name:" +aBook.getName() +"<br>"+ "description"
                        +aBook.getDescription()+"<br>"+"price" +aBook.getPrice()+"<br>") ;


//            List books = session.createQuery("from Book").list();
//            session.getTransaction().commit();
//            for (int i = 0; i < books.size(); i++) {
//                Book theBook = (Book) books.get(i);
//                if(theBook.getBookId().equals(lookId))
//                out.println("id: " + theBook.getBookId() + "<br>" + "isbn: "
//                        +theBook.getIsbn()+"<br>"+"name:" +theBook.getName() +"<br>"+ "description"
//                        +theBook.getDescription()+"<br>"+"price" +theBook.getPrice()+"<br>") ;
//
//            }

            out.println("</body>");
            out.println("</html>");
            session.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
        }
        finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

}
