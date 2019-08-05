package cn.heima.day03;

/**
 * <p>Title: Demo1_operator</p>
 * <p>Description: </p>
 * <p>Company: www.wilson.com</p>
 *
 * @author Wilson
 * @version 1.0
 * @date 2019-06-23 10:29
 */
public class Demo1_operator {
    public static void main(String[] args) {
        /*
         * &,|,^,~ 的用法
         * &:有0则0
         * |:有1则1
         * ^:相同则0，不同则1
         * ~:按位取反
         */

        System.out.println(6 & 3);				//2
        System.out.println(6 | 3);				//7
        System.out.println(6 ^ 3);				//5
        System.out.println(~6);					//-7?
    }
}
/*
	110
&	011
-----------
    010

	110
|	011
-----------
    111

	110
^	011
-----------
    101

	00000000 00000000 00000000 00000110		6的原码反码补码都是本身
	11111111 11111111 11111111 11111001		对6取反
-	00000000 00000000 00000000 00000001
---------------------------------------
	11111111 11111111 11111111 11111000		反码
	10000000 00000000 00000000 00000111		原码(-7)
*/