package hayaa.file.service.core;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;

import java.io.ByteArrayInputStream;

class AliyunOssProvider {
    public static OssUploadResult uploadFile(String endpoint, String accessKeyId,
                                             String accessKeySecret, String bucketName,
                                             String file,String dicName, byte[] filedData) {
        OssUploadResult r = new OssUploadResult();
         OSSClient ossClient =null;
        try {
             ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            ossClient.putObject(bucketName, dicName+"/"+file, new ByteArrayInputStream(filedData));
            r.setResult(endpoint+"/"+dicName+"/"+file);
            r.setAction(true);
        } catch (Exception ex) {
            r.setResult(false);
            r.setMessage(ex.getMessage());
            r.setAction(false);
        }finally {
            ossClient.shutdown();
        }

        return r;
    }
}
