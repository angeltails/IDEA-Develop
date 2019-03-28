package com.jt.manager.service;

import com.jt.common.vo.PicUploadResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{
private String dirPath="D:/howfunction/jpeg/";
    @Override
    public PicUploadResult uploadFile(MultipartFile uploadFile) {
        PicUploadResult result = new PicUploadResult();
        String fileName = uploadFile.getOriginalFilename();
        fileName = fileName.toLowerCase();
//        "^.*\\.(jpg|png|gif)$"中间不能多空格
//        "^.* \\.(jpg|png|gif)$"多空格上传失败
        if(!fileName.matches("^.*\\.(jpg|png|gif)$")){
             result.setError(1);
             return result;
        }
        try {
            BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            if(width==0||height==0){
                result.setError(1);
                return result;
            }
            String dateDir = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            String  uuid= UUID.randomUUID().toString().replace("-", "");
            int random = new Random().nextInt(1000);
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            String uuidFileName = uuid + random+fileType;
            String fileDirPath = dirPath + dateDir;
            File fileDir = new File(fileDirPath);
            if(!fileDir.exists()){
                fileDir.mkdirs();
            }
            File realFilePath = new File(fileDirPath + "/" + uuidFileName);
            uploadFile.transferTo(realFilePath);
            result.setHeight(height+"");
            result.setWidth(width+"");
        } catch (IOException e) {
            e.printStackTrace();
            result.setError(1);
        }

        return result;
    }
}
