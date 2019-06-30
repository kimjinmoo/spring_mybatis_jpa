package com.grepiu.dbs.process.dao;

import com.grepiu.dbs.process.entity.User;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;

  public List<User> getUsers() {
    return sqlSessionTemplate.selectList("user.getUsers");
  }

  public int saveUser(User user) {
    return sqlSessionTemplate.insert("user.saveUser", user);
  }

  public int deleteUser(Long no) {
    return sqlSessionTemplate.delete("user.deleteUser", no);
  }
}
