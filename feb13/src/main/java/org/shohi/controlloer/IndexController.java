package org.shohi.controlloer;
import javax.inject.Inject;

import org.shohi.human.Human;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//2024-02-13
//새로운 컨트롤러 생성
/*
 * @Controller : 객체생성_컨트롤러 생성
 * @Service : 객체생성_서비스 생성
 * @Repository : 객체생성_Repository 생성(DAO)
 * @Component : 그 외 객체로 생성(Util만들 때 사용하곤 한다.)
 * 
 */

@Controller
public class IndexController {
	
	/*
	 * 주입
	 * @autoWired : 스프링 제공_객체의 타입으로 거사 (Spring 제공)
	 * 		@Qualifier("") 
	 * @inject : 객체의 타입이 일치하면 자동 주입 (Java 제공)
	 * 		@name("")
	 * @resources : id가 일치하는 것 주입 (Java 제공)
	 * 		@Resource(name="")
	 */
	@Inject
	private Human human;
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	//@RequestMapping(value = "/", method = RequestMethod.POST)
	//@RequestMapping(value = "/")
	//@RequestMapping("/") 
	//@GetMapping(value = "/")
	@GetMapping("/")
	public String home() {
		
//		이게 지금까지 해오던 방식
		//Human h = new Human();
		//h.setAge(10);
		//h.setName("박쇼");
		
		System.out.println(human.getAge()); //0
		System.out.println(human.getName()); //null
		
		
		
		return "index";			// return index = /WEB-INF/views/index.jsp
	}
	
	
	

}
