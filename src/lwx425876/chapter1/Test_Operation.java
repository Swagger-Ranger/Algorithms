package lwx425876.chapter1;

public class Test_Operation {

	static int a =5;
	static void valuePass(int x)
	{
		x +=1;
		System.out.println(x);
	}




	public static void main(String[] args)
	{
		valuePass(a);
		System.out.println(a);
	}
}
