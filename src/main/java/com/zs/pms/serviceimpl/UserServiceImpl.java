package com.zs.pms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zs.pms.dao.UserDao;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.Constants;
import com.zs.pms.vo.QueryUser;
@Service
@Transactional//需要开启事务的业务对象
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao dao;
	public List<TUser> queryByPage(int page,QueryUser query) {
		//通过当前页面计算起始数和截止数
		//起始数从一开始
		int start =(page-1) * Constants.pagecont+1;
		//截止数
		int end =page * Constants.pagecont;
		
		query.setStart(start);
		query.setEnd(end);
		return dao.queryByPage(query);
		
	}
	
	//计算总页数
	public int queryPageCont(QueryUser query) {
		//通过总条数计算总页数
		int cont=dao.queryCount(query);
		//能整除
		if(cont%Constants.pagecont==0) {
			return cont/Constants.pagecont;
		}
		else {
			return cont/Constants.pagecont+1;
		}
		
	}
	
	@Override
	public void hello() {
		// TODO Auto-generated method stub
		System.out.println("hello Spring");
	}

	@Override
	public List<TPermission> queryByUid(int id) {
		// TODO Auto-generated method stub
		return dao.queryByUid(id);
	}

	@Override
	public List<TPermission> genMenu(List<TPermission> pers) {
		//创建新容器
		List<TPermission> list=new ArrayList<>();
		//遍历权限列表
		for(TPermission per:pers) {
			//一级菜单
			if(per.getLev()== 1) {
				//加载该一级菜单的二级菜单
				//遍历
				for(TPermission per2:pers) {
					//二级权限的上级id等于一级权限id
					if(per2.getPid()==per.getId()) {
						//添加子权限
						per.addChlid(per2);
					}
				}
				//加到新的集合中
				list.add(per);
			}
		}
		return list;
	}

	@Override
	public List <TUser> queryByCon(QueryUser query) {
		// TODO Auto-generated method stub
		return dao.queryByCon(query);
	}

	@Override
	public void deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		dao.deleteByIds(ids);
	}

	@Override
	public void updateUser(TUser user) {
		// TODO Auto-generated method stub
		dao.updateUser(user);
	}

	@Override
	//有异常就回滚事务
	@Transactional(rollbackFor=Exception.class)
	public int insertUser(TUser user) {
		// TODO Auto-generated method stub
		//新增
		dao.insertUser(user);
		
		//返回主键
		return user.getId();
	}

	

	

	

	

}
