package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDsicountPolicy implements DiscountPolicy{

    private int discountPercent = 10 ;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP) { //memeber.getGrade가
            return price * discountPercent /100;
        }else {
            return 0;
        }
    }
}
