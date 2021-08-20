package 学习;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _36有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Integer>> k  = new HashMap<>();
        Map<Integer, HashSet<Integer>> t  = new HashMap<>();
        Map<Integer, HashSet<Integer>> c  = new HashMap<>();
        for (int i = 0; i <9 ; i++) {
            k.put(i,new HashSet<>());
            t.put(i,new HashSet<>());
            c.put(i,new HashSet<>());
        }
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int l = i/3*3 + j/3;
                if (board[i][j] == '.'){
                    continue;
                }else {
                    int f = board[i][j] - '0';
                if (!k.get(i).contains(f) && !t.get(j).contains(f) && !c.get(l).contains(f) ){
                    k.get(i).add(f);
                    t.get(j).add(f);
                    c.get(l).add(f);
                    }
                else {
                    return false;
                }
                }
            }
        }
        return true;
    }
}
