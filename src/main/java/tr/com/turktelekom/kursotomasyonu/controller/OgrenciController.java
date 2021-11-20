package tr.com.turktelekom.kursotomasyonu.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.turktelekom.kursotomasyonu.entity.Ogrenci;
import tr.com.turktelekom.kursotomasyonu.service.OgrenciService;

import java.util.List;

@RestController
@RequestMapping("/api/ogrenci")
@Log4j2
@CrossOrigin(origins = "http://localhost:3000")
public class OgrenciController {

    @Autowired private OgrenciService ogrenciService;

    @GetMapping
    public ResponseEntity<?> list() {
        try {
            List<Ogrenci> ogrenciList = ogrenciService.getOgrenciList();
            return new ResponseEntity<>(ogrenciList, HttpStatus.OK);
        }catch (Throwable t){
            return ResponseEntity.status(204).body("backend hata");
        }
    }

    @PostMapping
    public ResponseEntity<?> ekle(@RequestBody Ogrenci ogrenci) {
        try {
            boolean result = ogrenciService.ekle(ogrenci);
            return ResponseEntity.status(200).body(result);
        }catch (Throwable t){
            log.error(t);
            return ResponseEntity.status(204).body("backend hata");
        }
    }

}
