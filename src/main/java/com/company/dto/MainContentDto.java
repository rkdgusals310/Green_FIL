package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainContentDto {
	private int content_no;
	private String content_url;
	private String content_date;
	private int user_no;
	private int group_no;
	private int feel_no;
}
