package servlet;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
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

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("users", users);
        request.getRequestDispatcher(index).forward(request,response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF8");

        if (!requestIsValid(request)) {
            doGet(request, response);
        }

        final String name = request.getParameter("name");
        final String age = request.getParameter("age");

        final User user = new User(name, Integer.valueOf(age));
        users.add(user);

        doGet(request, response);
    }

    private boolean requestIsValid(final HttpServletRequest request) {
        final String name = request.getParameter("name");
        final String age = request.getParameter("age");

        return  name != null && name.length() > 0 &&
                age  != null && age.length() > 0 &&
                age.matches("[+]?\\d+");
    }

}
