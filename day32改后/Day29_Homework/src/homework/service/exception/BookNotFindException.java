package homework.service.exception;

public class BookNotFindException extends BookException {
    @Override
    public String getMessage() {
        return "未找到对应书籍";
    }
}
