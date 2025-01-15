package com.ganseo.ganseo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.keywords LIKE %:keyword% ORDER BY b.year DESC")
    List<Book> findByKeyword(@Param("keyword") String keyword);
}
