package cybersoft.java18.crm.model;

public class ReponseData {
    private int statusCode;
    private String message;
    private boolean isSucces;
    private Object data;


    public ReponseData(int code, String message, boolean isSucces, Object data) {
        this.statusCode = code;
        this.message = message;
        this.isSucces = isSucces;
        this.data = data;
    }

    public ReponseData() {

    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getCode() {
        return statusCode;
    }

    public boolean isSucces() {
        return isSucces;
    }

    public void setSucces(boolean succes) {
        isSucces = succes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
