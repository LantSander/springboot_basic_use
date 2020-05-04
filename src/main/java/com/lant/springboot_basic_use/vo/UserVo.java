package com.lant.springboot_basic_use.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
public class UserVo {

    @NotNull(message = "用户id不能为空",groups =add.class )
    @Min(message = "id不能小于1",groups = {add.class,edit.class},value = 1)
    @Max(message = "id不能大于5",groups = {add.class,edit.class},value = 5)
    private Integer id;

    @Length(min = 1,max = 5,message = "用户名长度不能超过5个字符",groups = {add.class,edit.class})
    @NotBlank(message = "用户名不能为空",groups = {add.class,edit.class})
    private String userName;

    @NotBlank(message = "地址不能为空",groups = {add.class})
    private String address;

    @Pattern(regexp="^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$",message="身份证号不合规")
    private String cardNo;

    @NotNull(message = "iszt不能为空",groups =add.class )
    @AssertTrue(message = "iszt必须为true",groups = {add.class,edit.class})
    Boolean iszt;

    @NotNull(message = "isft不能为空",groups =add.class )
    @AssertFalse(message = "ft必须为false",groups = {add.class,edit.class})
    Boolean isft;

    //用于分组，校验不同类型的请求规范
    public interface  add{};
    public interface  edit{};



}
