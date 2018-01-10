package homework.service.exception;

public class IsNotMailException extends RegisterException {
    @Override
    public String getMessage() {
        return "请用邮箱注册";
    }
}
