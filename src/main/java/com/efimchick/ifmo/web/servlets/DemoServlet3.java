package com.efimchick.ifmo.web.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by EE on 2018-11-01.
 */

@WebServlet(
        name = "DemoServlet3",
        urlPatterns = {"/demo3"}
)
public class DemoServlet3 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();

        out.print("<html>\n" +
                "  <head>\n" +
                "    <title>demo3</title>\n" +
                "  </head>\n" +
                "  <body>\n");

        //All headers
        final Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            out.println("<h3>" +
                    headerName +
                    ": " +
                    req.getHeader(headerName) +
                    "</h3>");
        }
        out.print("  </body>\n" +
                "</html>");
        out.flush();
        out.close();
    }

}
