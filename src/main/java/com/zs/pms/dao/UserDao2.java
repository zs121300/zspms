package com.zs.pms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zs.pms.po.TUser;
import com.zs.pms.vo.QueryUser;

/**
 * 使用注解
 * @author Administrator
 *
 */
public interface UserDao2 {
	@Select("select * from tuser where sex=#{sex}")
	public List<TUser> queryByCon(QueryUser query);
}
