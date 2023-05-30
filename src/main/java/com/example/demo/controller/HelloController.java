package com.example.demo.controller;

import com.example.demo.common.PageResult;
import com.example.demo.common.ResponseCode;
import com.example.demo.common.Result;
import com.example.demo.dto.RequirementDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.RequirementMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.param.GetRequirementListParam;
import com.example.demo.vo.RequirementVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Slf4j
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello 2023.4.25";
    }

    /**
     * http://127.0.0.1:8080/prefix/get1
     * @return
     */
    @GetMapping("/get1")
    public String get1(){
        return "GetMapping";
    }

    /**
     * http://127.0.0.1:8080/prefix/get2?num=1
     * @param num
     * @return
     */
    @GetMapping("/get2")
    public String get2(@RequestParam Integer num){
        return "para from request:" + num;
    }

    /**
     *http://127.0.0.1:8080/prefix/get3/9
     * @param num
     * @return
     */
    @GetMapping({"/get3/{num}"})
    public String pathpara(@PathVariable Integer num){
        return "para from request:" + num;
    }
    @GetMapping("/{deptId}/{userId}")
    public Object queryUser(@PathVariable("deptId")String deptId,
                            @PathVariable("userId")String userId){
        Map<String,Object> resultMap = new HashMap<>(8);
        resultMap.put("deptId",deptId);
        resultMap.put("userId",userId);
        return resultMap;
    }

    /**
     * http://127.0.0.1:8080/prefix/get4
     * 接口参数可以为空，为空时使用默认值
     * 默认值必须是字符串，哪怕参数是一个整型
     * @param num
     * @return
     */
    @GetMapping({"/get4"})
    public String required(@RequestParam(required = false,defaultValue = "5") Integer num){
        return "para from request:" + num;
    }

    /**
     * http://127.0.0.1:8080/prefix/rest
     * @RestController
     * 用于定义控制器类，注解是@Controller和@ResponseBody的合集
     * 表示这是个控制器bean,并且是将函数的返回值直接填入HTTP响应体中,是REST风格的控制器
     * @return
     */
    @RequestMapping(value = "/rest")
    public Object rest() {
        Map<String, Object> resultMap = new HashMap<>(8);
        resultMap.put("msg", "i am rest controller test");
        resultMap.put("code", "10000");
        return resultMap;
    }

    /**
     * http://127.0.0.1:8080/prefix/post
     * @PostMapping
     * 等价于@RequestMapping(value = “hello”, method = RequestMethod.POST)，接收POST请求方法的RequestMapping
     * @return
     */
    @PostMapping("/post")
    public Object post(){
        Map<String,Object> resultMap = new HashMap<>(8);
        resultMap.put("msg","i am post mapping test");
        resultMap.put("code","10000");
        return resultMap;
    }

    /**
     * http://127.0.0.1:8080/prefix/post2
     * @RequestBody
     * 作用于形参列表上，用于将前台发送过来固定格式的数据【xml 格式或者 json等】封装为对应的 JavaBean 对象
     * 封装时使用到的一个对象是系统默认配置的 HttpMessageConverter进行解析，然后封装到形参上
     * @return
     */
    @PostMapping("/post2")
    public Object requestBodyTest(@RequestBody UserDTO user){
        Map<String,Object> resultMap = new HashMap<>(8);
        resultMap.put("data","传入参数为:" + user);
        resultMap.put("code","10000");
        return resultMap;
    }

    /**
     * 返回一个通用结果对象
     * @return
     */
    @GetMapping("/getData")
    public Result getData(){
        return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), "test");
    }

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/queryUser")
    public Result queryUser(){
        List<UserDTO> users = userMapper.getUserList();
        System.out.println(users);
        return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), users);
    }

    @PostMapping("/login")
    public Result login(@RequestParam(required = true) String name , @RequestParam(required = true) String pass){
        List<UserDTO> users = userMapper.getUserList();
        for(int i = 0; i < users.size(); i++){
            UserDTO userDTO = users.get(i);
            if(userDTO.getName().equals(name) && userDTO.getPassword().equals(pass)) {
                return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), null);
            }
            continue;
        }
        return new Result(ResponseCode.USERNAME_OR_PASSWORD_WRONG.getCode(), ResponseCode.USERNAME_OR_PASSWORD_WRONG.getMsg(), null);
    }
    @Autowired
    RequirementMapper requirementMapper;

    @PostMapping("/query")
    public Object getRequirementList(@RequestBody GetRequirementListParam getRequirementListParam){
        PageResult pageResult = new PageResult();
        pageResult.setPageNo(getRequirementListParam.getPage());
        pageResult.setPageSize(getRequirementListParam.getSize());
        Integer page = (getRequirementListParam.getPage()-1)* getRequirementListParam.getSize();
        getRequirementListParam.setPage(page);
        List<RequirementDTO> requirementDTOS = requirementMapper.getRequirementList(getRequirementListParam);
        List<RequirementVO> requirementVOS = new RequirementVO(requirementDTOS).getVoList();
        pageResult.setData(requirementVOS);

        Integer count = requirementMapper.getRequirementCount(getRequirementListParam);
        pageResult.setTotalRecord(count);
        pageResult.value(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg());
        return pageResult;
    }

    @PostMapping("/add")
    public Result addRequirement(@RequestBody RequirementDTO requirementDTO){
        Integer result = requirementMapper.addRequirement(requirementDTO);
        return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), result);
    }

    @PostMapping("/update")
    public Result updateRequirement(@RequestBody RequirementDTO requirementDTO){
        Integer result = requirementMapper.updateRequirement(requirementDTO);
        return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), result);
    }

    @PostMapping("/delete")
    public Result deleteRequirement(@RequestParam("id") Integer id){
        Integer result = requirementMapper.deleteRequirement(id);
        return new Result(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), result);
    }
}
