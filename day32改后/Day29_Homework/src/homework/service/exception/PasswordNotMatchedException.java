package homework.service.exception;

public class PasswordNotMatchedException extends LoginException {
    @Override
    public String getMessage() {
        return "密码不正确";
    }
}
