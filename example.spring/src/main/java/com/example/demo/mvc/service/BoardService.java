package com.example.demo.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.repository.BoardRepository;


/*
 * �Խ��� ����
 * @author = ������
 */
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository repository;
	
	/**
	 * ��� ����
	 * @return
	 */
	public List<Board> getList(){
		return repository.getList();
	}
	
	/**
	 * �� ���� ����
	 * @param boardSeq
	 * @return
	 */
	public Board get(int boardSeq) {
		return repository.get(boardSeq);
	}
	
	/**
	 * ��� ó��
	 * @param board
	 */
	public int save(Board board) {
		repository.save(board);
		return board.getBoardSeq();
	}
	
	/**
	 * ���� ó��
	 * @param boardSeq
	 */
	public void delete(int boardSeq) {
		repository.delete(boardSeq);
	}
	
	/**
	 * ������Ʈ ó��
	 * @param board
	 */
	public void update(Board board) {
		repository.update(board);
	}

}
