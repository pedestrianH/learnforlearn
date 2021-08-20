package 学习;

public class _13罗马数字转整数 {

    public int romanToInt(String s) {

int result = 0;
        for (int i = 0; i <s.length(); i++) {
            if (s.charAt(i) == 'I'){
                    if (i+1<s.length()){
                        if (s.charAt(i+1) == 'V'){

                            i++;

                            result += 4;
                        }else if (s.charAt(i+1) == 'X'){
                                result += 9;
                            i++;

                        }
                        else {
                            result+= 1;

                        }

                    }
                    else {
                        result+= 1;

                    }
            }
            else if (s.charAt(i) == 'X'){
                if (i+1<s.length()){
                    if (s.charAt(i+1) == 'L'){

                        i++;

                        result+= 40;
                    }else if (s.charAt(i+1) == 'C'){
                        i++;

                        result+=90;
                    }
                    else {
                        result+=10;

                    }

                }
                else {
                    result+=10;

                }


            }else if (s.charAt(i) == 'C'){
                if (i+1<s.length()){
                    if (s.charAt(i+1) == 'D'){
                        i++;

                        result+=400;
                    }else if (s.charAt(i+1) == 'M'){
                        i++;

                        result+=900;

                    }else {
                        result+=100;

                    }
                }else {
                    result+=100;

                }




            }
            else if (s.charAt(i) == 'V'){
                    result+= 5;
            }
            else if (s.charAt(i) == 'M'){
                result+=1000;
            }
            else if (s.charAt(i) == 'L'){
                result+= 50;

            }
            else if (s.charAt(i) == 'D'){
                result+=500;
            }
        }
            return result;
    }
}
