package com.practice.service;

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

}
