package com.qyb.pojo;/*

亲元宝 2019/10/29  10:49
元宝

*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer user_id;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private Integer status;
    private Integer create_user_id;
    private Date create_time;
    private Integer dept_id;
    private String sex;
    private Date lockdate;
}
