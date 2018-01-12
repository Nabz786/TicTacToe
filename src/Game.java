public class Game {

    private int numRows = 3;
    private int numCols = 3;

    public boolean hasWon = false;
    public boolean p1Turn = true;

    private winningLoc loc;

    public char[][] toeBoard;

    public enum winningLoc{
        co1One, colTwo, colThree,
        rowOne, rowTwo, rowThree,
        diagLR, diagRL
    }

    public Game() {
        toeBoard = new char[3][3];
    }

    public void playGame(int row, int col) {

        int playRow = row - 1;
        int playCol = col - 1;
        if (toeBoard[playRow][playCol] == '\u0000' && !hasWon) {
            if (p1Turn) {
                for (int r = 0; r < numRows; r++) {
                    for (int c = 0; c < numCols; c++) {
                        if (r == playRow && c == playCol && toeBoard[playRow][playCol] == '\u0000') {
                            toeBoard[r][c] = 'X';
                        }
                    }
                }
                p1Turn = false;
            } else {
                for (int r = 0; r < numRows; r++) {
                    for (int c = 0; c < numCols; c++) {
                        if (r == playRow && c == playCol && toeBoard[playRow][playCol] == '\u0000') {
                            toeBoard[r][c] = 'O';
                        }
                    }
                }
                p1Turn = true;
            }
        }
        if (checkWin()) {
            hasWon = true;
        }
    }

    private boolean checkWin() {
        if ((toeBoard[0][0] == toeBoard[1][0] && toeBoard[0][0] == toeBoard[2][0]) && toeBoard[0][0] != '\u0000') {
            setWinningLoc(winningLoc.rowOne);
            return true;
        } else if ((toeBoard[0][1] == toeBoard[1][1] && toeBoard[0][1] == toeBoard[2][1]) && toeBoard[0][1] != '\u0000') {
            setWinningLoc(winningLoc.rowTwo);
            return true;
        } else if ((toeBoard[0][2] == toeBoard[1][2] && toeBoard[0][2] == toeBoard[2][2]) && toeBoard[0][2] != '\u0000') {
            setWinningLoc(winningLoc.rowThree);
            return true;
        } else if ((toeBoard[0][0] == toeBoard[0][1] && toeBoard[0][0] == toeBoard[0][2]) && toeBoard[0][0] != '\u0000') {
            setWinningLoc(winningLoc.co1One);
            return true;
        } else if ((toeBoard[1][0] == toeBoard[1][1] && toeBoard[1][0] == toeBoard[1][2]) && toeBoard[1][0] != '\u0000') {
            setWinningLoc(winningLoc.colTwo);
            return true;
        } else if ((toeBoard[2][0] == toeBoard[2][1] && toeBoard[2][0] == toeBoard[2][2]) && toeBoard[2][0] != '\u0000') {
            setWinningLoc(winningLoc.colThree);
            return true;
        } else if ((toeBoard[0][0] == toeBoard[1][1] && toeBoard[0][0] == toeBoard[2][2]) && toeBoard[0][0] != '\u0000') {
            setWinningLoc(winningLoc.diagLR);
            return true;
        } else if ((toeBoard[2][0] == toeBoard[1][1] && toeBoard[2][0] == toeBoard[0][2]) && toeBoard[2][0] != '\u0000') {
            setWinningLoc(winningLoc.diagRL);
            return true;
        }
        return false;
    }

    public void reset(){
        toeBoard = new char[3][3];
        hasWon = false;
        p1Turn = true;
        loc = null;
    }

    public void setWinningLoc(winningLoc loc){
        this.loc = loc;
    }

    public winningLoc getWinningLoc(){
        return loc;
    }
}
