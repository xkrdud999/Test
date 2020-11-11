package com.my.user.service;

import com.my.user.vo.UserVO;

public interface IUserService {
	
	public void userJoin(UserVO vo);
	public String getPassword(String userId);
	public UserVO getUser(String userId);
	public int idCheck(String userId);


}
