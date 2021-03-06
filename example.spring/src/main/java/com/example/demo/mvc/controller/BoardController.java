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
import com.example.demo.mvc.domain.MenuType;
import com.example.demo.mvc.service.BoardService;
import com.example.demo.parameter.BoardParameter;
import com.example.demo.parameter.BoardSearchParameter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;


/*
 * 게시판 컨트롤러
 * @author = 김찬곤
 */
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * 목록 리턴
	 * @return
	 */
	@GetMapping("{menuType}")
	@ApiOperation(value = "목록 조회", notes = "게시물 목록 정보를 조회합니다.")
	public String list(@PathVariable MenuType menuType, BoardSearchParameter paramter, org.springframework.ui.Model model){
		List<Board> boardList = boardService.getList(paramter);
		model.addAttribute("boardList", boardList);
		model.addAttribute("menuType", menuType);
		return "/board/list";
	}
	
	/**
	 * 상세 페이지
	 * @param boardSeq
	 * @return
	 */
	@GetMapping("/{menuType}/{boardSeq}")
	public String detail(@PathVariable MenuType menuType ,@PathVariable int boardSeq, org.springframework.ui.Model model) {
		Board board = boardService.get(boardSeq);
		model.addAttribute("board", board);
		model.addAttribute("menuType", menuType);
		return "/board/detail";
	}
	
	/**
	 * 등록 화면
	 * @param parameter
	 * @param model
	 */
	@GetMapping("/{menuType}/form")
	public String form(@PathVariable MenuType menuType, BoardParameter parameter, org.springframework.ui.Model model) {
		model.addAttribute("parameter", parameter);
		model.addAttribute("menuType", menuType);
		return "/board/form";
	}
	
	/**
	 * 수정 화면
	 * @param parameter
	 * @param model
	 */
	@GetMapping("/{menuType}/edit/{boardSeq}")
	public String edit(@PathVariable MenuType menuType, @PathVariable(required = true) int boardSeq, BoardParameter parameter, org.springframework.ui.Model model) {
		Board board = boardService.get(parameter.getBoardSeq());
		if(board == null) {
			throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] { "게시물" });
		}
		model.addAttribute("board", board);
		model.addAttribute("parameter", parameter);
		model.addAttribute("menuType", menuType);
		return "/board/form";
	}
	
	/**
	 * 등록/수정 처리
	 * @param board
	 */
	@PostMapping("/{menuType}/save")
	@ResponseBody
	@ApiOperation(value = "등록/수정 처리", notes = "신규 게시물 저장 및 기존 게시물 수정.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
		@ApiImplicitParam(name = "title", value = "게시물 제목", example = "changon_title"),
		@ApiImplicitParam(name = "contents", value = "게시물 내용", example = "changon_contents"),
	})
	public BaseResponse<Integer> save(BoardParameter parameter) {
		// 제목 필수 체크
		if(ObjectUtils.isEmpty(parameter.getTitle())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "title", "제목" });
		}
		// 내용 필수 체크
		if (ObjectUtils.isEmpty(parameter.getContents())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "contents", "내용" });
		}
		boardService.save(parameter);
		return new BaseResponse<Integer>(parameter.getBoardSeq());
	}
	
	/**
	 * 삭제 처리
	 * @param boardSeq
	 */
	@DeleteMapping("/{boardSeq}")
	@ApiOperation(value = "삭제 처리", notes = "게시물 번호에 해당하는 정보를 삭제.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1"),
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
