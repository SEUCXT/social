package com.cjx.social.controller;

import com.cjx.social.config.Constants;
import com.cjx.social.utils.FastDFSUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 17858 on 2018-05-18.
 */
@Controller
@RequestMapping("/file")
public class FileController {


    @RequestMapping("/upload")
    @ResponseBody
    public String test() {
        return FastDFSUtil.uploadImage("E:\\3.png", "png");
    }

    @RequestMapping("/upload1")
    @ResponseBody
    public String addUsers(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request)
            throws Exception {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
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
        return FastDFSUtil.uploadImage(targetFile.getAbsolutePath(), extName);
    }


    private String srcFileDir = "E:\\upload\\000274 ELEMENTARY WATER COLOUR PAINTING";

    @RequestMapping("/test")
    @ResponseBody
    public void copyFile() throws Exception {
        for (int num = 0; num < Constants.ancientBookNameList.length; num++) {
            StringBuilder sb = new StringBuilder("");
            if (num < 9) {
                sb.append("00000").append(num+1);
            } else {
                sb.append("0000").append(num+1);
            }
            String destPath = "E:\\bookTest" + "\\" + sb.toString();
            List<String> srcFilePath = readfile(srcFileDir);
            File file1 = new File(destPath);
            if (!file1.exists()) {
                file1.mkdir();
            }
            for (int i = 0; i < srcFilePath.size(); i++) {
                StringBuilder sb2 = new StringBuilder("");
                sb2.append(sb).append(" ").append(Constants.ancientBookNameList[num] + 1).append("-").append(i + 1).append(".jpg");
                File targetFile = new File(file1, sb2.toString());
                try {
                    InputStream inputStream = new FileInputStream(srcFilePath.get(i));
                    FileUtils.copyInputStreamToFile(inputStream, targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<String> readfile(String filePath) {
        List<String> fileList = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.isDirectory()) {
                System.out.println("文件");
                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());

            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filePath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        fileList.add(readfile.getAbsolutePath());
                    } else if (readfile.isDirectory()) {
                        //readfile(filepath + "\\" + filelist[i]);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }

        return fileList;
    }
}
