package lk.jiat.ecomm.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.jiat.ecomm.user.dto.UserDTO;
import lk.jiat.ecomm.user.remote.TestRemote;
import lk.jiat.ecomm.user.remote.UserRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@WebServlet("/test")
public class Test extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Ecomm Web module Test");

        try {
            TestRemote tr;
            HttpSession session = req.getSession();
            if (session.getAttribute("testBean") == null) {
                InitialContext ic = new InitialContext();
                tr = (TestRemote) ic.lookup("testBean");
                session.setAttribute("testSession", tr);
            } else {
                tr = (TestRemote) session.getAttribute("testBean");
            }

            String test = tr.test();
            resp.getWriter().write("Result: " + test);

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}


//Page Scope, Request Scope, Session Scope, Application Scope