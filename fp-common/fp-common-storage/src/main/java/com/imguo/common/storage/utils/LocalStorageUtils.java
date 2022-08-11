package com.imguo.common.storage.utils;


import com.imguo.common.storage.properties.LocalStorageProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
public class LocalStorageUtils {

    private final LocalStorageProperties storageConfig;

    /**
     * 上传文件
     *
     */
    public  String uploadFile(MultipartFile file) {
        String realPath = storageConfig.getPath();
        //按日期放置文件
        String dateDir = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File dir = new File(realPath,dateDir);
        if(!dir.exists()) {//如果路径不存在就创建文件夹
            dir.mkdir();
        }
        String newFileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+ UUID.randomUUID().toString();
        String suffixName = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        String newFileName = newFileNamePrefix+"."+suffixName;

        File localFile = new File(dir,newFileName);

        try {
            file.transferTo(localFile);
            return dateDir+"/"+newFileName;
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }
}
