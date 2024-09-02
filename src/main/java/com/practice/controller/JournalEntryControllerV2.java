package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.JournalEntry;
import com.practice.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
	
	@Autowired
	private JournalEntryService journalEntryService;
	
	@GetMapping("/all-entries")
	public List<JournalEntry> getAll() {
		return null;
	}

	@PostMapping()
	public boolean createEntry(@RequestBody JournalEntry journalEntry) {
		journalEntryService.saveEntry(journalEntry);
		return true;
	}

	@GetMapping("id/{myId}")
	public JournalEntry getJournalEntryById(@PathVariable Long myId) {
		return null;
	}

	@DeleteMapping("id/{myId}")
	public JournalEntry deleteById(@PathVariable Long myId) {
		return null;
	}

	@PutMapping("id/{myId}")
	public JournalEntry updateById(@PathVariable Long myId, @RequestBody JournalEntry journalEntry) {
		return null;
	}

}
