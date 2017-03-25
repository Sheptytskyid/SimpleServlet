import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class FormProcessor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> parameterNames = req.getParameterNames();
        resp.setHeader("content-type", "text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>FormProcessor</title>\n" +
            "</head>" +
            "<body>");
        while (parameterNames.hasMoreElements()) {
            String parameter = parameterNames.nextElement();
            writer.println("<h2>" + parameter+ ":</h2>" + req.getParameter(parameter));
        }
        writer.println("</body>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
