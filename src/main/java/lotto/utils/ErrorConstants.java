package lotto.utils;

public enum ErrorConstants {
    INPUT_ERROR("[ERROR] 입출력 과정에서 예외가 발생했습니다.");

    private final String message;

    ErrorConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
