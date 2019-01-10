package com.xiao.web.action;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by sunjinwei on 2018/1/4.
 *
 * @author sunjinwei
 * 使用 spring boot 测试访问
 */
@Slf4j
@Api(description = "测试访问API")
@Controller
public class HelloWorldController {


    /**
     * 返回到 jsp 页面
     *
     * @return
     */
    @ApiIgnore
    @ApiOperation(value = "返回到 jsp 页面")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "正常响应")})
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "init/welcome";
    }

    /**
     * 返回简单的固定字符串
     *
     * @return
     */
    @ApiOperation(value = "返回简单的固定字符串")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        log.info("### hello");
        return "Hello world! Welcome";
    }

    /**
     * 返回带参数的字符串
     *
     * @param name
     * @return
     */
    @ApiOperation(value = "返回带参数的字符串")
    @RequestMapping(value = "/helloWithName", method = RequestMethod.GET)
    @ResponseBody
    public String helloWithName(@RequestParam String name) {
        log.info("### helloWithName:{}", name);
        return "Hello world!" + name;
    }

}
