package com.itc.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.main.entity.Bookmarks;
import com.itc.main.repository.BookmarksRepository;

@Service
public class BookmarksService {
	@Autowired
	private BookmarksRepository bookmarksRepository;
	
	public void savebookmarks(Bookmarks b1) {
		this.bookmarksRepository.save(b1);
		
	}
	public List<Bookmarks> getAllBookmarks(){
		List<Bookmarks> l1 = this.bookmarksRepository.findAll();
		return l1;
	}
	public List<Bookmarks> getBookmarksByLocation(String Location){
		List<Bookmarks> l1 = this.bookmarksRepository.findBookmarksByLocation(Location);
		return l1;
	}
	public Bookmarks getBookmarksById(int JobId){
		Optional<Bookmarks> l1 = this.bookmarksRepository.findById(JobId);
		if(l1.isPresent()) {
			return l1.get();
		}
		else 
				return null;
		
	}
	public boolean DeleteBookmarks(int JobId) {
		this.bookmarksRepository.deleteById(JobId);
		return true;
	}
	
	

}
