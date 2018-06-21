package com.runner.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.runner.common.bean.Friendrecord;
import com.runner.common.bean.Graderecord;
import com.runner.common.bean.Memberinfo;
import com.runner.common.bean.Pointaction;
import com.runner.common.bean.Pointrecord;
import com.runner.common.exception.DataAccessException;
import com.runner.common.exception.MemberServiceException;
import com.runner.dao.IMemberDao;
import com.runner.service.IMemberService;
@Service
public class IMemberInfoImpl implements IMemberService {
	@Resource
	IMemberDao dao;
	@Override
	public void registerMemberinfo(Memberinfo memberinfo) throws MemberServiceException {
		try {
			System.out.println("-------------------");
			dao.saveOrUpdateMemberinfo(memberinfo);
			System.out.println("---------saveOrUpdateMemberinfo------------");
			System.out.println(dao.findMemberinfoByName(memberinfo.getNickName()));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Memberinfo findMemberinfoByName(String nickname) throws MemberServiceException {
		return null;
	}

	@Override
	public Memberinfo login(String username, String passwd) throws MemberServiceException {
		return null;
	}

	@Override
	public void logout(String nickname) throws MemberServiceException {
		
	}

	@Override
	public List<Memberinfo> findMemberinfoByNum(int number) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findMemberinfoOnline() throws MemberServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Graderecord findMemberinfoLevel(Long point) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Memberinfo saveOrUpDate(Memberinfo memberinfo, String oldPasswd) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBackPasswd(String nickname, String pwdQuestion, String pwdAnswer) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Memberinfo memberinfo) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(String selfname, String friendname) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Memberinfo> listFriend(String selfname) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveToBlack(String selfname, String blackname) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Memberinfo> listBlack(String selfname) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Friendrecord findFriend(String friend) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isMemberspace(Long id) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveToFriend(String selfName, String name_searching) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleleBlack(String selfName, String black) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleleFriend(String selfName, String friend) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delSpace(Long id) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pointaction findPointactionByPointAction(String actionName) throws MemberServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Pointrecord pointrecord) throws MemberServiceException {
		// TODO Auto-generated method stub
		
	}

}
