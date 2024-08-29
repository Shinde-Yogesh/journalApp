package com.practice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.JournalEntry;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
	Map<Long, JournalEntry> journalEntries = new HashMap<>();

	@GetMapping("/all-entries")
	public List<JournalEntry> getAll() {
		return new ArrayList<>(journalEntries.values());
	}

	@PostMapping()
	public boolean createEntry(@RequestBody JournalEntry journalEntry) {
		journalEntries.put(journalEntry.getId(), journalEntry);
		return true;
	}

	@GetMapping("id/{myId}")
	public JournalEntry getJournalEntryById(@PathVariable Long myId) {
		return journalEntries.get(myId);
	}

	@DeleteMapping("id/{myId}")
	public JournalEntry deleteById(@PathVariable Long myId) {
		return journalEntries.remove(myId);
	}

	@PutMapping("id/{myId}")
	public JournalEntry updateById(@PathVariable Long myId, @RequestBody JournalEntry journalEntry) {
		return journalEntries.put(myId, journalEntry);
	}

}
