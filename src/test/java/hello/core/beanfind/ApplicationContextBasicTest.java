package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
//        System.out.println("memberService = " + memberService);
//        System.out.println("memberService = getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        //구체 타입으로 조회가 안좋은 이유는 : 1. 역할과 구현을 구분 원칙 , 2.역할에 의존 원칙 ,즉 유연성이 떨어진다.
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    /*
     *  항상 실패 테스트를 만들어 놔라.
     *
     *  NoSuchBeanDefinitionException: No bean named 'xxxxx' available << 'xxxxx'라는 이용가능한 스프링 빈이 존재 하지 않음.
     */
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX1(){
        ac.getBean ("xxxx", MemberService.class);
        MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);

    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
//         ac.getBean ("xxxx", MemberService.class);
//        MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
    }

}
