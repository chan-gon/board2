package com.example.demo.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.repository.BoardRepository;
import com.example.demo.parameter.BoardParameter;
import com.example.demo.parameter.BoardSearchParameter;


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
	public List<Board> getList(BoardSearchParameter parameter){
		return repository.getList(parameter);
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
	 * ���/���� ó��
	 * @param board
	 */
	public void save(BoardParameter parameter) {
		// ��ȸ�Ͽ� ���ϵ� ����
		Board board = repository.get(parameter.getBoardSeq());
		if(board == null) {
			repository.save(parameter);
		}else {
			repository.update(parameter);
		}
	}
	
	/**
	 * ���� ó��
	 * @param boardSeq
	 */
	public boolean delete(int boardSeq) {
		repository.delete(boardSeq);
		return true;
	}


}
