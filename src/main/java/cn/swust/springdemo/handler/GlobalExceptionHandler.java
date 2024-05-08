package cn.swust.springdemo.handler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截本类中的验证异常， 把错误信息整理成易于前端处理的格式。
     *
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List errors = new ArrayList<String>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            errors.add(error.getDefaultMessage());
        });
        // 拼接结果
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("failure", true);  // 用于判断是否失败
        result.put("message", errors);
        return result;
    }
}
