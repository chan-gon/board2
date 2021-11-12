package com.example.demo.parameter;

import java.util.List;

import com.example.demo.mvc.domain.BoardType;

import lombok.Data;

/**
 * �Խù� �˻� �Ķ����
 * @author ������
 *
 */
@Data
public class BoardSearchParameter {
	
    private String keyword;
    private List<BoardType> boardTypes;

    public BoardSearchParameter() {

    }

}
