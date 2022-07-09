package cn.com.wudskq.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @author chenfangchao
 * @title: AliYunOSSUtil
 * @projectName wc-manager-system
 * @description: TODO 阿里云oss
 * @date 2022/7/10 1:52 AM
 */
@Component
public class AliYunOSSUtil {

    Logger logger = LoggerFactory.getLogger(getClass());

    //yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
    @Value("${aliyun.endpoint}")
    private String endpoint;

    //阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.accessKeySecret}")
    private String accessKeySecret;

    // 填写Bucket名称，例如examplebucket。
    @Value("${aliyun.bucketName}")
    private String bucketName;

    // 填写文件路径，不包含Bucket名称。例如exampledir
    @Value("${aliyun.bucketDirName}")
    private String bucketDirName;


    /**
     * 创建OSS实例对象
     * @return
     */
    public OSS getOssInstance(){
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        return ossClient;
    }

    /**
     * 上传文件到OSS
     * @param file
     */
    public void uploadFile(File file,String objectName){
        OSS ossClient = getOssInstance();
        String filePath = bucketDirName +"/"+ objectName;
        try {
            byte[] bytes = FileUtil.FileTobyte(file);
            ossClient.putObject(bucketName, filePath, new ByteArrayInputStream(bytes));
        } catch (OSSException oe) {
            logger.info("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            logger.info("Error Message:" + oe.getErrorMessage());
            logger.info("Error Code:" + oe.getErrorCode());
            logger.info("Request ID:" + oe.getRequestId());
            logger.info("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            logger.info("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            logger.info("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }


    /**
     * 从OSS下载文件
     * @param objectName
     */
    public void downloadFile(String objectName){
        OSS ossClient = getOssInstance();
        try {
            // 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
            OSSObject ossObject = ossClient.getObject(bucketName, objectName);
            // 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
            InputStream content = ossObject.getObjectContent();
            if (content != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {break;}
                    System.out.println("\n" + line);
                }
                // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
                content.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
    }
}
