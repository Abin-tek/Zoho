//import javax.swing.*;
//import java.awt.*;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ChessBoard extends JFrame {
//    public static final int SIZE = 8;
//    private static final int BOARD_SIZE = 1000;
//    private static final int PIECE_SIZE = 80;
//    private static final Color LIGHT_COLOR = new Color(222, 184, 135);
//    private static final Color DARK_COLOR = new Color(139, 69, 19);
//    private final JButton[][] squares = new JButton[SIZE][SIZE];
//    private final Map<String, ImageIcon> pieceImages = new HashMap<>();
//    Game game;
//    private JButton startSquare;
//    private JButton endSquare;
//
//    public JButton[][] getSquares() {
//        return squares;
//    }
//
//    public ChessBoard(Game game) {
//        setTitle("Chess Game");
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLayout(new GridBagLayout());
//        getContentPane().setBackground(Color.LIGHT_GRAY);
//        loadPieceImages();
//        this.game = game;
//        startSquare = null;
//        endSquare = null;
//
//        JPanel boardPanel = new JPanel(new GridLayout(SIZE, SIZE)) {
//            @Override
//            public Dimension getPreferredSize() {
//                return new Dimension(BOARD_SIZE, BOARD_SIZE);
//            }
//        };
//
//
//        for (char row = 0; row < SIZE; row++) {
//            for (char col = 0; col < SIZE; col++) {
//                JButton square = new JButton();
//                square.setOpaque(true);
//                square.setBorderPainted(false);
//                square.setBackground(((row + col) & 1) == 0 ? LIGHT_COLOR : DARK_COLOR);
//                square.addActionListener(new SquareClickListener(row, col));
//                boardPanel.add(square);
//                squares[row][col] = square;
//            }
//        }
//        placePieces();
//
//        add(boardPanel, new GridBagConstraints());
//        setVisible(true);
//    }
//
//    public Game getGame() {
//        return game;
//    }
//
//    private void loadPieceImages() {
//        String[] pieces = {"P", "R", "N", "B", "Q", "K"};
//        for (String piece : pieces) {
//            pieceImages.put("W" + piece, resizeImage("icons/W" + piece + ".png"));
//            pieceImages.put("B" + piece, resizeImage("icons/B" + piece + ".png"));
//        }
//    }
//
//    private ImageIcon resizeImage(String path) {
//        ImageIcon icon = new ImageIcon(path);
////        Image image = icon.getImage().getScaledInstance(PIECE_SIZE, PIECE_SIZE, Image.SCALE_SMOOTH);
//        return icon;
//    }
//
//    public JButton getStartSquare() {
//        return startSquare;
//    }
//
//    public JButton getEndSquare() {
//        return endSquare;
//    }
//
//    public void setStartSquare(JButton startSquare) {
//        this.startSquare = startSquare;
//    }
//
//    public void setEndSquare(JButton endSquare) {
//        this.endSquare = endSquare;
//    }
//
//    private void placePieces() {
//        // Place pawns
//        for (int col = 0; col < SIZE; col++) {
//            squares[1][col].setIcon(pieceImages.get("BP"));
//            squares[6][col].setIcon(pieceImages.get("WP"));
//        }
//        // Place rooks
//        squares[0][0].setIcon(pieceImages.get("BR"));
//        squares[0][7].setIcon(pieceImages.get("BR"));
//        squares[7][0].setIcon(pieceImages.get("WR"));
//        squares[7][7].setIcon(pieceImages.get("WR"));
//        // Place knights
//        squares[0][1].setIcon(pieceImages.get("BN"));
//        squares[0][6].setIcon(pieceImages.get("BN"));
//        squares[7][1].setIcon(pieceImages.get("WN"));
//        squares[7][6].setIcon(pieceImages.get("WN"));
//        // Place bishops
//        squares[0][2].setIcon(pieceImages.get("BB"));
//        squares[0][5].setIcon(pieceImages.get("BB"));
//        squares[7][2].setIcon(pieceImages.get("WB"));
//        squares[7][5].setIcon(pieceImages.get("WB"));
//        // Place queens
//        squares[0][3].setIcon(pieceImages.get("BQ"));
//        squares[7][3].setIcon(pieceImages.get("WQ"));
//        // Place kings
//        squares[0][4].setIcon(pieceImages.get("BK"));
//        squares[7][4].setIcon(pieceImages.get("WK"));
//    }
//
//    public JButton getSquares(int row, int col) {
//        return squares[row][col];
//    }
//
//}
