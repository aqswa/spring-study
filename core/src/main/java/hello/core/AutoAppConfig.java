package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //@ComponentScan은 @Component가 붙은 모든 클래스를 스프링 빈으로 등록한다.
        basePackages = "hello.core.member", //지정하지 않으면 @ComponentScan이 붙은 클래스가 있는 패키지부터 하위 패키지를 모두 확인한다.
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
) //컴포넌트 스캔 사용하면 @Configuration이 붙은 설정 정보도 자동으로 등록되기 때문에, 보통 설정 정보를 컴포넌트 스캔에서 제외하지 않지만 기존 예제 코드 남겨두기 위해 제외함.
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
