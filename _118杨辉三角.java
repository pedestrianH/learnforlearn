package 学习;

import java.util.ArrayList;
import java.util.List;

public class _118杨辉三角 {
    public static void main(String[] args) {
        generate(5);
    }
    public static List<List<Integer>> generate(int numRows) {
List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list3;
        for (int i = 1; i <=numRows ; i++) {
            list3 = new ArrayList<>();

            for (int j = 0; j < i; j++) {

                if (j == 0 || j == (i-1) ){
                    list3.add(1);
                }else {


                    list3.add(list1.get(j)+list1.get(j-1));

                }
            }
            list1 = list3;

            list.add(list1);
        }
        return list;

    }
}
