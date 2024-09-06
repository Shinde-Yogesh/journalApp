package com.practice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.JournalEntry;
import com.practice.entity.User;
import com.practice.repository.JournalEntryRepository;

@Service
public class JournalEntryService {

	@Autowired
	private JournalEntryRepository journalEntryRepository;
	
	@Autowired UserService userService;

	public void saveEntry(JournalEntry journalEntry, String userName) {
		
		journalEntry.setDate(LocalDateTime.now());
		User user = userService.findByUserName(userName);
		JournalEntry saved = journalEntryRepository.save(journalEntry);
		user.getJournalEntries().add(saved);
		userService.saveEntry(user);
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
	
	public void deleteById(ObjectId id, String userName)
	{
		User user = userService.findByUserName(userName);
		user.getJournalEntries().removeIf(x -> x.getId().equals(id));
		userService.saveEntry(user);
		journalEntryRepository.deleteById(id);
	}

}
