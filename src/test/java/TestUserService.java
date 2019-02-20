import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUserService {
@Autowired
UserService us;

public void testHello() {
	us.hello();
}

public void testlogin(){
	List<TPermission> list1 =us.queryByUid(3022);
	for (TPermission per:list1) {
		System.out.println(per.getPname());
	}
	System.out.println("------------整理后---------------");
	for(TPermission per1:us.genMenu(list1)) {
		//一级权限
		System.out.println(per1.getPname());
		for(TPermission per2:per1.getChildren()) {
			System.out.println("----"+per2.getPname());
		}
	}
}

@Test
public void testQuery() {
	//创建查询对象
	QueryUser query=new QueryUser();
	//query.setLoginname("");
	//query.setPassword("321");
	query.setSex("男");
	//System.out.println(query.getIsenabled());
	for(TUser user:us.queryByPage(2, query)) {
		System.out.println(user.getId()+","+user.getLoginname());
	}
	System.out.println("共"+us.queryPageCont(query)+"页");
}
//删除
public void testDeletes() {
	int[] ids= {3022};
	us.deleteByIds(ids);
}
//修改

public void testUpdate() {
	TUser user =new TUser();
	user.setId(3233);
	TDep dep =new TDep();
	dep.setId(6);
	user.setDept(dep);
	user.setEmail("update@123.com");
	user.setIsenabled(-1);
	user.setLoginname("update123");
	user.setPassword("update123123");
	user.setRealname("修改数据112");
	user.setSex("女");
	user.setUpdator(2000);
//	user.setBirthday(new Date());
	us.updateUser(user);
}
//新增

public void testInsert() {
	TUser user =new TUser();
	//user.setId(3044);
	TDep dep =new TDep();
	dep.setId(6);
	user.setDept(dep);
	user.setEmail("insert@123.com");
	user.setIsenabled(-1);
	user.setLoginname("insert123");
	user.setPassword("insert123123");
	user.setRealname("新增数据112");
	user.setSex("男");
	user.setCreator(1000);
    user.setBirthday(new Date());
	System.out.println(us.insertUser(user));
	
}
}
