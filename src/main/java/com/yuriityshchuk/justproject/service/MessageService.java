package com.yuriityshchuk.justproject.service;

import com.yuriityshchuk.justproject.model.Customer;
import com.yuriityshchuk.justproject.model.DBFile;
import com.yuriityshchuk.justproject.model.Message;
import com.yuriityshchuk.justproject.model.Subject;
import com.yuriityshchuk.justproject.repository.MessageRepo;
import com.yuriityshchuk.justproject.repository.SubjectRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepo messageRepo;
    private final SubjectRepo subjectRepo;

    public MessageService(MessageRepo messageRepo, SubjectRepo subjectRepo) {
        this.messageRepo = messageRepo;
        this.subjectRepo = subjectRepo;
    }

    public String addMessage(String course, String semester, Subject subject, String message, Customer customers, List<DBFile> dbFile) {
        int c = Integer.parseInt(course);
        int s = Integer.parseInt(semester);
        if (c > 5) return "notCorrectCourse";
        if (s > 10) return "notCorrectSemester";

        Message messageForDB = new Message(course, semester, message, customers);

        if (subjectRepo.findBySubject(subject.getSubject()) == null) {
            subjectRepo.save(subject);
        }
        messageForDB.setSubject(subjectRepo.findBySubject(subject.getSubject()));
        messageForDB.setDbFile(dbFile);

        messageRepo.save(messageForDB);

        return "mesSave";
    }
}
