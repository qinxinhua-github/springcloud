package com.yun.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
@Api(tags = "教师处理类")
public class MathController {
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
        return "这里是端口为8703的服务返回的数据";
    }
    /**
     * 定义降级方法：
     * 注意： 方法的返回值、参数需要和原方法一样
     */
    public String findFive_fallback(String id,String name) {

        return "这里是端口为8703的降解方法返回数据";
    }
}
