package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "Counter", urlPatterns = "/Counter")
public class Counter extends HttpServlet {

    private int counter;
    String fileName = System.getenv().get("USERPROFILE") + File.separator + "count.txt";

    @Override
    public void init() throws ServletException {

        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
                    dos.writeInt(1);
                    try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
                        counter = dis.readInt();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
                counter = dis.readInt();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        final PrintWriter writer = resp.getWriter();
        writer.println("<h1>Servlet Counter</h1>");
        writer.println("<h2>Request Number : " + counter + "</h2>");
        counter++;
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(counter);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

