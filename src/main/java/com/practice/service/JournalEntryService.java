package com.practice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.entity.JournalEntry;
import com.practice.entity.User;
import com.practice.repository.JournalEntryRepository;

@Service
public class JournalEntryService {

	@Autowired
	private JournalEntryRepository journalEntryRepository;
	
	@Autowired UserService userService;

	@Autowired
	private RedisService redisService;

	@Transactional
	public void saveEntry(JournalEntry journalEntry, String userName) {
		
		journalEntry.setDate(LocalDateTime.now());
		User user = userService.findByUserName(userName);
		JournalEntry saved = journalEntryRepository.save(journalEntry);
		user.getJournalEntries().add(saved);
		userService.saveUser(user);
	}
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
	
	@Transactional
	public boolean deleteById(ObjectId id, String userName)
	{
		boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id)); //this code deleted in both table (means constancy on current transaction)
            if(removed) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
			System.out.println(e);
            throw new RuntimeException("An Error occurred while deleting the entry.",e);
        }
		return removed;
    }


    //Using the redis
	public List<JournalEntry> getJournalEntries(String userName) {
		// Check if journal entries are cached in Redis
		List<JournalEntry> journalEntries = redisService.get("journal_entries_of_" + userName, List.class);
		if (journalEntries != null) {
			return journalEntries;
		}

		// Fetch journal entries from the database if not in cache
		User user = userService.findByUserName(userName);
		List<JournalEntry> all = user.getJournalEntries();

		if (all != null && !all.isEmpty()) {
			// Cache journal entries in Redis with a TTL (e.g., 5 minutes)
			redisService.set("journal_entries_of_" + userName, all, 300L);
		}
		return all;
	}
}
