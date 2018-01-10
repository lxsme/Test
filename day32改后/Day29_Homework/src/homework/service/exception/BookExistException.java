package homework.service.exception;

public class BookExistException extends BookException {
    @Override
    public String getMessage() {
        return "已存在与该书同名的书";
    }
}
