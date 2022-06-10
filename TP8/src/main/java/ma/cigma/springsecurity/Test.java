package ma.cigma.springsecurity;

import java.lang.reflect.Method;

public class Test {
	
	@Info(nom="LLLLLLLLLLLLLL",comment="mmmmmmmmmmmmmmmmmmmmmmmm")
	public void init(String a) {
		
	}
	
	@Info(nom="bbbbb",comment="yyyyyy")
	public void test1(Double a,Boolean b) {
		
	}
	
	public static void main(String[] args) {
		try {
			Method methodTest=Test.class.getMethod("test1", Double.class,Boolean.class);
			Info infoAnnation=methodTest.getAnnotation(Info.class);
			String nom=infoAnnation.nom();
			String comment=infoAnnation.comment();
			System.out.println(nom + "   " + comment);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
