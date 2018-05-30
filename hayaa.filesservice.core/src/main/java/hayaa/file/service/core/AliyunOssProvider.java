package hayaa.file.service.core;

import com.aliyun.oss.OSSClient;

import java.io.ByteArrayInputStream;

class AliyunOssProvider {
    public static OssUploadResult uploadFile(String endpoint, String accessKeyId,
                                             String accessKeySecret, String bucketName,
                                             String file,String dicName, byte[] filedData) {
        OssUploadResult r = new OssUploadResult();
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            ossClient.putObject(bucketName+"/"+dicName, file, new ByteArrayInputStream(filedData));
            r.setResult(endpoint+"/"+dicName+"/"+file);
        } catch (Exception ex) {
            r.setResult(false);
            r.setMessage(ex.getMessage());
        }
        ossClient.shutdown();
        return r;
    }
}
