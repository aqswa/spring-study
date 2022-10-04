package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

public class MainForCPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		ChangePasswordService cps = ctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			cps.changePassword("test@email.com", "0x1.68725f79fffap-6", "q1w2");
			System.out.println("암호를 변경했습니다.");
		}catch(MemberNotFoundException e) {
			System.out.println("회원 데이터가 올바르지 않습니다.");
		}catch(WrongIdPasswordException e) {
			System.out.println("암호가 올바르지 않습니다.");
		}
		
		ctx.close();
	}

}
