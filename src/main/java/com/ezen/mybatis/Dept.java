package com.ezen.mybatis;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Dept {
	private Integer deptId;
	private String deptName;
	private String locName;
	private List <Employee> employee;
}

