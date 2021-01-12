package com.example.demo.controller;

import com.example.demo.entity.JsonResult;
import com.example.demo.utils.StringUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 慧稅回调接口
 */
@RestController
@RequestMapping("/erp")
public class GetZZSDataController {

    @PostMapping("/bill/GetZZSData")
    public JsonResult getZZSData(@RequestBody Map<String,Object> projectMap){
        System.out.println(projectMap.toString());
        JsonResult jsonResult = new JsonResult();
        if(StringUtil.isEmpty((String) projectMap.get("nsrdj_no"))){
            return jsonResult.failure("nsrdj_no为空");
        }
        if(StringUtil.isEmpty((String) projectMap.get("pwd"))){
            return jsonResult.failure("pwd为空");
        }
        if(StringUtil.isEmpty((String) projectMap.get("strdate"))){
            return jsonResult.failure("strdate为空");
        }
        if(StringUtil.isEmpty((String) projectMap.get("enddate"))){
            return jsonResult.failure("20190809为空");
        }
        try {
            Map<String, Object>	resultList=null;//GetZZSDataService.getZZSData(projectMap);
            return jsonResult.success(resultList);
        }catch (Exception e) {
            e.printStackTrace();
            return jsonResult.failure("增值税税费单获取失败！");
        }
    }
}
