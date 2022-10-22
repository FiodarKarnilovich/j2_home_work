package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@WebServlet(name = "CounterImg", urlPatterns ="/CounterImg")
public class CounterImg extends HttpServlet {
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

        ServletOutputStream out = resp.getOutputStream();
        resp.setContentType("image/jpg");

        BufferedImage img = new BufferedImage(500, 300, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = img.createGraphics();
        graphics.setFont(new Font("Calibri", Font.ITALIC, 40));
        graphics.setBackground(Color.RED);
        graphics.setColor(Color.YELLOW);

        graphics.drawString("Request Number : " + counter, 50, 50);
        ImageIO.write(img, "jpeg", out);
        counter++;
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(counter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
