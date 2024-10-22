public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        boolean isDiagonal = Math.abs(startX - endX) == Math.abs(startY - endY);
        boolean isStraight = startX == endX || startY == endY;
        return isDiagonal || isStraight;
    }

    @Override
    public String getSymbol() {
        return isWhite() ? "Q" : "q";
    }
}
