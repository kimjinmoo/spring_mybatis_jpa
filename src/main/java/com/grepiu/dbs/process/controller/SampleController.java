package com.grepiu.dbs.process.controller;

import com.grepiu.dbs.process.entity.User;
import com.grepiu.dbs.process.service.UserService;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

  private UserService userServiceJPA;

  private UserService userServiceMybatis;

  public SampleController(@Qualifier("JPA") UserService userServiceJPA,
      @Qualifier("MYBATIS") UserService userServiceMybatis) {
    this.userServiceJPA = userServiceJPA;
    this.userServiceMybatis = userServiceMybatis;
  }

  /**
   *
   * 샘플 유저 추가
   *
   * @return ResponseEntity<Object>
   */
  @PostMapping("/users/jpa/test")
  public ResponseEntity<Object> userSaveJpaTest() throws Exception {
    HashMap<String, Object> maps = new HashMap<>();
    maps.put("jpa", userServiceJPA.saveUserSample());
    return ResponseEntity.ok(maps);
  }

  /**
   *
   * 샘플 유저 추가
   *
   * @return ResponseEntity<Object>
   */
  @PostMapping("/users/mybatis/test")
  public ResponseEntity<Object> userSaveMybatisTest() throws Exception{
    HashMap<String, Object> maps = new HashMap<>();
    maps.put("mybatis", userServiceMybatis.saveUserSample());
    return ResponseEntity.ok(maps);
  }

  /**
   *
   * 유저 추가
   *
   * @return ResponseEntity<Object>
   */
  @PostMapping
  public ResponseEntity<Object> users(User user) {
    HashMap<String, Object> maps = new HashMap<>();
    maps.put("jpa", userServiceJPA.saveUser(user));

    return ResponseEntity.ok(maps);
  }

  /**
   *
   * 유저 정보를 가져온다.
   *
   * @return ResponseEntity<Object>
   */
  @GetMapping
  public ResponseEntity<Object> users() {
    HashMap<String, Object> maps = new HashMap<>();
    maps.put("jpa", userServiceJPA.getUsers());
    maps.put("mybatis", userServiceMybatis.getUsers());
    return ResponseEntity.ok(maps);
  }

  @DeleteMapping
  public ResponseEntity<Object> users(@PathVariable int no) {
    return ResponseEntity.ok(null);
  }
}
