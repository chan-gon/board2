package com.example.demo.mvc.domain;

import java.util.Date;

import lombok.Data;

/**
 * °Ô½Ã¹°
 * @author ±èÂù°ï
 *
 */
@Data
public class Board {
	private int boardSeq;
	private BoardType boardType;
	private String title;
	private String contents;
	private int viewCount;
	private Date regDate;
}
