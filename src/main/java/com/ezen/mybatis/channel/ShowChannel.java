package com.ezen.mybatis.channel;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ShowChannel {
	private int chanId;
	private String 진행자;
	private String 주제;
	private List<ShowViewer> viewers;
}
