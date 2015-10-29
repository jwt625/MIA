package Others;

/**
 * Created by IIIS on 10/29/2015.
 */
public class Others {
    //This function returns the int value of a String of decimal number
    public int String2int(String StrToConvert){
        int len = StrToConvert.length();
        int num = 0;
        for(int i = 0; i < len; i++){
            int power = 1;
            for(int j = len; j > i+1; j--){
                power = power*10;
            }
            num = num + (StrToConvert.charAt(i)-'0')*power;
        }
        return num;
    }
    public static void main(String[] args){
        Others b=new Others();
        String test = "123222";
        int a;
        a= b.String2int(test);
        System.out.print(a);
    }
}
