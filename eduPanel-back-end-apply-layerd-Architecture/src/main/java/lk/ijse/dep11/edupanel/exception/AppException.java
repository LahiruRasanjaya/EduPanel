package lk.ijse.dep11.edupanel.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException{
    private int errorCode;

    public AppException(int errorCode) {
        this.errorCode = errorCode;
    }

    public AppException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public AppException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public AppException(Throwable cause, int errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public AppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }
}
