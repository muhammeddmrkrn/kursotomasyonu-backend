package tr.com.turktelekom.kursotomasyonu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.turktelekom.kursotomasyonu.entity.Ogrenci;
import tr.com.turktelekom.kursotomasyonu.repository.OgrenciRepository;

import java.util.List;

@Service
@Transactional
public class OgrenciService {
    @Autowired private OgrenciRepository ogrenciRepository;

    public List<Ogrenci> getOgrenciList(){
        List<Ogrenci> ogrenciList= ogrenciRepository.findAll();
        if(ogrenciList == null)
            return null;
        return ogrenciList;
    }

    public boolean ekle(Ogrenci ogrenci) {
        ogrenciRepository.save(ogrenci);
        return true;
    }
}
