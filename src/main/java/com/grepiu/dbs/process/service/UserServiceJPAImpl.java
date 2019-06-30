package com.grepiu.dbs.process.service;

import com.grepiu.dbs.process.dao.UserRepository;
import com.grepiu.dbs.process.entity.User;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("JPA")
@Transactional(rollbackFor = Exception.class)
public class UserServiceJPAImpl implements UserService {

  private UserRepository userRepository;

  public UserServiceJPAImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public int saveUserSample() throws Exception {
    User user = new User();
    user.setName("IU");
    user.setGender("M");
    user.setEtc("Test");
    user.setAge(20);

    userRepository.save(user);

    User user2 = new User();
    user2.setName("SecondUI");
    user2.setGender("F");
    user2.setEtc("Test2");
    user2.setAge(30);

    throw new Exception("에러를 발생시켜 rollback 확인");
  }

  @Override
  public int deleteUser(Long no) {
    User user = userRepository.findById(no).get();
    userRepository.delete(user);
    return 1;
  }
}
