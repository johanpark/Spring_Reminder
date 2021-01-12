package com.gsitm.career.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gsitm.career.mybatis.type.CamelCaseMap;

@Repository
public interface DemoMapper {

	List<CamelCaseMap> selectUser();
}
