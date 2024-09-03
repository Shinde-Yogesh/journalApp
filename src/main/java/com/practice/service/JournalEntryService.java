package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

}
