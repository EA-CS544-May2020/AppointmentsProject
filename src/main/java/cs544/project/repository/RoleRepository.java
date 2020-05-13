package cs544.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cs544.project.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}