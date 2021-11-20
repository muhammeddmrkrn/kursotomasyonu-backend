package tr.com.turktelekom.kursotomasyonu.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.turktelekom.kursotomasyonu.entity.Ogretmen;
import tr.com.turktelekom.kursotomasyonu.service.OgretmenService;

import java.util.List;

@RestController
@RequestMapping("/api/ogretmen")
@Log4j2
@CrossOrigin(origins = "http://localhost:3000")
public class OgretmenController {

    @Autowired private OgretmenService ogretmenService;

    @GetMapping
    public ResponseEntity<?> list() {
        try {
            List<Ogretmen> ogretmenList = ogretmenService.getOgretmenList();
            return new ResponseEntity<>(ogretmenList, HttpStatus.OK);
        }catch (Throwable t){
            return ResponseEntity.status(204).body("backend hata");
        }
    }

    @PostMapping
    public ResponseEntity<?> ekle(@RequestBody Ogretmen ogretmen) {
        try {
            boolean result = ogretmenService.ekle(ogretmen);
            return ResponseEntity.status(200).body(result);
        }catch (Throwable t){
            log.error(t);
            return ResponseEntity.status(204).body("backend hata");
        }
    }

}
