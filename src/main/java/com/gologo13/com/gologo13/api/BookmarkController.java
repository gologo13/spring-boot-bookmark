package com.gologo13.com.gologo13.api;

import com.gologo13.com.gologo13.model.Bookmark;
import com.gologo13.com.gologo13.repository.BookmarkRepository;
import com.gologo13.com.gologo13.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by yohei on 4/3/16.
 */
@RestController
public class BookmarkController {

    @Autowired
    private BookmarkService service;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping(path = "/api/bookmarks", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Bookmark> getBookmarks() {
        return service.getList();
    }

    @RequestMapping(path = "/api/bookmarks", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Bookmark postBookmark(@Valid @RequestBody Bookmark bookmark) {
        return service.save(bookmark);
    }

    @RequestMapping(path = "/api/bookmarks/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookmark(@PathVariable Long id) {
        service.deleteById(id);
    }

    @RequestMapping(path = "/api/bookmarks/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Bookmark getBookmark(@PathVariable Long id) {
        return service.getOneById(id);
    }

}
