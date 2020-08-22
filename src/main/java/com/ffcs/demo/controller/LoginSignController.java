package com.ffcs.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ffcs.demo.constant.OperResult;
import com.ffcs.demo.entity.User;

import com.ffcs.demo.service.LoginSignService;
import com.ffcs.demo.utils.validatecode.IVerifyCodeGen;
import com.ffcs.demo.utils.validatecode.SimpleCharVerifyCodeGenImpl;
import com.ffcs.demo.utils.validatecode.VerifyCode;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gaoxt on 2020/8/9.
 */
@CrossOrigin
@RestController
@RequestMapping("api/LoginSign")
public class LoginSignController {
    @Autowired
   private LoginSignService loginSignService;
    @PostMapping("/Login")
    public JSONObject login (@RequestBody JSONObject inputJSon ,HttpServletResponse response,HttpSession session){
        String userId= inputJSon.getString("userId");
        String pwd  = inputJSon.getString("pwd");
        String remember = inputJSon.getString("remember");
        JSONObject result  = new JSONObject();
        if(null==userId|| StringUtils.isBlank(userId))
        {
            result.put("resultMessage","登陆失败，账号不可为空");
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }
        if(null==pwd|| StringUtils.isBlank(pwd))
        {
            result.put("resultMessage","登陆失败，登陆密码不可为空");
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }
        if(!telCheck(userId)){
            result.put("resultMessage","登陆失败，电话号码格式错误");
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }
        try {
            User user = loginSignService.selettById(userId);

            if(null==user) {
                result.put("resultMessage","登陆失败，账号不存在");
                result.put("resultCode",0);
                result.put("resultObject","");
                return result;
            }
            else {
                user=loginSignService.selectByIdPwd(userId,pwd);
                if (user==null) {
                    result.put("resultMessage","登陆失败，密码错误");
                    result.put("resultCode",0);
                    result.put("resultObject","");
                    return result;
                }
                else{
                    session.setAttribute("userId",user.getUserId());
                    if (null!=remember&&remember.equals("1")){
                    String loginInfo = userId+","+pwd;
                    Cookie userCookie=new Cookie("loginInfo",loginInfo);
                    userCookie.setMaxAge(30*24*60*60);   //存活期为一个月 30*24*60*60
                    userCookie.setPath("/");
                    response.addCookie(userCookie);
                    }
                    result.put("resultMessage","登陆成功");
                    result.put("resultCode",1);
                    result.put("resultObject","");
                    return result;

                }
            }
        }
        catch (Exception e) {
            result.put("resultMessage", OperResult.OPERATION_RESULT_SEARCH_FAIL+":"+e);
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }



    }


    @PostMapping("/Sign")
    public JSONObject sign (@RequestBody JSONObject inputJSon ,HttpServletRequest request){
        String userId= inputJSon.getString("userId");
        String pwd  = inputJSon.getString("pwd");
        String pwdAgain = inputJSon.getString("pwdagain");
        String verificationCode = inputJSon.getString("verificationcode");
        String userName = inputJSon.getString("userName");
        JSONObject result  = new JSONObject();
        if(null==userId|| StringUtils.isBlank(userId))
        {
            result.put("resultMessage","注册失败，账号不可为空");
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }
        if(null==pwd|| StringUtils.isBlank(pwd))
        {
            result.put("resultMessage","注册失败，注册密码不可为空");
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }
        if(null==pwdAgain|| StringUtils.isBlank(pwdAgain))
        {
            result.put("resultMessage","注册失败，二次密码不可为空");
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }
        if(!telCheck(userId)){
            result.put("resultMessage","注册失败，电话号码格式错误");
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }
        if(null==userName|| StringUtils.isBlank(userName))
        {
            result.put("resultMessage","注册失败，用户姓名不可为空");
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }
        if(null==verificationCode|| StringUtils.isBlank(verificationCode))
        {
            result.put("resultMessage","注册失败，验证码不可为空");
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }
        if (userName.length()>10)
        {
            result.put("resultMessage","注册失败，用户姓名过长");
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }
        if (!pwd.equals(pwdAgain))
        {
            result.put("resultMessage","注册失败，密码需要相同");
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }

        HttpSession session = request.getSession();
        String vc=String.valueOf(session.getAttribute("VerifyCode"));
        if (null!=vc||vc.equals(verificationCode))
        {
                result.put("resultMessage","注册失败，验证码错误");
                result.put("resultCode",0);
                result.put("resultObject","");
                return result;

        }



        try {
            User user = loginSignService.selettById(userId);

            if(null!=user) {
                result.put("resultMessage","注册失败，账号已存在");
                result.put("resultCode",0);
                result.put("resultObject","");
                return result;
            }
            else {
                    User record = new User();
                    record.setPhone(userId);
                    record.setUserCode(Long.valueOf(System.currentTimeMillis()));
                    record.setUserName(userName);
                    record.setUserPwd(pwd);
                    record.setStatus(1);
                    int res = loginSignService.insertSelective(record);
                    if (res==0)
                    {
                        result.put("resultMessage","注册失败");
                        result.put("resultCode",0);
                        result.put("resultObject","");
                        return result;
                    }
                    result.put("resultMessage","登陆成功");
                    result.put("resultCode",1);
                    result.put("resultObject","");
                    return result;


            }
        }
        catch (Exception e) {
            result.put("resultMessage", OperResult.OPERATION_RESULT_SEARCH_FAIL+":"+e);
            result.put("resultCode",0);
            result.put("resultObject","");
            return result;
        }



    }



    private boolean telCheck(String tel){
        Pattern p = Pattern.compile("^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$");
        Matcher m = p.matcher(tel);
        return m.matches();
    }


    @ApiOperation(value = "验证码")
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {

    }
}
