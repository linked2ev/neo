package com.rest.neo.board.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ApiModel(description = "게시글 모델" )
@Getter @Setter
@ToString
public class Board implements Serializable  {


    @ApiModelProperty(value = "게시글 번호", dataType = "int", required = true, example = "1")
    public Integer boardIdx;

    @ApiModelProperty(value = "제목", dataType = "string", required = false)
    public String title;

    @ApiModelProperty(value = "내용", required = true , example = "내용")
    public String contents;

    @ApiModelProperty(value = "노출여부", required = true)
    public String displayYn;

    @ApiModelProperty(value = "조회수")
    public int hitCnt;

    @ApiModelProperty(value = "등록 아이디")
    public String regId;

    @ApiModelProperty(value = "등록 날짜")
    public String regDate;

    @ApiModelProperty(value = "수정 아이디")
    public String modId;

    @ApiModelProperty(value = "수정 날짜")
    public String modDate;

}