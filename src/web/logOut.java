package web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by IBM on 19/03/2017.
 */
public class logOut extends HttpServlet {
    private RequestDispatcher view;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
            // Not created yet. Now do so yourself.
            view= request.getRequestDispatcher("index.jsp"); //if no user get to
            view.forward(request,response);
        }else {
            session.invalidate();
            view= request.getRequestDispatcher("index.jsp"); //if no user get to
            view.forward(request,response);

        }
    }
}
