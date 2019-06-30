package com.grepiu.dbs.process.service;

import com.grepiu.dbs.process.entity.User;
import java.util.List;

/**
 *
 * 유저 서비스
 *
 */
public interface UserService {
  public List<User> getUsers();
  public User saveUser(User user);
  public int saveUserSample() throws Exception;
  public int deleteUser(Long no);
}
