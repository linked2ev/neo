package com.rest.neo.board.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(description = "게시글 모델")
@Getter @Setter
@ToString
public class Board implements Serializable  {

    @ApiModelProperty(value = "게시글 번호", dataType = "Integer", required = true, example = "1")
    public Integer boardIdx;

    @ApiModelProperty(value = "제목", required = true, example = "샘플 제목")
    public String title;

    @ApiModelProperty(value = "내용", required = true, example = "샘플 내용")
    public String contents;

    @ApiModelProperty(value = "노출여부", required = true, example = "Y")
    public String displayYn;

    @ApiModelProperty(value = "조회수", example = "11")
    public int hitCnt;

    @ApiModelProperty(value = "등록 아이디", example = "TEST01")
    public String regId;

    @ApiModelProperty(value = "등록 날짜", example = "20200101")
    public String regDate;

    @ApiModelProperty(value = "수정 아이디", example = "TEST01")
    public String modId;

    @ApiModelProperty(value = "수정 날짜", example = "20200101")
    public String modDate;

}