package com.example.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.repository.BoardRepository;
import com.example.demo.mvc.service.BoardService;


/*
 * �Խ��� ��Ʈ�ѷ�
 * @author = ������
 */
@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * ��� ����
	 * @return
	 */
	@GetMapping
	public List<Board> getList(){
		return boardService.getList();
	}
	
	/**
	 * �� ���� ����
	 * @param boardSeq
	 * @return
	 */
	@GetMapping("/{boardSeq}")
	public Board get(@PathVariable int boardSeq) {
		return boardService.get(boardSeq);
	}
	
	/**
	 * ���/���� ó��
	 * @param board
	 */
	@GetMapping("/save")
	public int save(Board board) {
		boardService.save(board);
		return boardService.save(board);
	}
	
	/**
	 * ���� ó��
	 * @param boardSeq
	 */
	@GetMapping("/delete/{boardSeq}")
	public void delete(@PathVariable int boardSeq) {
		boardService.delete(boardSeq);
	}
	


}
