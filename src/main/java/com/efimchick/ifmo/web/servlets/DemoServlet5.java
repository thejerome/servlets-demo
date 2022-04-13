package com.efimchick.ifmo.web.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by EE on 2018-11-01.
 */

@WebServlet(
        name = "DemoServlet5",
        urlPatterns = {"/demo5"}
)
public class DemoServlet5 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();

        out.print("<html>\n" +
                "  <head>\n" +
                "    <title>demo5</title>\n" +
                "  </head>\n" +
                "  <body>\n");

        final Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            out.println("<h2>" + cookie.getName() + "</h2>");
            out.println("<h3>" + cookie.getValue() + "</h3>");
            out.println("<h3>" + cookie.getDomain() + "</h3>");
            out.println("<h3>" + cookie.getPath() + "</h3>");
            out.println("<h3>" + cookie.getMaxAge() + "</h3>");
            out.println("<h3>" + cookie.getVersion() + "</h3>");
            out.println("<br/>");
        }

        resp.addCookie(
                new Cookie(
                        "cookie" + cookies.length,
                        Double.toString(Math.random()))
        );


        out.print("  </body>\n" +
                "</html>");
        out.flush();
        out.close();
    }

}
