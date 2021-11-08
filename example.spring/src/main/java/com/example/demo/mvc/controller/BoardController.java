package com.example.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.repository.BoardRepository;
import com.example.demo.mvc.service.BoardService;
import com.example.demo.parameter.BoardParameter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/*
 * �Խ��� ��Ʈ�ѷ�
 * @author = ������
 */
@RestController
@RequestMapping("/board")
@Api(tags = "�Խ��� API")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * ��� ����
	 * @return
	 */
	@GetMapping
	@ApiOperation(value = "��� ��ȸ", notes = "�Խù� ��� ������ ��ȸ�մϴ�.")
	public List<Board> getList(){
		return boardService.getList();
	}
	
	/**
	 * �� ���� ����
	 * @param boardSeq
	 * @return
	 */
	@GetMapping("/{boardSeq}")
	@ApiOperation(value = "�� ��ȸ", notes = "�Խù� ��ȣ�� �ش��ϴ� �� ������ ��ȸ�� �� �ֽ��ϴ�.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "�Խù� ��ȣ", example = "1")
	})
	public Board get(@PathVariable int boardSeq) {
		return boardService.get(boardSeq);
	}
	
	/**
	 * ���/���� ó��
	 * @param board
	 */
	@PutMapping("/save")
	@ApiOperation(value = "���/���� ó��", notes = "�ű� �Խù� ���� �� ���� �Խù� ����.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "�Խù� ��ȣ", example = "1"),
		@ApiImplicitParam(name = "title", value = "�Խù� ����", example = "changon_title"),
		@ApiImplicitParam(name = "contents", value = "�Խù� ����", example = "changon_contents"),
	})
	public int save(BoardParameter parameter) {
		boardService.save(parameter);
		return parameter.getBoardSeq();
	}
	
	/**
	 * ���� ó��
	 * @param boardSeq
	 */
	@DeleteMapping("/{boardSeq}")
	@ApiOperation(value = "���� ó��", notes = "�Խù� ��ȣ�� �ش��ϴ� ������ ����.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "�Խù� ��ȣ", example = "1"),
	})
	public boolean delete(@PathVariable int boardSeq) {
		Board board = boardService.get(boardSeq);
		if(board == null) {
			return false;
		}
		boardService.delete(boardSeq);
		return true;
	}
	


}
