package com.yuriityshchuk.justproject.service;

import com.yuriityshchuk.justproject.exception.FileNameException;
import com.yuriityshchuk.justproject.model.DBFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBFileService {

//    private final DBFileRepo dbFileRepo;
//
//    public DBFileService(DBFileRepo dbFileRepo) {this.dbFileRepo = dbFileRepo;}
//
//    public DBFile saveFile(MultipartFile file) {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        try {
//            if (fileName.contains("..")) {
//                throw new FileNameException("Поменяй название, дятел " + fileName);
//            }
//            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
//            return dbFileRepo.save(dbFile);
//        } catch (IOException e) {
//            throw new FileNameException("Не сохранилось вот это => " + fileName + ". Попытайся еще раз, мб получиться", e);
//        }
//    }

    public List<DBFile> convertForDB(List<MultipartFile> files) {

        List<DBFile> dbFiles = new ArrayList<>();

        for (MultipartFile file : files) {
            try {
                dbFiles.add(new DBFile(file.getName(), file.getContentType(), file.getBytes()));
            } catch (IOException e) {
                throw new FileNameException("Не сохранилось вот это => " + file.getName() + ". Попытайся еще раз, мб получиться", e);
            }
        }
        return dbFiles;
    }
}
