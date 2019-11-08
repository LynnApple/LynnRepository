package cn.ngmc.controller;

import cn.ngmc.entity.JsonResult;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

@Controller
public class FileUpLoadController {

    private SimpleDateFormat spdf=new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(value = "/upload",method = {RequestMethod.POST})
    public @ResponseBody  String
    upload(MultipartFile file, HttpServletRequest request) throws IOException {
        //response输出对象
        //PrintWriter out=response.getWriter();
        //统一返回对象
        JsonResult<String> jsonResult=new JsonResult<String>();


        ServletContext application = request.getSession().getServletContext();
        //1、物理存储路径
        String path="upload\\"+spdf.format(new Date());
        //2、获取物理地址
        String savePath = application.getRealPath("/") + path;//取物理地址

        //url 相对地址
        String urlPath="upload/"+spdf.format(new Date())+"/";

        //上传图片的格式正则
        String reg = ".+(.JPEG|.jpeg|.JPG|.jpg|.png)$";
        //取原文件名
        String oldFileName=file.getOriginalFilename();
        //判断文件是否存在
        if(file!=null && oldFileName!=null && oldFileName.length()>0){

            //判断文件格式
            if(!oldFileName.matches(reg)){
                jsonResult.setStatus("err");
                jsonResult.setErrMsg("图片格式不正确");
               // out.println();
                return JSON.toJSONString(jsonResult);
            }

            //重构文件名
            String newFileName=rename(oldFileName);

            //判断文件目录是否存在
            File dir=new File(savePath);
            if(!dir.exists()){
                dir.mkdirs();
            }
            //新文件对象
            File newFile=new File(savePath+"\\"+newFileName);
            file.transferTo(newFile);

            jsonResult.setStatus("ok");
            jsonResult.setData(urlPath+newFileName);
            //out.println(JSON.toJSONString(jsonResult));
            return JSON.toJSONString(jsonResult);
        }

        jsonResult.setStatus("err");
        jsonResult.setErrMsg("图片不存在");

        return JSON.toJSONString(jsonResult);

    }

    /**
     * 将文件重命名
     * @param name
     * @return
     */
    private static String rename(String name) {
        Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        String fileName = now+ "_" +new Random().nextInt(1000);
        if (name.indexOf(".") != -1) {
            fileName += name.substring(name.lastIndexOf("."));
        }
        return fileName;
    }
    /**
     * 返回文件的文件后缀名
     * @param fileName
     * @return
     */
    public static String getExtension(String fileName) {
        try {
            return fileName.split("\\.")[fileName.split("\\.").length - 1];
        } catch (Exception e) {
            return null;
        }
    }

}
