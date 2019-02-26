package pl.adamLupinski.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final  long serialVersionUID=1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String option = request.getParameter("cookie");

        if ("create".equals(option)){
            Cookie cookie = createCookie();
            response.addCookie(cookie);
            request.getRequestDispatcher("cookieInfo.jsp").forward(request, response);
        } else if ("print".equals(option)){
            request.getRequestDispatcher("cookieInfo.jsp").forward(request, response);
        } else if ("remove".equals(option)){
            removeCookies(request, response);
            request.getRequestDispatcher("noCookie.jsp").forward(request, response);
        }
    }

    private Cookie createCookie(){
        String cookieType;
        Random r = new Random();
        switch (r.nextInt(3)){
            case 0:
                cookieType = "Strawberry";
                break;
            case 1:
                cookieType = "Chocolate";
                break;
            case 2:
                cookieType = "Cinamon";
                break;
            default:
                   cookieType = "Brown Sugar";
        }
        String cookieName = "cookie" + r.nextInt(100);

        String cookieValue = cookieType + "cookie";
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(60*60);
        return cookie;

    }

    private void removeCookies(HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        Arrays.asList(cookies).forEach(c-> {c.setMaxAge(0); response.addCookie(c);});

    }

}
