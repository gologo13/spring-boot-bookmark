package com.gologo13.com.gologo13.service;

import com.gologo13.com.gologo13.model.Bookmark;
import com.gologo13.com.gologo13.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

/**
 * Created by yohei on 4/10/16.
 */
@Service
@Transactional
public class BookmarkService {

    @Autowired
    private BookmarkRepository repository;

    public Bookmark save(@NotNull Bookmark bookmark) {
        return repository.save(bookmark);
    }

    public List<Bookmark> getList() {
        return repository.findAll(new Sort(Sort.Direction.ASC, "id"));
    }

    public void deleteById(Long id) {
        repository.delete(id);
    }

    public Bookmark getOneById(Long id) {
        return repository.findOne(id);
    }

}
