import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessGame extends JFrame {
    private final int BOARD_SIZE = 8;
    private JButton[][] squares = new JButton[BOARD_SIZE][BOARD_SIZE];
    private Board board;
    private int selectedX = -1, selectedY = -1;

    public ChessGame() {
        setTitle("Chess Game");
        setSize(600, 600);
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        board = new Board();
        initializeBoard();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Initialize the board with buttons
    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                squares[i][j] = new JButton();
                squares[i][j].setFont(new Font("Arial", Font.BOLD, 30));
                squares[i][j].setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
                final int x = i, y = j;
                squares[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleClick(x, y);
                    }
                });
                add(squares[i][j]);
            }
        }
        updateBoard();
    }

    // Handle piece selection and movement
    private void handleClick(int x, int y) {
        if (selectedX == -1 && selectedY == -1) {
            // Select the piece
            selectedX = x;
            selectedY = y;
            System.out.println("Selected piece at: " + x + ", " + y);
        } else {
            // Attempt to move the piece
            System.out.println("Moving piece to: " + x + ", " + y);
            if (board.movePiece(selectedX, selectedY, x, y)) {
                updateBoard();  // Refresh the board display after a move
            } else {
                System.out.println("Invalid move!");
            }
            // Reset selection
            selectedX = -1;
            selectedY = -1;
        }
    }
    
    

    // Update the board display to reflect the pieces' positions
    private void updateBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Piece piece = board.getPiece(i, j);
                squares[i][j].setText(piece == null ? "" : piece.getSymbol());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChessGame());
    }
}
