package com.holik.simpeg.server.repository;

import com.holik.simpeg.shared.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
//import com.holik.simpeg.share.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
