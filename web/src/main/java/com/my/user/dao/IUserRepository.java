package com.my.user.dao;

import com.my.user.vo.UserVO;

public interface IUserRepository {
	
	public void userJoin(UserVO vo);
	public String getPassword(String userId);
	public UserVO getJoin(String userId);
	public UserVO getUser(String userId);
	public int idCheck(String userId);
	
	
	
}
