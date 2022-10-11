package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "counter", urlPatterns = "/counter")
public class counter extends HttpServlet  {

    private static int count = 0;
  //  private int counter;
 //   File file = new File("C:\\Java\\apache-tomcat-9.0.65\\webapps\\home_work");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        count++;

//        File file = new File("./web_module/src/main/webapp/WEB-INF/count.txt");
//        try {
//            DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(file));
//            DataInputStream fileIn = new DataInputStream(new FileInputStream(file));
//            counter = fileIn.readInt() + 1;
//            PrintWriter pw = new PrintWriter(file);
//            pw.close();
//            fileOut.writeInt(counter);
//            fileOut.flush();
//
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }

        final PrintWriter writer = resp.getWriter();
        writer.println("<h1>Servlet Counter</h1>");
        writer.println("<h2>Request Number : "+count+"</h2>");
    }

}

