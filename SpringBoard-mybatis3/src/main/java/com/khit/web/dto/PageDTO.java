package com.khit.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Data
public class PageDTO {
	
	private int page;        //����������
	private int startPage;   //���������� ���� ���� ������ ��
	private int maxPage;     //�ִ�������(�Խñ����Ѱ��������� ������)
	private int endPage;     //���������� ���� ������ ������ ��

}





























