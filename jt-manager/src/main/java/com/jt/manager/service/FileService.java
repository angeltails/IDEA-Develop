package com.jt.manager.service;

import com.jt.common.vo.PicUploadResult;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    PicUploadResult uploadFile(MultipartFile uploadFile);
}
