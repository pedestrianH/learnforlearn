package 学习;
public class _419甲板上的战舰 {
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 'X'){
                        result ++;
                        if (i-1 >= 0 &&board[i-1][j] == 'X'){
                            result--;
                        }
                        else if (j-1 >= 0 && board[i][j-1] == 'X'){
                            result--;
                        }
                    }
            }
        }
return result;
    }
}
