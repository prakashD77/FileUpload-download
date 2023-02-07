package com.mss.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mss.entity.ImageData;
import com.mss.repository.Storagerepository;
import com.mss.utils.ImageUtils;

@Service
public class StorageService {
	@Autowired
	Storagerepository repository;

	public String uploadImage(MultipartFile file) throws IOException {

		ImageData imageData = repository.save(ImageData.builder().name(file.getOriginalFilename())
				.type(file.getContentType()).imagedata(ImageUtils.compressImage(file.getBytes())).build());
		if (imageData != null) {
			return "file uploaded successfully : " + file.getOriginalFilename();
		}
		return null;
	}
    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImagedata());
        return images;
    }
	}
	
	
