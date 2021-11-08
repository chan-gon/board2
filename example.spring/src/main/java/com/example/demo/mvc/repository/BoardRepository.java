package com.example.demo.mvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.mvc.domain.Board;

/*
 * °Ô½ÃÆÇ Repository
 * @author = ±èÂù°ï
 */
@Repository
public interface BoardRepository {
	
	List<Board> getList();
	
	Board get(int boardSeq);
	
	void save(Board board);
	
	void delete(int boardSeq);
	
	void update(Board board);

}
