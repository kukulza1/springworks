package com.khit.todoweb.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PageRequestDTO { //�Ķ����(page,kw) ������DTO
	
	
	private int page =1 ;
	private int size= 15; //�������� �Խñۼ�
	
	private String[] types; //�˻�����
	private String keyword; //�˻���
	
	
	public int getSkip() { //#{skip}
		return (page -1)*10; //1p-0, 2p-10
	}

	

}
