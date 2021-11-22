package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDsicountPolicyTest {

    RateDiscountPolicy dsicountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.BASIC); // VIP회원(member) 만들기

        //when
        int discount = dsicountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0); // 할인되는 가격이 1000원 맞니 ?
    }


    // 실패 테스트도 만들어서 확인해봐야한다.
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        //when
        int discount = dsicountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}