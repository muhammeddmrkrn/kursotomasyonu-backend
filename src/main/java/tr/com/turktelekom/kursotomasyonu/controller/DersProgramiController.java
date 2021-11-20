package tr.com.turktelekom.kursotomasyonu.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.turktelekom.kursotomasyonu.dto.DersProgramiDto;
import tr.com.turktelekom.kursotomasyonu.entity.DersProgrami;
import tr.com.turktelekom.kursotomasyonu.service.DersProgramiService;

import java.util.List;

@RestController
@RequestMapping("/api/dersprogrami")
@Log4j2
@CrossOrigin(origins = "http://localhost:3000")
public class DersProgramiController {

    @Autowired private DersProgramiService dersProgramiService;

    @GetMapping
    public ResponseEntity<?> list() {
        try {
            List<DersProgrami> dersProgramiList = dersProgramiService.getDersProgramiList();
            return new ResponseEntity<>(dersProgramiList, HttpStatus.OK);
        }catch (Throwable t){
            return ResponseEntity.status(204).body("backend hata");
        }
    }

    @PostMapping
    public ResponseEntity<?> ekle(@RequestBody DersProgramiDto dersProgramiDto) {
        try {
            boolean result = dersProgramiService.ekle(dersProgramiDto);
            return ResponseEntity.status(200).body(result);
        }catch (Throwable t){
            log.error(t);
            return ResponseEntity.status(204).body("backend hata");
        }
    }

}
