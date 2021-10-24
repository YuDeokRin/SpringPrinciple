package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    /**
     *  주문생성요청이오면 먼저 회원정보 조회를 하고 정보를 최종적으로 할인딘 가격을 판단하여 discountPrice에 넣는다
     *
     *  회원(member)을 넘긴다 . 고민? Grade만 넘길지 member를 넘길지? (상황마다 다르다)
     */
    private final MemberRepository memberRepository = new MemoryMemberRepository(); //메모리 회원 리포지토리(구현체)
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //고정 할인 정책(구현체)

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //  최종적으로 할인된 가격을 받는다

        return new Order(memberId, itemName, itemPrice,discountPrice); // 최종생성된 것(discountPrice)을 반환
    }
}
