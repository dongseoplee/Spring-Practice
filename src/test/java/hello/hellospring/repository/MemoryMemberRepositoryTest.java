package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member(); //member 객체를 만들고
        member.setName("spring"); //member 객체의 name을 spring으로 설정한다

        repository.save(member); //save 메소드 호출되면서 member 객체의 Id도 같이 설정됨

        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);

    }

    @Test
    public void findByName() {
        /*
        * 1. 객체 만들기
        * 2. 이름 설정하기 setName()
        * 3. save하기 (Id는 자동으로 설정됨)*/
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
