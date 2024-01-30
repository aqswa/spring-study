package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//역할과 구현 클래스가 한눈에 들어와 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악 가능하다.
//AppConfig보다 스프링 컨테이너를 쓰는 것이 뭐가 더 좋은가?
@Configuration //@Bean만 사용해도 스프링 빈으로 등록되지만, 싱글톤을 보장하지 않음. memberRepository()처럼 의존관계 주입이 필요해서 메서드를 직접 호출할 때 싱글톤 보장 X
public class AppConfig {

    //생성자 주입
    //appConfig 객체가 memoryMemberRepository 객체를 생성하고 그 참조값을 memberServiceImpl 생성자로 전달한다.
    //클라이언트인 memberServiceImpl 입장에서 보면 의존관계를 외부에서 주입해주는 것 같다고 해서 DI(의존관계 주입)이라고 한다.

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    //-> MemoryMemberRepository가 2개 생성되면서 싱글톤이 깨지는가?

    //예상
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //실제
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
