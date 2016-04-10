package com.gologo13.com.gologo13.repository;

import com.gologo13.com.gologo13.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

/**
 * Created by yohei on 4/10/16.
 */
@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

}
