package cn.yang.test.day;

public class Demo_replace {
	public static void main(String[] args) {
		String src = new String("ab43a2c43d");
		System.out.println(src.replace("3", "f"));
//	=>ab4f2c4fd.   　　
		System.out.println(src.replace('3', 'f'));
//	=>ab4f2c4fd.   　　
		System.out.println(src.replaceAll("\\d", "f"));
//	=>abffafcffd.   　
		System.out.println(src.replaceAll("a", "f"));
//	=>fb43fc23d.   　
		System.out.println(src.replaceFirst("\\d", "f"));
//	 =>abf32c43d   
		System.out.println(src.replaceFirst("4", "h"));
//	=>abh32c43d.
	}
}
