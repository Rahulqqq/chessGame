public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        // Rook moves in a straight line either horizontally or vertically
        if (startX != endX && startY != endY) return false;

        // Check if path is clear (no pieces in between)
        if (startX == endX) {
            for (int y = Math.min(startY, endY) + 1; y < Math.max(startY, endY); y++) {
                if (board[startX][y] != null) return false;
            }
        } else {
            for (int x = Math.min(startX, endX) + 1; x < Math.max(startX, endX); x++) {
                if (board[x][startY] != null) return false;
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
