package com.nowcoder.AspectJDemo;

import org.springframework.stereotype.Service;

/**
 * 用于测试的方法
 */
@Service(value = "myservice")
public class UserService {

    public String add(Integer id,String name){
        String str = "this is service:add user id="+id+",name="+name;
        System.out.println(str);
        return str;
    }

    public void delete(Integer id){
        System.out.println("this is service:delete user id="+id);
    }

    public void update(Integer id) throws Exception {
        throw new Exception("更新错误");
    }

}
