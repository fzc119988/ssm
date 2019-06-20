package com.ssm.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.model.User;
import com.ssm.service.UserService;
import com.ssm.vo.RespVo;
import com.ssm.vo.UserVo;

@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired(required=true)
    private UserService userService;  

    /**
     *��ת������û�����
     */
    
    /**
     * ��ѯ�����û�
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="/list",method=RequestMethod.GET) 
    @CrossOrigin
    @ResponseBody
    public RespVo getAllUser(){
        List<User> user = userService.findAll();
        return RespVo.success(user);
        
    }
    
    public String toAddUser(){
        return "addUser";
    }

    /**
     * ����û����ض���  
     * @param model
     * @param user
     * @return
     */
//    @RequestMapping("addUser") 
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="/add",method=RequestMethod.POST) 
    public  RespVo addUser( @RequestBody UserVo vo){
    	 if (StringUtils.isEmpty(vo.getUsername())) {
             return RespVo.error("10003", "��������");
         }
    	 User user = new User();
//       user.setMobile(vo.getMobile());
//       user.setName(vo.getName());
    	 BeanUtils.copyProperties(vo, user);
    	 //user.setIsDel(0);
    	 userService.saveUser(user);;
    	 return RespVo.success("success");
   }

    /**
     * �޸��û�
     * @param model
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value="/update",method=RequestMethod.POST) 
    @CrossOrigin
    @ResponseBody
    public RespVo UpdateUser(@RequestBody UserVo vo){
    	 if (StringUtils.isEmpty(vo.getId())) {
             return RespVo.error("10003", "��������");
         }
    	 User user = new User();
    	 user.setUsername(vo.getUsername());
    	 user.setUsername(vo.getUsername());
    	 BeanUtils.copyProperties(vo, user);
    	 //user.setIsDel(0);
    	 userService.saveUser(user);;
    	 return RespVo.success("success"); 
    		
    		//             if(userService.updateUser(user)){  
    		//                    user = userService.findUserById(user.getId());  
    		//                    model.addAttribute("user", user);  
    		//                    return "redirect:/user/userInfo";  
    		//                } 
    		//         return "/error";
    }
    
  
    /**
     * ����idɾ���û�
     * @param id
     * @param request
     * @param response
     */
    @RequestMapping(value="/del",method=RequestMethod.POST) 
    @CrossOrigin
    @ResponseBody
    public RespVo deleteUser(Integer id){
    	return RespVo.success("success");
    }

    /**
     * ��ҳ��ѯ�û���Ϣ
     * @param pn Ĭ�ϴӵ�һҳ��ʼ  �������
     * @param model
     * @return
     */
//    @RequestMapping("userInfo")
//    public String getUsers(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model){
//        //�ӵ�һ����ʼ ÿҳ��ѯ��������
//        PageHelper.startPage(pn, 5);
//        List<User> users = userService.findAll();
//        //���û���Ϣ����PageInfo������
//        PageInfo page = new PageInfo(users,5);
//        model.addAttribute("pageInfo", page);
//        return "allUser";
//    }
}

