package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor //final이 붙은 필수 필드들을 모아서 생성자 만들어줌.
public class OrderServiceImpl implements OrderService{

    //DIP를 지키고 있음. 인터페이스에 대해서만 알고 구체적인 클래스에 대해서는 모름.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //의존성 생성자 주입의 장점: 불변, 누락을 막는다.
    //- final 키워드 넣어서 생성자 작성 시 실수를 막음
    //- 순수 자바 코드로 단위테스트 시 값을 넣지 않는 실수를 막음
/*    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }*/

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
