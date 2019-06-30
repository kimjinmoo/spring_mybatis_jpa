package com.grepiu.dbs.process.service;

import com.grepiu.dbs.process.dao.UserDao;
import com.grepiu.dbs.process.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("MYBATIS")
@Transactional(rollbackFor = Exception.class)
public class UserServiceMybatisImpl implements UserService {

  private UserDao userDao;

  public UserServiceMybatisImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public List<User> getUsers() {
    return userDao.getUsers();
  }

  @Override
  public User saveUser(User user) {
    return null;
  }

  @Override
  public int saveUserSample() throws Exception {
    User user = new User();
    user.setName("IU");
    user.setGender("M");
    user.setEtc("Test");
    user.setAge(20);

    userDao.saveUser(user);

    User user2 = new User();
    user2.setName("SecondUI");
    user2.setGender("F");
    user2.setEtc("Test2");
    user2.setAge(30);

    throw new Exception("에러를 발생시켜 rollback 확인");
  }

  @Override
  public int deleteUser(Long no) {
    return 0;
  }
}
