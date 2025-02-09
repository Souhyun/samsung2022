package com.exam.todojpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.todojpa.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
	Optional<Todo>	findTodoByTodo(String todo);
	List<Todo> findTodoByTodoStartingWith(String todo);
	List<Todo> findTodoByIdGreaterThan(Long id);
	List<Todo> findTodoByIdGreaterThan(Long id, Pageable pageable);
	
	@Query("select t  from Todo t where t.todo like %:todo%")  //jpql  
	List<Todo> findTodos(@Param("todo")String todo, Pageable pageable);
	
	@Query(value = "select id,todo,done from todos where todo like %:todo%", nativeQuery = true)
	List<Todo> findTodos2(@Param("todo") String todo, Pageable pageable);
}
