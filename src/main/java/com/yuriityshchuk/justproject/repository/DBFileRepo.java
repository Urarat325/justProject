package com.yuriityshchuk.justproject.repository;

import com.yuriityshchuk.justproject.model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBFileRepo extends JpaRepository<DBFile, String> {
}
