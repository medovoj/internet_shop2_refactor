package utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;

public final class RoutingUtils {
    public static void forwardToFragment(String jspFragment, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/JSP/fragment/" + jspFragment).forward(req, resp);
    }

    public static void forwardToPage(String jspPage, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentPage", "page/" + jspPage);
        req.getRequestDispatcher("/WEB-INF/JSP/page-template.jsp").forward(req, resp);
    }

    public static void sendHTMLFragment(String text, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println(text);
        resp.getWriter().close();
    }

    public static void sendJSON(JSONObject json, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.getWriter().println(json.toString());
        resp.getWriter().close();
    }

    public static void redirect(String url, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(url);
    }
}

