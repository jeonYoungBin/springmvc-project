package hello.servlet2.web.frontcontroller.v5.adapter;

import hello.servlet2.web.frontcontroller.ModelView;
import hello.servlet2.web.frontcontroller.v3.ControllerV3;
import hello.servlet2.web.frontcontroller.v4.ControllerV4;
import hello.servlet2.web.frontcontroller.v5.MyHandlerAdapter;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controllerV4 = (ControllerV4) handler;

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> map = new HashMap<>();

        String viewName = controllerV4.process(paramMap, map);
        ModelView mv = new ModelView(viewName);
        mv.setModel(map);

        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }


}
