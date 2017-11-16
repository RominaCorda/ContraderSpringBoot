package it.com.ibm.generali.capitalreporting.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploaderService
{
    boolean uploadFile(MultipartFile file);
}
