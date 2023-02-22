package com.yun.controller;

import com.yun.util.RedisUtils;
import com.yun.util.Tookit;
import com.yun.entity.Teacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@Api(tags = "学生处理类")
public class StudentController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource //注解注入进来
    private RedisTemplate redisTemplate;
    /**
     * 学习数学
     * 调用数学教研组服务得到数学老师信息
     *  get方法主要有6中调用方式，其中又可以分为getForEntity和getForObject，每个方法有3中重载方式。
     * @return
     */
    @PostMapping("studyMath")
    @ApiOperation("某学生学习数学")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "学生名称", paramType = "query", required = true)
    })
    public String studyMath(@RequestParam("name") String studentName){
        System.out.println("学生："+studentName+",进行课程选择。");

        //调取秦老师信息
        String teacher = "秦新华";
        String forObject = restTemplate.getForObject("http://service-zuul/mathgroup/math/selTeacher?id=" + teacher, String.class);
        System.out.println(teacher+"老师信息："+forObject);
        return forObject;
    }

    /**
     * 测试1
     * 返回map类型数据
     * @return
     */
    @GetMapping("test01")
    @ApiOperation("获取所有老师信息，以map类型返回")
    public String test01(){
        //获取所有的老师信息
        Map<String,String> param = new HashMap<String,String>();
        param.put("id","111111");
        param.put("name","阿西吧");
        Map<String,Map<String,String>> teacherList = restTemplate.postForObject("http://service-zuul/mathgroup/math/allTeacher", Tookit.getHttpEntity(param),Map.class);
        return JSONArray.fromObject(teacherList).toString();
    }

    /**
     * 测试1
     * 返回list数据
     * @return
     */
    @GetMapping("test02")
    @ApiOperation("获取所有老师信息，以list类型返回")
    public String test02(){
        //获取所有的老师信息
        Map<String,String> param = new HashMap<String,String>();
        param.put("id","111111");
        param.put("name","阿西吧");
        List<List<String>> teacherList = restTemplate.getForObject("http://service-zuul/mathgroup/math/allTeacherList?id={id}&name={name}", List.class,param);
//        redisTemplate.opsForValue().set("teacher",teacherList);
        return JSONArray.fromObject(teacherList).toString();
    }

    /**
     * 测试1
     * 返回list数据
     * @return
     */
    @PostMapping("test03")
    @ApiOperation("获取所有老师信息，以list<Object>类型返回")
    public String test03(){
        //获取所有的老师信息
        Map<String,String> param = new HashMap<String,String>();
        param.put("id","111111");
        param.put("name","阿西吧");
        List<Teacher> teacherList = restTemplate.postForObject("http://service-zuul/mathgroup/math/allTeacherListObj",Tookit.getHttpEntity(param) , List.class);
        redisTemplate.opsForValue().set("teacher",teacherList);
        List<Teacher> teacherLists = (List<Teacher>)redisTemplate.opsForValue().get("teacher");
        return JSONArray.fromObject(teacherList).toString();
    }
    /**
     * 测试1
     * 返回list数据
     * @return
     */
    @PostMapping("test04")
    @ApiOperation("获取所有老师信息，从redis缓存中获取，以list<Object>类型返回")
    public String test04(){
        //获取所有的老师信息
        Map<String,String> param = new HashMap<String,String>();
        param.put("id","111111");
        param.put("name","阿西吧");
        List<Teacher> teacherLists = (List<Teacher>)redisTemplate.opsForValue().get("teacher");
        return JSONArray.fromObject(teacherLists).toString();
    }


    /**
     * 测试1
     * 返回list数据
     * @return
     */
    @PostMapping("test05")
    @ApiOperation("高可用测试方法")
    public String test05(){
        //获取所有的老师信息
        //获取所有的老师信息
        Map<String,String> param = new HashMap<String,String>();
        param.put("id","111111");
        param.put("name","阿西吧");
        String teacherList = restTemplate.postForObject("http://service-zuul/mathgroup/math/highUse",Tookit.getHttpEntity(param) , String.class);

        return teacherList;
    }
}
