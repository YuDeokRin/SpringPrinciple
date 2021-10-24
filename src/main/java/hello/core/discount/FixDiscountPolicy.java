package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int pirce) {
        if(member.getGrade() == Grade.VIP){ // VIP일 경우 1000원 할인
            return discountFixAmount;
        }else{  // VIP 아닐 시 discount없음
            return 0;
        }
    }
}
