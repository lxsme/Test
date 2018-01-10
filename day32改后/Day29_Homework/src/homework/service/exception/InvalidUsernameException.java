package homework.service.exception;

public class InvalidUsernameException extends LoginException {
    @Override
    public String getMessage() {
        return "没有该用户";
    }
}
