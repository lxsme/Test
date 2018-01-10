package homework.service.exception;

public class UserExistException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户已存在";
    }
}
