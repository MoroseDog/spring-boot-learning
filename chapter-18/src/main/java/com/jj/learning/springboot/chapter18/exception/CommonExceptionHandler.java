package com.jj.learning.springboot.chapter18.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 攔截Exception類的異常，並渲染到error.html內
     * 2019年4月1日
     * @param req
     * @param e
     * @return
     * @throws Exception
     *
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * 攔截MyException類的異常，返Json格式respCode、respMsg、url
     * 2019年4月1日
     * @param req
     * @param e
     * @return
     * @throws Exception
     *
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Map<String, Object> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("respCode", "9999");
        result.put("respMsg", e.getMessage());
        result.put("url", req.getRequestURL().toString());
        return result;
    }

}
