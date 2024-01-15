package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    //생성자 주입
    //appConfig 객체가 memoryMemberRepository 객체를 생성하고 그 참조값을 memberServiceImpl 생성자로 전달한다.
    //클라이언트인 memberServiceImpl 입장에서 보면 의존관계를 외부에서 주입해주는 것 같다고 해서 DI(의존관계 주입)이라고 한다.
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
