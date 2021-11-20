package tr.com.turktelekom.kursotomasyonu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.turktelekom.kursotomasyonu.dto.DersProgramiDto;
import tr.com.turktelekom.kursotomasyonu.entity.DersProgrami;
import tr.com.turktelekom.kursotomasyonu.entity.Ogrenci;
import tr.com.turktelekom.kursotomasyonu.entity.Ogretmen;
import tr.com.turktelekom.kursotomasyonu.repository.DersProgramiRepository;
import tr.com.turktelekom.kursotomasyonu.repository.OgrenciRepository;
import tr.com.turktelekom.kursotomasyonu.repository.OgretmenRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DersProgramiService {
    @Autowired private DersProgramiRepository dersProgramiRepository;
    @Autowired private OgretmenRepository ogretmenRepository;
    @Autowired private OgrenciRepository ogrenciRepository;

    public List<DersProgrami> getDersProgramiList(){
        List<DersProgrami> dersProgramiList= dersProgramiRepository.findAll();
        if(dersProgramiList == null)
            return null;
        return dersProgramiList;
    }

    public boolean ekle(DersProgramiDto dto) {
        Ogretmen ogretmen = ogretmenRepository.findById(dto.getOgretmenId()).get();
        Ogrenci ogrenci = ogrenciRepository.findById(dto.getOgrenciId()).get();

        DersProgrami dersProgrami = new DersProgrami();
        dersProgrami.setDersAdi(dto.getDersAdi());
        dersProgrami.setBaslangicSaati(dto.getBaslangicSaati());
        dersProgrami.setBitisSaati(dto.getBitisSaati());
        dersProgrami.setOgretmen(ogretmen);
        dersProgrami.setOgrenci(ogrenci);
        dersProgrami.setGun(dto.getGun());
        dersProgramiRepository.save(dersProgrami);

        return true;
    }
}
