package com.yun.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yun.entity.Teacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/math")
@Api(tags = "教师处理类")
public class MathController {
    @GetMapping("/teacher")
    @ApiOperation("测试无入参调用")
    public String getMathTeacherList(){
        System.out.println("获取数学教研组老师列表！");
        return "返回数学教研组老师列表";
    }

    @GetMapping("/selTeacher")
    @ApiOperation("测试有入参调用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "教师id", paramType = "query", required = true)
    })
    @HystrixCommand(fallbackMethod = "findOne_fallback",commandProperties = {
            //将Hystrix的超时时间设置为3s,默认为1s
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String getMathTeacher(@RequestParam("id") String id){
        System.out.println("获取单个教师信息！");
        return "id为"+id+"的老师信息：测试信息";
    }
    /**
     * 定义降级方法：
     *      方法的返回值、参数需要和原方法一样
     */
    public String findOne_fallback(String id) {
        return id+"：降级";
    }
    /**
     * 注意
     * 1、使用PostMapping时需要用RequestBody接收参数
     * 2、项目重启之后需要等待40秒，因为spring默认有40秒缓冲时间
     * @param id
     * @param name
     * @return
     */
    @PostMapping("/allTeacher")
    @ApiOperation("测试Map<String,Map<String,String>>类型返回")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "教师id", paramType = "query", required = true),
            @ApiImplicitParam(name = "name", value = "教师名称", paramType = "query", required = true)
    })
    @HystrixCommand(fallbackMethod = "findTwo_fallback",commandProperties = {
            //将Hystrix的超时时间设置为3s,默认为1s
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public Map<String,Map<String,String>> getAllMathTeacher(@RequestBody String id,@RequestBody String name){
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        Map<String,Map<String,String>> list = new HashMap<String,Map<String,String>>();
        Map<String,String> info = new HashMap<>();
        info.put("老师信息1","1111111");
        info.put("老师地址1","2222222");

        Map<String,String> info1 = new HashMap<>();
        info1.put("老师信息2","1111111");
        info1.put("老师地址2","2222222");

        Map<String,String> info2 = new HashMap<>();
        info2.put("老师信息3","1111111");
        info2.put("老师地址3","2222222");

        list.put("1",info);
        list.put("2",info1);
        list.put("3",info2);
        return list;
    }
    /**
     * 定义降级方法：
     *      方法的返回值、参数需要和原方法一样
     */
    public Map<String,Map<String,String>> findTwo_fallback(String id,String name) {
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        Map<String,Map<String,String>> list = new HashMap<String,Map<String,String>>();
        Map<String,String> info = new HashMap<>();
        info.put("降解信息1",id);
        info.put("降解信息2",name);

        list.put("1",info);
        return list;
    }




    @GetMapping("/allTeacherList")
    @ApiOperation("测试List<List<String>>类型返回")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "教师id", paramType = "query", required = true),
            @ApiImplicitParam(name = "name", value = "教师名称", paramType = "query", required = true)
    })
    @HystrixCommand(fallbackMethod = "findthree_fallback",commandProperties = {
            //将Hystrix的超时时间设置为3s,默认为1s
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public List<List<String>> getAllMathTeacherList(@RequestParam("id") String id,@RequestParam("name") String name){
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        List<List<String>> list = new ArrayList<>();

        List<String> info = new ArrayList<>();
        info.add("张三111");
        info.add("张三222");
        List<String> info1= new ArrayList<>();
        info1.add("李四111");
        info1.add("李四222");
        List<String> info2 = new ArrayList<>();
        info2.add("王二111");
        info2.add("王二222");


        list.add(info);
        list.add(info1);
        list.add(info2);
        return list;
    }
    /**
     * 定义降级方法：
     *      方法的返回值、参数需要和原方法一样
     */
    public List<List<String>> findthree_fallback(String id,String name) {
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        List<List<String>> list = new ArrayList<>();

        List<String> info = new ArrayList<>();
        info.add("降解信息1:"+id);
        info.add("降解信息2:"+name);

        list.add(info);
        return list;
    }

    /**
     * 注意
     * 1、使用PostMapping时需要用RequestBody接收参数
     * 2、项目重启之后需要等待40秒，因为spring默认有40秒缓冲时间
     * @param id
     * @param name
     * @return
     */
    @PostMapping("/allTeacherListObj")
    @ApiOperation("测试List<Teacher>类型返回")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "教师id", paramType = "query", required = true),
            @ApiImplicitParam(name = "name", value = "教师名称", paramType = "query", required = true)
    })
    @HystrixCommand(fallbackMethod = "findFour_fallback",commandProperties = {
            //将Hystrix的超时时间设置为3s,默认为1s
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public List<Teacher> getAllMathTeacherObj(@RequestBody String id, @RequestBody String name){
//        try {
//            Thread.sleep(5000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        List<Teacher> list = new ArrayList<Teacher>();

        Teacher info = new Teacher();
        info.setId("1");
        info.setName("张三");
        info.setAddr("山东省1");
        info.setNumber("123123123123");
        Teacher info1 = new Teacher();
        info1.setId("2");
        info1.setName("李四");
        info1.setAddr("山东省2");
        info1.setNumber("222222222");
        Teacher info2 = new Teacher();
        info2.setId("3");
        info2.setName("王五");
        info2.setAddr("山东省3");
        info2.setNumber("33333333");


        list.add(info);
        list.add(info1);
        list.add(info2);
        return list;
    }


    /**
     * 定义降级方法：
     * 注意： 方法的返回值、参数需要和原方法一样
     */
    public List<Teacher> findFour_fallback(String id,String name) {
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        List<Teacher> list = new ArrayList<Teacher>();

        Teacher info = new Teacher();
        info.setId("1");
        info.setName("降解信息");
        info.setAddr("无");
        info.setNumber("无");

        list.add(info);
        return list;
    }





    /**
     * 高可用测试方法
     * 注意
     * 1、使用PostMapping时需要用RequestBody接收参数
     * 2、项目重启之后需要等待40秒，因为spring默认有40秒缓冲时间
     * @param id
     * @param name
     * @return
     */
    @PostMapping("/highUse")
    @ApiOperation("高可用测试方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "教师id", paramType = "query", required = true),
            @ApiImplicitParam(name = "name", value = "教师名称", paramType = "query", required = true)
    })
    @HystrixCommand(fallbackMethod = "findFive_fallback",commandProperties = {
            //将Hystrix的超时时间设置为3s,默认为1s
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String highUse(@RequestBody String id, @RequestBody String name){
        return "这里是端口为8701的服务返回的数据";
    }

    /**
     * 定义降级方法：
     * 注意： 方法的返回值、参数需要和原方法一样
     */
    public String findFive_fallback(String id,String name) {

        return "这里是端口为8701的降解方法返回数据";
    }
}
