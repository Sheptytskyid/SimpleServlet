import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class SimpleServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        Enumeration<String> attributeNames = req.getAttributeNames();
        resp.setHeader("content-type", "text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>SimpleServlet</title>\n" +
            "</head>" +
            "<body>");
        writer.println("<h2>Headers</h2>");
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            writer.println("<b>" + header + ":</b>" + req.getHeader(header) + "<br>");
        }
        writer.println("<h2>Attributes</h2>");
        while (attributeNames.hasMoreElements()) {
            String attribute = attributeNames.nextElement();
            writer.println("<b>" + attribute + ":</b> " + req.getHeader(attribute) + "<br>");
        }
        writer.println("</body>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
