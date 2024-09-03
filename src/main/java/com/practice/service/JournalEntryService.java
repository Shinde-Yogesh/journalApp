package com.practice.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.JournalEntry;
import com.practice.repository.JournalEntryRepository;

@Service
public class JournalEntryService {

	@Autowired
	private JournalEntryRepository journalEntryRepository;

	public void saveEntry(JournalEntry journalEntry) {
		journalEntryRepository.save(journalEntry);
	}
	
	public List<JournalEntry> getAll()
	{
		return journalEntryRepository.findAll();
	}
	
	public boolean createEntry(JournalEntry journalEntry) {
		journalEntryRepository.save(journalEntry);
		return true;
	}
	
	public Optional<JournalEntry> findById(ObjectId id)
	{
		return journalEntryRepository.findById(id);
	}
	
	public void deleteById(ObjectId id)
	{
		journalEntryRepository.deleteById(id);
	}

}
