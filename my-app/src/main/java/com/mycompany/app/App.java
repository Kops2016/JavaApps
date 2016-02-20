package com.mycompany.app;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


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
        response.getWriter().println("<h1>Hello World</h1>");
        Map<String, String> env = new TreeMap<String, String>();
        env.putAll(System.getenv());
        for(Map.Entry<String, String> me : env.entrySet()) {
            response.getWriter().println("<p> " + me.getKey() + " : " + me.getValue() + "</p>");
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new App());

        server.start();
        server.join();
    }
}
