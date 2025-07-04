package Game;

/**
 * ゲーム専用の例外クラス
 * ゲーム固有のエラーを表現するためのカスタム例外
 */
public class GameException extends Exception {
    private static final long serialVersionUID = 1L;

    // エラーの種類を表す列挙型
    public enum ErrorType {
        INITIALIZATION_ERROR("初期化エラー"),
        RESOURCE_LOAD_ERROR("リソース読み込みエラー"),
        GAME_STATE_ERROR("ゲーム状態エラー"),
        INPUT_ERROR("入力エラー"),
        RENDERING_ERROR("描画エラー");

        private final String description;

        ErrorType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private ErrorType errorType;

    /**
     * デフォルトコンストラクタ
     */
    public GameException() {
        super();
    }

    /**
     * メッセージ付きコンストラクタ
     * 
     * @param message エラーメッセージ
     */
    public GameException(String message) {
        super(message);
    }

    /**
     * エラータイプ付きコンストラクタ
     * 
     * @param errorType エラーの種類
     * @param message   エラーメッセージ
     */
    public GameException(ErrorType errorType, String message) {
        super(errorType.getDescription() + ": " + message);
        this.errorType = errorType;
    }

    /**
     * 原因付きコンストラクタ
     * 
     * @param message エラーメッセージ
     * @param cause   原因となる例外
     */
    public GameException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * エラータイプと原因付きコンストラクタ
     * 
     * @param errorType エラーの種類
     * @param message   エラーメッセージ
     * @param cause     原因となる例外
     */
    public GameException(ErrorType errorType, String message, Throwable cause) {
        super(errorType.getDescription() + ": " + message, cause);
        this.errorType = errorType;
    }

    /**
     * エラータイプを取得
     * 
     * @return エラーの種類
     */
    public ErrorType getErrorType() {
        return errorType;
    }

    /**
     * エラーが致命的かどうかを判定
     * 
     * @return 致命的なエラーの場合true
     */
    public boolean isFatal() {
        return errorType == ErrorType.INITIALIZATION_ERROR ||
                errorType == ErrorType.RESOURCE_LOAD_ERROR;
    }
}