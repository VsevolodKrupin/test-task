package com.work.api.main.repos;

import com.work.api.main.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Vsevolod Krupin
 */
public interface UserRepository extends CrudRepository<User, Long>
{
}
