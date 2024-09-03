package com.practice.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.JournalEntry;
@Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId>{

}
