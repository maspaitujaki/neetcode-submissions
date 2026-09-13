class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!isRowValid(board[i])) return false;
            if (!isColumnValid(board, i)) return false;
            if (i % 3 == 0) {
                if (!isGridValid(board, i, 0)) return false;
                if (!isGridValid(board, i, 3)) return false;
                if (!isGridValid(board, i, 6)) return false;
            }
        }

        return true;
    }

    private boolean isGridValid(char[][] board, int xStart, int yStart) {
        boolean[] checker = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char currentDigit = board[xStart + i][yStart + j];

                if (currentDigit == '.') continue;

                int digitValue = currentDigit - '0';
                if (checker[digitValue - 1]) {
                    return false;
                }

                checker[digitValue - 1] = true;
            }
        }

        return true;
    }

    private boolean isColumnValid(char[][] board, int column) {
        boolean[] checker = new boolean[9];
        
        for (int i = 0; i < board.length; i++) {
            char currentDigit = board[i][column];

            if (currentDigit == '.') continue;

            int digitValue = currentDigit - '0';
            if (checker[digitValue - 1]) {
                return false;
            }

            checker[digitValue - 1] = true;
        }

        return true;
    }

    private boolean isRowValid(char[] row) {
        boolean[] checker = new boolean[9];
        for (int i = 0; i < row.length; i++) {
            char currentDigit = row[i];

            if (currentDigit == '.') continue;

            int digitValue = currentDigit - '0';
            if (checker[digitValue - 1]) {
                return false;
            }

            checker[digitValue - 1] = true;
        }

        return true;
    }
}
