package tr.com.turktelekom.kursotomasyonu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.turktelekom.kursotomasyonu.entity.Ogretmen;

@Repository
public interface OgretmenRepository extends JpaRepository<Ogretmen,Integer>{

}