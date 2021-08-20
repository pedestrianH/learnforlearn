package 学习;

public class _14最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        int zui = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i <strs.length ; i++) {
            zui = strs[i].length() > zui ? zui : strs[i].length();
        }
            for (int j = 0; j < zui ; j++) {
                char current = strs[0].charAt(j);

                for (int k = 1; k < strs.length; k++) {
                    if (!(strs[k].charAt(j)==current)){
                        return result;

                    }

                }
                result += current;


        }
        return result;

    }
}
