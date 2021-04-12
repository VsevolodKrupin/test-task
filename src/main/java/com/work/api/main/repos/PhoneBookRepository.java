package com.work.api.main.repos;

import com.work.api.main.entities.PhoneBook;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Vsevolod Krupin
 */

public interface PhoneBookRepository extends CrudRepository<PhoneBook, Long>
{
}
