package cn.mldn.oracle.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.oracle.dao.IMemberDAO;
import cn.mldn.oracle.dao.impl.MemberDAOImpl;
import cn.mldn.oracle.factory.DAOFactory;
import cn.mldn.oracle.service.IMemberService;
import cn.mldn.oracle.vo.Member;

public class MemberServiceImpl implements IMemberService {
	@Override
	public boolean add(Member vo) throws Exception {
		// 1、取得IMemberDAO接口对象
		IMemberDAO dao = DAOFactory.getInstance(MemberDAOImpl.class);
		if (dao.findById(vo.getMid()) == null) {// 2、判断当前的id是否存在
			if (dao.findByPhone(vo.getPhone()) == null) { // 3、电话不存在
				if (vo.getAge() <= 0) { // 没有设置年龄或者设置出错
					vo.setAge(-1); // 使用-1作为一个标志结果
				}
				return dao.doCreate(vo); // 4、进行数据库保存
			}
		}
		return false;
	}
 
	@Override
	public boolean edit(Member vo) throws Exception {
		IMemberDAO dao = DAOFactory.getInstance(MemberDAOImpl.class);
		// 2、要根据电话来查找数据是否已经存在，但是需要考虑到判断的用户不能是自己
		Member temp = dao.findByPhone(vo.getPhone());
		if (temp == null) {
			return dao.doUpdate(vo);
		} else { // 现在电话存在
			if (vo.getMid().equals(temp.getMid())) { // 自己的电话
				return dao.doUpdate(vo);
			}
		}
		return false;
	}

	@Override
	public boolean remove(Set<String> ids) throws Exception {
		if (ids == null || ids.size() == 0) {
			return false;
		}
		return DAOFactory.getInstance(MemberDAOImpl.class).doRemoveBatch(ids);
	}

	@Override
	public Member get(String id) throws Exception {
		return DAOFactory.getInstance(MemberDAOImpl.class).findById(id);
	}

	@Override
	public List<Member> list() throws Exception {
		return DAOFactory.getInstance(MemberDAOImpl.class).findAll();
	}

	@Override
	public Map<String, Object> list(int currentPage, int lineSize) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		IMemberDAO dao = DAOFactory.getInstance(MemberDAOImpl.class);
		map.put("allMembers", dao.findAllSplit(currentPage, lineSize));
		map.put("memberCount", dao.getAllCount());
		return map;
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		IMemberDAO dao = DAOFactory.getInstance(MemberDAOImpl.class);
		if (column == null || keyWord == null || "".equals(keyWord)) {
			map.put("allMembers", dao.findAllSplit(currentPage, lineSize));
			map.put("memberCount", dao.getAllCount());
		} else {
			map.put("allMembers", dao.findAllSplit(column, keyWord, currentPage, lineSize));
			map.put("memberCount", dao.getAllCount(column, keyWord));
		}
		return map;
	}
}
