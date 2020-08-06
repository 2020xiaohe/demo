package com.ffcs.demo.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

/**
 * 图片处理工具类，包含图片上传
 * Created by hemb on 2020/8/4.
 */
public class PicUtils {
    private Logger logger = LoggerFactory.getLogger(PicUtils.class);
    //这是本地存入的格式，上传到服务器的话，格式类似于，"/root/images/pc/"
    private static String UPLOAD_FOLDER = "D:/images/pc/";
//    private static String UPLOAD_FOLDER = "/root/images/";
    //Thread.currentThread().getContextClassLoader().getResource("").getPath();(获取当前的绝对路径的方法，这里不用，得到的是这样的东西:file:/D:/java/eclipse32/workspace/jbpmtest3/bin/)
    public static String singleFileUpload(MultipartFile pc1 ) throws IOException {
        if (Objects.isNull(pc1) || pc1.isEmpty()) {//判断非空
            return "文件为空，请重新上传";
        }
        try {
            byte[] bytes = pc1.getBytes();
            //要存入本地的地址放到path里面
            Path path = Paths.get( UPLOAD_FOLDER+"/");
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(path);
            }
            String extension = getFileExtension(pc1);

            UUID uuid = UUID.randomUUID();
            String str = uuid.toString();
            //UUID格式xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx ,去掉"-"符号
            String picname = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) +   str.substring(19, 23) + str.substring(24);
            String relativeAddr = picname  + extension;  //唯一的名字接上后缀
            Thumbnails.of(pc1.getInputStream()).size(200, 200)    //写入
                    .outputQuality(0.8f).toFile(path+"/"+relativeAddr);
            //logger.debug("文件写入成功...");
            return Paths.get(path + "/" + relativeAddr).toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }

    // 获取文件后缀
    private static String getFileExtension(MultipartFile File) {
        String originalFileName = File.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));

    }

}
