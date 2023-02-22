package com.yun.serverapi;

//import com.yun.entity.Teacher;
//import com.yun.serverapi.serverApiImpl.StudentApiImpl;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * feign
 * 接口调用
 */
//@FeignClient(value = "service-zuul",fallback = StudentApiImpl.class)
//@FeignClient(value = "eureka-mathgroup",fallback = StudentApiImpl.class)
public interface StudentApi {

    /**
     * 测试高可用方法
     * @param id
     * @param name
     * @return
     */
//    @RequestMapping(value = "/math/highUse", method = RequestMethod.POST)
//    String searchRepo(@RequestBody String id, @RequestBody String name);


    /**
     * 测试List<Teacher>类型返回
     * @param id
     * @param name
     * @return
     */
//    @RequestMapping(value = "/math/allTeacherListObj", method = RequestMethod.POST)
//    List<Teacher> getAllMathTeacherObj(@RequestBody String id, @RequestBody String name);

    /**
     * 测试List<List<String>>类型返回
     * @param id
     * @param name
     * @return
     */
//    @RequestMapping(value = "/math/allTeacherList", method = RequestMethod.GET)
//    List<List<String>> getAllMathTeacherList(@RequestBody String id, @RequestBody String name);
}
