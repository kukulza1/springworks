package com.khit.todoweb.DTO;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data //getter setter tostring
public class TodoDTO {
	
	private Long tno;
	private String title;
	private String writer;
	private Timestamp createdDate;
	

}
