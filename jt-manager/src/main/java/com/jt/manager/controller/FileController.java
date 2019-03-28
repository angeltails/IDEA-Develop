package com.jt.manager.controller;

import com.jt.common.vo.PicUploadResult;
import com.jt.manager.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping("/file")
    public String file(MultipartFile fileImage) throws IOException {
        File fileDir = new File("D:/howfunction/jpeg");
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        String fileName = fileImage.getOriginalFilename();
        fileImage.transferTo(new File("D:/howfunction/jpeg/" + fileName));
        return "redirect:/file.jsp";
    }

    @RequestMapping("/pic/upload")
    @ResponseBody
    public PicUploadResult uploadFile(MultipartFile uploadFile){
        return fileService.uploadFile(uploadFile);
    }

}
