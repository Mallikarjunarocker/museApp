package com.itc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itc.main.entity.Bookmarks;
@Repository
public interface BookmarksRepository extends JpaRepository<Bookmarks, Integer> {

	List<Bookmarks> findBookmarksByLocation(String location);

}
