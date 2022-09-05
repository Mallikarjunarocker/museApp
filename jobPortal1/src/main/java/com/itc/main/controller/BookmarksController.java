package com.itc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.main.entity.Bookmarks;
import com.itc.main.entity.Jobs;
import com.itc.main.services.BookmarksService;

@RestController
@RequestMapping("/bmk/")
public class BookmarksController {
	@Autowired
	private BookmarksService bookmarksService;
	
	@PostMapping("save")
	public ResponseEntity saveBookmarks(@RequestBody Bookmarks bookmark) {
		this.bookmarksService.savebookmarks(bookmark);
		return new ResponseEntity("SUCESSFULLY CREATED", HttpStatus.OK);
	}
	
	@GetMapping("bookmark")
	public ResponseEntity getBookmarks() {
		List<Bookmarks> li = this.bookmarksService.getAllBookmarks();
		if(li != null) {
			return new ResponseEntity(li,HttpStatus.OK);
		}
		else
			return new ResponseEntity("NOT-FOUNDS",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("bookmarks/{id}")
	public ResponseEntity getBookmarksById(@PathVariable int id) {
		Bookmarks li = this.bookmarksService.getBookmarksById(id);
		if(li != null) {
			return new ResponseEntity(li,HttpStatus.OK);
		}
		else
			return new ResponseEntity("NOT-FOUNDS",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("bookmark/{location}")
	public ResponseEntity getBookmarksByLocation(@PathVariable String location) {
		List<Bookmarks> li = this.bookmarksService.getBookmarksByLocation(location);
		if(li != null) {
			return new ResponseEntity(li,HttpStatus.OK);
		}
		else
			return new ResponseEntity("NOT-FOUNDS",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("bookmark/{id}")
	public ResponseEntity deleteBookmarks(@PathVariable int id) {
		boolean b = this.bookmarksService.DeleteBookmarks(id);
		if(b) {
			return new ResponseEntity("DELETED SUCCESFULLY",HttpStatus.OK);
			
		}
		else 
			return new ResponseEntity("NOT_FOUND",HttpStatus.NOT_FOUND);
	}
	
	

}
