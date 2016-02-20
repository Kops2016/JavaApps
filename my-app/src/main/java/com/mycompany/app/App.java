package com.mycompany.app;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class App extends AbstractHandler {
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("<h1>Hello World from V10</h1>");
        response.getWriter().println("<h1>Hello Mars from V10</h1>");
    }

    public static void main(String[] args) throws Exception {
        if(args.length < 1) {
            System.err.println("Usage: java App <portNo>");
            System.exit(1);
        }
        Server server = new Server(Integer.parseInt(args[0]));
        server.setHandler(new App());

        server.start();
        server.join();
    }
}
