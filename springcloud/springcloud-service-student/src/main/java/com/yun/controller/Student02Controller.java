package com.yun.controller;

import com.yun.entity.Teacher;
import com.yun.serverapi.StudentApi;
import com.yun.util.Tookit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student02")
@Api(tags = "学生测试类02")
public class Student02Controller {

//    @Qualifier("eureka-mathgroup")
//    @Autowired
//    private StudentApi studentApi;
//
//    @Resource //注解注入进来
//    private RedisTemplate redisTemplate;


    /**
     * 测试1
     * 返回list数据
     * @return
     */
//    @PostMapping("test01")
//    @ApiOperation("高可用测试方法")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "name", value = "学生名称", paramType = "query", required = true)
//    })
//    public String test05(@RequestParam("name") String studentName){
//        //获取所有的老师信息
//        String teacherList = studentApi.searchRepo("111111","阿西吧");
//        return teacherList;
//    }
    /**
     * 测试1
     * 返回list数据
     * @return
     */
//    @PostMapping("test02")
//    @ApiOperation("获取所有老师信息，以list<Object>类型返回")
//    public String test03(){
//        //获取所有的老师信息
//        List<Teacher> teacherList = studentApi.getAllMathTeacherObj("111111","阿西吧");
//        redisTemplate.opsForValue().set("teacher",teacherList);
//        List<Teacher> teacherLists = (List<Teacher>)redisTemplate.opsForValue().get("teacher");
//        return JSONArray.fromObject(teacherList).toString();
//    }

    /**
     * 测试1
     * 返回list数据
     * @return
     */
//    @GetMapping("test03")
//    @ApiOperation("获取所有老师信息，以list类型返回")
//    public String test02(){
//        //获取所有的老师信息
//        List<List<String>> teacherList = studentApi.getAllMathTeacherList("111111","阿西吧");
//        return JSONArray.fromObject(teacherList).toString();
//    }
}
