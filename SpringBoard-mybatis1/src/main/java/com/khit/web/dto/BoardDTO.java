package com.khit.web.dto;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class BoardDTO {
  private Long id;
  private String boardtitle;
  private String  boardwriter ;
  private String   boardcontent ;
  private Timestamp createtime;
  private Timestamp updatetime;
}
