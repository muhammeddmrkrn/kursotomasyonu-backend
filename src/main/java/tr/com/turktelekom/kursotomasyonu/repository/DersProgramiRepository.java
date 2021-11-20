package tr.com.turktelekom.kursotomasyonu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.turktelekom.kursotomasyonu.entity.DersProgrami;

@Repository
public interface DersProgramiRepository extends JpaRepository<DersProgrami,Integer>{

}