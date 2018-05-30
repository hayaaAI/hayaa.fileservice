package hayaa.file.service.core;

import hayaa.basemodel.model.FunctionOpenResult;
import hayaa.file.service.FileResult;
import hayaa.file.service.IFileService;
import org.springframework.stereotype.Service;

@Service("fileService")
public class FileService implements IFileService {
    private OssConfig ossConfig = ConfigHelper.getInstance().GetComponentConfig();

    /**
     * 上传文件至阿里云oss
     *
     * @param file 文件内容
     * @return 包括上传成功后的http请求地址
     */
    @Override
    public FunctionOpenResult<FileResult> upload(FileResult file) {
        FunctionOpenResult<FileResult> r = new FunctionOpenResult<FileResult>();
        OssUploadResult uploadResult=AliyunOssProvider.uploadFile(ossConfig.getEndPoint(),
                ossConfig.getAccessKeyId(),ossConfig.getAccessKeySecret(),
                ossConfig.getBucket(),file.getFileName(),file.getDirectoryName(),file.getFileData());
        file.setAction(uploadResult.getAction());
        file.setFileUrl(uploadResult.getResult().toString());
        file.setMessage(uploadResult.getMessage());
        r.setData(file);
        return r;
    }
}
