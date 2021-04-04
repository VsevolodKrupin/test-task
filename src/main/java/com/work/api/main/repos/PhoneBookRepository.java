package com.work.api.main.repos;

import com.work.api.main.entities.PhoneBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vsevolod Krupin
 */
@Repository
public interface PhoneBookRepository extends CrudRepository<PhoneBook, Long>
{
}
