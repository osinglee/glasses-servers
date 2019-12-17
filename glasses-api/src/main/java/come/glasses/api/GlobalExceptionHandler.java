package come.glasses.api;

import come.glasses.utils.JSONResult;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.file.AccessDeniedException;

/**
 * @Description : null.java
 * @auther : modan
 * @create : 2019-08-16 09:27
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {

        logger.error(ExceptionUtils.getStackTrace(e));  // 记录错误信息
        return new JSONResult<Exception>(false, e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    JSONResult handleBindException(BindException e) {
//        List<Map<String, Object>> errorList = new ArrayList<>();
//        for (FieldError fieldError : e.getFieldErrors()) {
//            Map<String, Object> error = new HashMap<>();
//            error.put("field", fieldError.getField());
//            error.put("code", fieldError.getCode());
//            error.put("message", fieldError.getDefaultMessage());
//            errorList.add(error);
//        }
        JSONResult jsonResult = new JSONResult();
        jsonResult.setSuccess(false);
        jsonResult.setMessage(e.getMessage());
        return jsonResult;
    }

    /**
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    JSONResult handleAccessDeniedException(AccessDeniedException e) {
        return JSONResult.error("CM.PERMISSION_ERROR");
    }
}
