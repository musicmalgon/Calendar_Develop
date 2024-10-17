package com.sparta.todo;

import com.sparta.todo.entity.Todo;
import com.sparta.todo.repository.TodoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TodoTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    TodoRepository todoRepository;

    @Test
    @Transactional
    @Rollback(value = false) // 테스트 코드에서 @Transactional 를 사용하면 테스트가 완료된 후 롤백하기 때문에 false 옵션 추가
    @DisplayName("메모 생성 성공")
    void test1() {
        Todo todo = new Todo();
        todo.setUsername("Robbert");
        todo.setTitle("제목");
        todo.setContents("@Transactional 테스트 중!");

        em.persist(todo);  // 영속성 컨텍스트에 메모 Entity 객체를 저장합니다.
    }

    @Test
    @Disabled
    @DisplayName("메모 생성 실패")
    void test2() {
        Todo todo = new Todo();
        todo.setUsername("Robbie");
        todo.setContents("@Transactional 테스트 중!");

        em.persist(todo);  // 영속성 컨텍스트에 메모 Entity 객체를 저장합니다.
    }

    @Test
//    @Transactional
//    @Rollback(value = false)
    @Disabled
    @DisplayName("트랜잭션 전파 테스트")
    void test3() {
//        todoRepository.createTodo(em);
        System.out.println("테스트 test3 메서드 종료");
    }
}