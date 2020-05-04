package com.lant.springboot_basic_use.controller;


import com.lant.springboot_basic_use.vo.ResultVo;
import com.lant.springboot_basic_use.vo.UserVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
* Spring-Boot-Validation 学习
* 通过注解方式实现，数据校验,数据约束
* 拦截校验结果，统一返回前端
* */
@RestController
public class ValidationController {
    @PostMapping("/adduser")
    public ResultVo addUser(@Validated(UserVo.add.class) @RequestBody UserVo userVo){
        System.out.println("校验无法，开始执行新增");
        return new ResultVo(1,"新增成功",null);
    }

}
