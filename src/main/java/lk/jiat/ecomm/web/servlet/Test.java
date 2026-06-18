package lk.jiat.ecomm.web.servlet;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.jiat.ecomm.ejb.remote.AppSetting;
import lk.jiat.ecomm.user.dto.UserDTO;
import lk.jiat.ecomm.user.remote.TestRemote;
import lk.jiat.ecomm.user.remote.UserRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/test",loadOnStartup = 1)
public class Test extends HttpServlet {


//    @EJB(lookup = "java:global/ecomm-user-1.0/TestNewSessionBean")
//    private TestRemote testRemote;
//
//    @EJB
//    private AppSetting appSetting;

    @Inject
    private MyApp myApp;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.getWriter().write("Ecomm Web module Test<br>");


        req.getSession();
        myApp.doSomething();

//        resp.getWriter().write("App Name: "+appSetting.getName());

    }
}


//Page Scope, Request Scope, Session Scope, Application Scope