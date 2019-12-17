package come.glasses.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONResult<T> {
    private String message;
    private Boolean success;
    private T data;

    public JSONResult() {
        this.message = "";
        this.success = true;
        this.data = null;
    }

    public static JSONResult error(String message) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setSuccess(false);
        jsonResult.setMessage(message);
        return jsonResult;
    }

    public JSONResult(T data) {
        this.data = data;
    }

    public JSONResult(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public JSONResult(Boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
