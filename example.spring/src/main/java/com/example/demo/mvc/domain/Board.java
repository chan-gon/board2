package com.example.demo.mvc.domain;

import java.util.Date;

import lombok.Data;

/**
 * �Խù�
 * @author ������
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
