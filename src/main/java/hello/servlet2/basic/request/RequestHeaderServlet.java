package hello.servlet2.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*printStartLine(request);
        printHeaders(request);*/
        printEtc(request);
    }

    private static void printStartLine(HttpServletRequest request) {
        System.out.println("-----REQUEST-LINE--START---");

        System.out.println("request.getMethod = " + request.getMethod());
        System.out.println("request.getProtocol() = " + request.getProtocol());
        System.out.println("request.getScheme() = " + request.getScheme());
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure());
        System.out.println("-----REQUEST-LINE--END---");
        System.out.println();
    }

    private static void printHeaders(HttpServletRequest request) {
        System.out.println("-----Headers--START---");

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " + headerName));

        System.out.println("-----Headers--END---");
        System.out.println();
    }

    private static void printHeaderUtils(HttpServletRequest request) {
        System.out.println("-----Headers--START---");

        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println(locale  + ": " + locale));

        System.out.println("-----Headers--END---");
        System.out.println();
    }

    private static void printEtc(HttpServletRequest request) {
        System.out.println("-----ETC--START---");
        
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());

        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());

        System.out.println("-----ETC--END---");
        System.out.println();
    }

}
