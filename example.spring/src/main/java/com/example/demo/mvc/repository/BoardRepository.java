package com.example.demo.mvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.mvc.domain.Board;
import com.example.demo.parameter.BoardParameter;

/*
 * °Ô½ÃÆÇ Repository
 * @author = ±èÂù°ï
 */
@Repository
public interface BoardRepository {
	
	List<Board> getList();
	
	Board get(int boardSeq);
	
	void save(BoardParameter board);
	
	void update(Board board);

	void delete(int boardSeq);
}
