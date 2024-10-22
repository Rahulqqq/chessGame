public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
        // Determine the direction of movement based on piece color
        int direction = isWhite() ? -1 : 1; // White moves up (-1), Black moves down (+1)
        int startRow = isWhite() ? 6 : 1; // Starting row for white and black pawns
    
        // Moving forward by one square
        if (endX == startX + direction && endY == startY && board[endX][endY] == null) {
            return true; // Valid move to an empty square
        }
    
        // Moving forward by two squares from the starting position
        if (startX == startRow && endX == startX + 2 * direction && endY == startY && board[endX][endY] == null && board[startX + direction][endY] == null) {
            return true; // Valid move to an empty square, both squares must be empty
        }
    
        // Capturing diagonally
        if (endX == startX + direction && Math.abs(endY - startY) == 1 && board[endX][endY] != null && board[endX][endY].isWhite() != this.isWhite()) {
            return true; // Valid capture move
        }
    
        return false; // Invalid move
    }
    
    @Override
    public String getSymbol() {
        return "P"; // You can choose a different symbol if you want
    }
}