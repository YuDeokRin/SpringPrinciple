package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;


public class OrderServiceImpl implements OrderService{

    //DIP를 지키고 있다. 즉, 인터페이스에게만 의존을 하고 있다고 하는 것이다.

    // priavate final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy; // DiscountPolicy 인터페이스에 의존

    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final MemberRepository memberRepository; //MemberRepository 인터페이스에 의존

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //  최종적으로 할인된 가격을 받는다

        return new Order(memberId, itemName, itemPrice,discountPrice); // 최종생성된 것(discountPrice)을 반환
    }
}
