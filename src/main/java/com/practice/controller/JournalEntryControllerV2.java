package com.practice.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.JournalEntry;
import com.practice.entity.User;
import com.practice.service.JournalEntryService;
import com.practice.service.UserService;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

	@Autowired
	private JournalEntryService journalEntryService;
	
	@Autowired
	private UserService userService;

	@GetMapping("{userName}")
	public ResponseEntity<List<JournalEntry>> getAllJournalEntriesOfUser(@PathVariable String userName) {
		User user = userService.findByUserName(userName);
		List<JournalEntry> all = user.getJournalEntries();
		if (all != null && !all.isEmpty()) {
			return new ResponseEntity<>(all, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("{userName}")
	public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry journalEntry,@PathVariable String userName) {
		try {
			journalEntryService.saveEntry(journalEntry,userName);
			return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("id/{myId}")
	public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId) {
		Optional<JournalEntry> jounalEntry = journalEntryService.findById(myId);
		if (jounalEntry.isPresent()) {
			return new ResponseEntity<>(jounalEntry.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("id/{userName}/{myId}")
	public ResponseEntity<JournalEntry> deleteById(@PathVariable ObjectId myId,@PathVariable String userName) {
		journalEntryService.deleteById(myId,userName);
		return new ResponseEntity<>(HttpStatus.OK);
	}

//	@PutMapping("id/{myId}")
//	public ResponseEntity<?> updateById(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry) {
//		JournalEntry old = journalEntryService.findById(myId).orElse(null);
//		if (old != null) {
//			old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle()
//					: old.getTitle());
//			old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent()
//					: old.getContent());
//			journalEntryService.saveEntry(old);
//			return new ResponseEntity<>(old, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
}