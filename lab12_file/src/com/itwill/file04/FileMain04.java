package com.itwill.file04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 프로그램 ===> ObjectOutputStream ===> FileOutputStream ===> 파일
 * OOS.writeObject(): 자바 객체를 파일에 쓸 수 있는 형태로 변환(직렬화, serialize).
 * 
 * 프로그램 ObjectInputStream <=== FileInputStream <=== 파일
 * OIS.readObject(): 파일에서 읽은 데이터를 자바 객체로 변환(역직렬화, de-serialize).
 * 
 * (주의) OIS, OOS에서 읽고 쓰려는 자바 클래스는 반드시 Serializable 인터페이스를 구현해야함!
 * 
 * try-with=resource 문법:
 * 		InputStream, OutputStream과 같은 객체들은 사용한 이후에 반드시 
 * 		close() 메서드를 호출해서 사용했던 리소스들을 해제해야 함.
 * try-catch-finally 구문에서는,
 * 객체 생성은 try 블록에서 하고, 리소스 해제는 finally 블록에서 작성.
 * 
 * 
 * 리소스를 생성하면 close() 메서드는 자동으로 호출해 주는 try-catch 문법.
 * 
 * try (리소스 생성;) {
 * 		정상적인 상황에서 실행할 코드들;
 * } catch (예외 타입 변수 선언) {
 * 		예외 상황을 처리할 코드들;
 * }
 */

public class FileMain04 {

	public static void main(String[] args){
		String fileName = "data/product.dat";
		
		// Product 타입 객체를 파일에 쓰기(write):
		try(
				// 리소스 생성 for문의 i처럼 생성된 리소스는 try문 안에서만 사용 가능하다. 
				FileOutputStream out = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(out);
		) {
			// 파일에 쓸 Product 타입의 객체를 생성.
			Product p =new Product(100, "맥북", 10_000);
			
			// 자바 객체를 파일에 씀.
			oos.writeObject(p);
			System.out.println("파일 작성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 파일에서 데이터를 일곡 자바 객체로 변환:
		// 다른 예제들과 다르게 읽기와 쓰기를 따로 하는 이유:
		// 이 예제는 읽기와 쓰기가 한 파일(fileName)에서 이루어지기 때문임.
		
		try ( // try -with -resource 문 : 괄호 안에서 생성한 리소스는 close를 자동으로 해줌.
				FileInputStream in = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(in);
		) {
			Product p2 = (Product) ois.readObject(); 
			// readObj()는 Object 타입이므로 Product로 타입 강제 변환
			// => 우리가 Product로 쓴 파일인 것을 알고있기 때문에 안전한 타입 강제 변환
			System.out.println(p2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
