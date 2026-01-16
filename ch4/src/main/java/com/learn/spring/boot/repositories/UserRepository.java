// user access
// for Authentication only
// Authentication should read only. It should never be able to modify or delete users
package com.learn.spring.boot.repositories;
public interface UserRepository extends Repository<UserAccount, Long>
{
    // since this class extends Repository, it only has methods that we declare
    UserAccount findByUsername(String username);
}
