package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FormServlet", urlPatterns = "/form.do")
public class FormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String name=req.getParameter("name");
        final String phone=req.getParameter("phone");
        final String email=req.getParameter("email");

        PrintWriter writer = resp.getWriter();

        if (name.isEmpty() || (phone.isEmpty() && email.isEmpty())) {
            writer.println("<h1>Form error</h1>");
        } else {
            writer.println("<html><h1>Form results</h1>");
            writer.println("<h2>Name : "+ name + "</h2>");
            writer.println("<h2>Phone : "+ phone + "</h2>");
            writer.println("<h2>Email : "+ email + "</h2></html>");
        }


    }
}
