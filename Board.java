public class Board {
    private Piece[][] board = new Piece[8][8];

    public Board() {
        initializeBoard();
    }

    // Initialize the board with pieces in the correct positions
    private void initializeBoard() {
        board[0][0] = new Rook(true);
        board[0][7] = new Rook(true);
        board[7][0] = new Rook(false);
        board[7][7] = new Rook(false);

        board[0][1] = new Knight(true);
        board[0][6] = new Knight(true);
        board[7][1] = new Knight(false);
        board[7][6] = new Knight(false);

        board[0][2] = new Bishop(true);
        board[0][5] = new Bishop(true);
        board[7][2] = new Bishop(false);
        board[7][5] = new Bishop(false);

        board[0][3] = new Queen(true);
        board[7][3] = new Queen(false);

        board[0][4] = new King(true);
        board[7][4] = new King(false);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(true);
            board[6][i] = new Pawn(false);
        }
    }

    // Get the piece at the specified position
    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    // Move a piece from one position to another, if valid
    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = board[startX][startY];
        Piece destinationPiece = board[endX][endY];
    
        // Validate the move based on the piece's logic and if the destination is empty or an opponent piece
        if (piece != null && piece.isValidMove(startX, startY, endX, endY, board)) {
            if (destinationPiece == null || destinationPiece.isWhite() != piece.isWhite()) {
                board[endX][endY] = piece;  // Move the piece
                board[startX][startY] = null;  // Clear the original position
                return true;
            }
        }
        return false;  // Invalid move
    }
    

    // Print the board to the console
    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j].getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }
}
