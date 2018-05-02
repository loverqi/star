package cn.loverqi.star.core.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 实现上传文件的操作类
 * @author LoverQi
 * @date 2018年3月28日
 */
public class FileUtil {
    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 上传文件的保存
     * @param FilePath 保存路径
     * @param file 需要保存的文件
     * @return 是否成功
     */
    public static boolean uploadFile(String filePath, String fileName, MultipartFile file) {
        boolean ifSuccess = false;

        if (file == null) {
            LOG.error("文件不能为空");
        } else {
            File desFile = new File(filePath, fileName);
            File fileParent = desFile.getParentFile();
            if (!fileParent.exists()) {
                fileParent.mkdirs();
            }
            try {
                file.transferTo(desFile);
            } catch (IOException e) {
                LOG.error("文件 [" + file.getOriginalFilename() + "] 创建失败");
            }

            ifSuccess = true;
        }

        return ifSuccess;
    }

    /**
     * 上传文件的保存
     * @param file 需要保存的文件
     * @return 是否成功
     */
    public static boolean uploadFile(String fileName, MultipartFile file) {
        boolean ifSuccess = uploadFile(getClassPath() + "/static/photo", fileName, file);

        return ifSuccess;
    }

    /**
     * 上传文件的保存
     * @param file 需要保存的文件
     * @return 是否成功
     */
    public static boolean uploadFile(MultipartFile file) {
        boolean ifSuccess = uploadFile(getClassPath() + "/static/photo", file.getOriginalFilename(), file);

        return ifSuccess;
    }

    /**
     * 获取项目路径
     * @return
     * @throws FileNotFoundException
     */
    public static String getClassPath() {

        //获取跟目录
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            LOG.error("路径获取失败");
        }
        if (!path.exists()) {
            path = new File("");
        }

        return path.getAbsolutePath();
    }

    /**
     * 删除文件
     * @param fullFilePath 文件的全路径
     */
    public static void deleteFile(String fullFilePath) {
        deleteFile(new File(fullFilePath));
    }

    /**
     * 删除文件
     * @param file 文件本身
     */
    public static void deleteFile(File file) {
        file.delete();
    }

    private FileUtil() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

}
