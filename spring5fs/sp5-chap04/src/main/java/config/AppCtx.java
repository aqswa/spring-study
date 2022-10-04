package config;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberPrinter;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"spring"})
public class AppCtx {
	
	//스캔할 때 사용하는 빈 이름 = 수동 등록한 빈 이름(memberDao)
	//일 경우 수동 등록한 빈이 우선한다. 
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

//이 경우 스캔으로 등록한 "memberDao" 빈과 수동 등록한 "memberDao2" 빈이 모두 존재
//	@Bean
//	public MemberDao memberDao2() {
//		MemberDao memberDao = new MemberDao();
//		return memberDao;
//	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
