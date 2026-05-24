import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

@WebServlet("/hello")  // Maps URL to this servlet
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response)
            throws IOException {

        // Set response content type
        response.setContentType("text/html");

        // Get writer
        PrintWriter out = response.getWriter();

        // Write HTML response
        out.println("<html><body>");
        out.println("<h1>Hello from my first Servlet!</h1>");
        out.println("<p>Current Time: " + new java.util.Date() + "</p>");
        out.println("</body></html>");
    }
}