package com.example.demo.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.exception.BaseException;
import com.example.demo.configuration.http.BaseResponse;
import com.example.demo.configuration.http.BaseResponseCode;
import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.service.BoardService;
import com.example.demo.parameter.BoardParameter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;


/*
 * �Խ��� ��Ʈ�ѷ�
 * @author = ������
 */
@Controller
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
	@ResponseBody
	@ApiOperation(value = "��� ��ȸ", notes = "�Խù� ��� ������ ��ȸ�մϴ�.")
	public BaseResponse<List<Board>> getList(){
		return new BaseResponse<List<Board>>(boardService.getList());
	}
	
	/**
	 * �� ���� ����
	 * @param boardSeq
	 * @return
	 */
	@GetMapping("/{boardSeq}")
	@ResponseBody
	@ApiOperation(value = "�� ��ȸ", notes = "�Խù� ��ȣ�� �ش��ϴ� �� ������ ��ȸ�� �� �ֽ��ϴ�.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "�Խù� ��ȣ", example = "1")
	})
	public BaseResponse<Board> get(@PathVariable int boardSeq) {
		Board board = boardService.get(boardSeq);
		if(board == null) {
			throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] { "�Խù�" });
		}
		return new BaseResponse<Board>(board);
	}
	
	/**
	 * ���/���� ȭ��
	 * @param parameter
	 * @param model
	 */
	@GetMapping("/form")
	public void home(BoardParameter parameter, org.springframework.ui.Model model) {
		if(parameter.getBoardSeq() > 0) {
			Board board = boardService.get(parameter.getBoardSeq());
			model.addAttribute("board", board);
		}
		model.addAttribute("parameter", parameter);
	}
	
	/**
	 * ���/���� ó��
	 * @param board
	 */
	@PostMapping("/save")
	@ResponseBody
	@ApiOperation(value = "���/���� ó��", notes = "�ű� �Խù� ���� �� ���� �Խù� ����.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "�Խù� ��ȣ", example = "1"),
		@ApiImplicitParam(name = "title", value = "�Խù� ����", example = "changon_title"),
		@ApiImplicitParam(name = "contents", value = "�Խù� ����", example = "changon_contents"),
	})
	public BaseResponse<Integer> save(BoardParameter parameter) {
		// ���� �ʼ� üũ
		if(ObjectUtils.isEmpty(parameter.getTitle())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "title", "����" });
		}
		// ���� �ʼ� üũ
		if (ObjectUtils.isEmpty(parameter.getContents())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "contents", "����" });
		}
		boardService.save(parameter);
		return new BaseResponse<Integer>(parameter.getBoardSeq());
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
	public BaseResponse<Boolean> delete(@PathVariable int boardSeq) {
		Board board = boardService.get(boardSeq);
		if(board == null) {
			return new BaseResponse<Boolean>(false);
		}
		boardService.delete(boardSeq);
		return new BaseResponse<Boolean>(true);
	}

}
