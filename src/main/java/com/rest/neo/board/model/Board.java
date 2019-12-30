package com.rest.neo.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter
@ToString
public class Board implements Serializable  {

    public Integer boardIdx;

    public String title;

    public String contents;

    public String displayYn;

    public int hitCnt;

    public String regId;

    public String regDate;

    public String modId;

    public String modDate;
}