package be.ucll.IP.Minor.repository;


import be.ucll.IP.Minor.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


@Repository
public interface JPARepo extends JpaRepository<Task, Long>{

}
