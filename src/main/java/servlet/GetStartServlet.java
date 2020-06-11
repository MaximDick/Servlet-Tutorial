package servlet;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GetStartServlet extends javax.servlet.http.HttpServlet {

    private final static String index = "/index.jsp";
    private List<User> users;


    @Override
    public void init() throws ServletException {
        users = new CopyOnWriteArrayList<>();
        users.add(new User("Java", 10));
        users.add(new User("Vision", 20));
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(index);
        dispatcher.forward(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("*************SERVLET IS DESTROY************");
    }
}
