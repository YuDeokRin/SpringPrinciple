package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //관심사 분리 하고 appconfig를 만들 어 준 후
    private final MemberRepository memberRepository;
    //관심사 분리 하고 appconfig를 만들어 주기 전 : private final MemberRepository memberRepository = new MemoryMemberRepository();


    // 생성자 생성
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // join에서 save을 호출하면 다형성에 의해서 MemoryMemberRepository안에 있는 save가 실행이된다 .cf memberRepository 인터페이스 아님
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
