package cn.yang.test.day.excercise;
import java.util.Scanner;
//• 7、有一个字符串，其中包含中文字符、英文字符和数字字符，请统计和打印出各个字符的个数。 [选做题]
public class MyGroup {
    public static void main(String[] args) {
        MyGroup();
    }

    public static void MyGroup(){

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        System.out.println("请输入一个字符串");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        for(int i = 0 ;i<str.length();i++){
            if(str.charAt(i) >=0x30 && str.charAt(i) <=0x39){
                sum1++;
            }
            if((str.charAt(i) >=0x61 && str.charAt(i) <=0x7a)||(str.charAt(i) >=0x41 && str.charAt(i) <=0x5a)){
                sum2++;
            }
            if(str.charAt(i)>0x0391 && str.charAt(i) <= 0xFFE5){
                sum3++;
            }
        }
        System.out.println("字符串\""+str+"\"中有\n"+sum1+"个数字字符，有"+sum2+"个英文字符"+sum3+"个中文字符");
    }

}
