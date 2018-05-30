package hayaa.file.service;

import hayaa.basemodel.model.FunctionOpenResult;

public interface IFileService {
    /**
     * 上传文件至阿里云oss
     * @param file 文件内容
     * @return 包括上传成功后的http请求地址
     */
    FunctionOpenResult<FileResult> upload(FileResult file);
}
