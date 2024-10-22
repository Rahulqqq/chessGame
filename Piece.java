public abstract class Piece {
    private boolean isWhite;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    // Abstract method to be implemented by subclasses for movement logic
    public abstract boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board);

    // Method to return the symbol of the piece (to be overridden by subclasses)
    public abstract String getSymbol();
}
