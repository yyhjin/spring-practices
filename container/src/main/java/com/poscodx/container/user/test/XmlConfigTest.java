package com.poscodx.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.poscodx.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto Configuration(Annotation Scanning)
//		testApplicationContext01();
		
		// XML Auto Configuration(Annotation Scanning)
//		testApplicationContext02();
		
		// XML Auto Configuration(Annotation Scanning)
//		testBeanFactory01();
		
		// XML Bean Configuration(Explicit Configuration)
		testBeanFactory02();
		
	}

	private static void testApplicationContext01() {
		// 컨테이너만 바꿔준 것. 설정 파일은 동일하게 사용함
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/poscodx/container/user/applicationContext01.xml");
		
		User user = null;
		
		// Type으로 빈 가져오기
		user = ac.getBean(User.class);
		System.out.println(user.getName());
		
		// id로 빈 가져오기
		/* Annotation Scan(Auto Configuration) 에서는 Bean id가 자동으로 부여됨, 
		 	따라서 applicationContext01.xml에 id 설정 안해도 됨 */
		user = (User) ac.getBean("user");
		System.out.println(user.getName());
	}

	private static void testApplicationContext02() {
		// 컨테이너만 바꿔준 것. 설정 파일은 동일하게 사용함
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/poscodx/container/config/user/applicationContext02.xml");
		
		User user = null;
		
		// id로 빈 가져오기 - applicationContext02.xml에 id 설정 안해주면 오류남
		user = (User) ac.getBean("user");
		System.out.println(user.getName());
		
		// name으로 빈 가져오기
		// id로 빈을 찾고 없으면 name으로 찾아서 가져옴
		user = (User) ac.getBean("usr");
		System.out.println(user.getName());
		
		// Type으로 빈 가져오기
		// 같은 타입의 빈이 2개 이상 있으면 Type으로 가져오기는 실패함
		user = ac.getBean("user2", User.class);
		System.out.println(user);
		
		// 파라미터 2개인 생성자로 생성된 빈1 가져오기
		user = ac.getBean("user3", User.class);
		System.out.println(user);		
		
		// 파라미터 2개인 생성자로 생성된 빈2 가져오기
		user = ac.getBean("user4", User.class);
		System.out.println(user);		
		
		// setter를 사용한 빈1 가져오기
		user = ac.getBean("user5", User.class);
		System.out.println(user);		
		
		// setter를 사용한 빈2 가져오기: DI
		user = ac.getBean("user6", User.class);
		System.out.println(user);		
		
		// setter를 사용한 빈3 가져오기: Collection Property
		user = ac.getBean("user7", User.class);
		System.out.println(user);		
		
	}
	
	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscodx/container/config/user/applicationContext01.xml"));
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}
	
	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscodx/container/config/user/applicationContext02.xml"));
		User user = bf.getBean("user", User.class);
		System.out.println(user.getName());
		
	}

}
