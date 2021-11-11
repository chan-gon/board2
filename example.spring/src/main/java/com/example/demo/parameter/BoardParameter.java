package com.example.demo.parameter;

import com.example.demo.mvc.domain.BoardType;

import lombok.Data;

@Data
public class BoardParameter {
	private int boardSeq;
	private String title;
	private String contents;
	private BoardType boardType;
}
