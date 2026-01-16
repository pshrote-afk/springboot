// full Admin access
// JpaRepository gives save(), delete(), findAll()
package com.learn.spring.boot.repositories;
import com.learn.spring.boot.pojos;
public interface UserManagementRepository extends JpaRepository<UserAccount,Long>
{

}
