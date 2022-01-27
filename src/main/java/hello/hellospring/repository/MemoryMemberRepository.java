package hello.hellospring.repository;

import hello.hellospring.domain.Member; //Member 클래스 import (getter, setter)

import java.util.*;

//MemberRepository 인터페이스 implements
public class MemoryMemberRepository implements MemberRepository {


    private static Map<Long, Member> store = new HashMap<>(); //<key, value>
    private static long sequence = 0L;

    //MemberRepository 인터페이스 메소드 재정의
    @Override
    public Member save(Member member) {
        member.setId(++sequence); //Id 설정
        store.put(member.getId(), member); //설정한 Id와 member Map에 추가
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(store.get(id)); //key값인 id로 value값인 member 반환
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {

        return new ArrayList<>(store.values());
    }

    public void clearStore() {

        store.clear();
    }
}
