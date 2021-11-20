package tr.com.turktelekom.kursotomasyonu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.turktelekom.kursotomasyonu.entity.Ogretmen;
import tr.com.turktelekom.kursotomasyonu.repository.OgretmenRepository;

import java.util.List;

@Service
@Transactional
public class OgretmenService {
    @Autowired private OgretmenRepository ogretmenRepository;

    public List<Ogretmen> getOgretmenList(){
        List<Ogretmen> ogretmenList= ogretmenRepository.findAll();
        if(ogretmenList == null)
            return null;
        return ogretmenList;
    }

    public boolean ekle(Ogretmen ogretmen) {
        ogretmenRepository.save(ogretmen);
        return true;
    }
}
