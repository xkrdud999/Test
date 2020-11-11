package com.my.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.my.user.dao.IUserRepository;
import com.my.user.vo.UserVO;

@Service
public class UserService implements IUserService {
	
	@Autowired
	
	IUserRepository UserRepository;
	
	
	@Autowired
	BCryptPasswordEncoder bpe; //비밀번호 암호화

	@Override
	public void userJoin(UserVO vo) {
		vo.setUserPw(bpe.encode(vo.getUserPw()));
		UserRepository.userJoin(vo);
		
	}

	

	@Override
	public String getPassword(String userId) {
		
		return UserRepository.getPassword(userId);
	}

	@Override
	public UserVO getUser(String userId) {
		
		return UserRepository.getUser(userId);
	}



	@Override
	public int idCheck(String userId) {
		
		return UserRepository.idCheck(userId);
	}

	
	

}
