package cn.ngmc.controller;

import cn.ngmc.entity.Brand;
import cn.ngmc.entity.JsonResult;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;

@Controller
public class JsonTestController {

    @RequestMapping("/brand/get")
    public  @ResponseBody JsonResult<Brand> test(@RequestBody(required = false)  Brand brand){
        JsonResult<Brand> jsonResult=new JsonResult<Brand>();
        jsonResult.setStatus("ok");
        jsonResult.setData(brand);
        return jsonResult;
    }


    @RequestMapping("/brand/test")
    public  @ResponseBody String test(){
        JsonResult<HashMap<String,String>> jsonResult=new JsonResult<HashMap<String,String>>();
        jsonResult.setStatus("ok");
       HashMap<String,String> map=new  HashMap<String,String>();
       map.put("cn","China");
        map.put("us","USA");
        map.put("en","UK");
        jsonResult.setData(map);
        return JSON.toJSONString(jsonResult);
    }

}
