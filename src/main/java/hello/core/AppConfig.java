package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
 * AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.
 */

//AppConfig에 설정을 구성한다는 뜻의 @Configuration을 붙여준다.
@Configuration
public class AppConfig {

    // 각 메서드에 @Bean을 붙여준다. 이렇게하면 스프링 컨테이너에 스프링 빈으로 등록한다.

    @Bean
    public MemberService memberService(){ // key 는 빈이름(memberService ) 되고 value(값)는 빈의 객체(MemberServiceImpl)가 된다.
        return new MemberServiceImpl(memberRepository()); // 객체(new 인스턴스)가 들어간다 -> 생성자 주입
    }



    @Bean
    public MemberRepository memberRepository() { // 역할
        return new MemoryMemberRepository(); // 구현
    }


    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//    return new FixDiscountPolicy();
      return new RateDiscountPolicy();
    }
}
