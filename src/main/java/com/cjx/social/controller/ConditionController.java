package com.cjx.social.controller;

import com.cjx.social.config.Constants;
import com.cjx.social.entity.Condition;
import com.cjx.social.service.ConditionService;
import com.cjx.social.utils.FastDFSUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Created by 17858 on 2018-05-18.
 */
@Controller
@RequestMapping("/condition")
public class ConditionController {

    @Autowired
    ConditionService conditionService;

    @RequestMapping("test")
    @ResponseBody
    public void test() {
        System.out.println("cajkslda");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void addCondition(@RequestParam("text") String text,
                             @RequestParam("time") String time,
                             @RequestParam("place") String place,
                             @RequestParam(value = "photo", required = false) MultipartFile file, HttpServletRequest request) throws Exception{
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        String extName = fileName.substring(fileName.lastIndexOf(".")+1);
        File file1 = new File(path);
        if (!file1.exists()) {
            file1.mkdir();
        }
        File targetFile = new File(path, fileName);
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String photoUrl = Constants.WEB_ADDR + FastDFSUtil.uploadImage(targetFile.getAbsolutePath(), extName);

        Condition condition=new Condition();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        java.util.Date date=sdf.parse(time);
        condition.setTime(date);
        condition.setPhoto(photoUrl);
        condition.setPlace(place);
        condition.setText(text);
        conditionService.addCondition1(condition);
    }
}
