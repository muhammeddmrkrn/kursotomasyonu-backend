package tr.com.turktelekom.kursotomasyonu.dto;

import lombok.*;
import tr.com.turktelekom.kursotomasyonu.enums.Ders;
import tr.com.turktelekom.kursotomasyonu.enums.Gun;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DersProgramiDto {
    private BigInteger id;
    private Ders dersAdi;
    private Integer baslangicSaati;
    private Integer bitisSaati;
    private Integer ogretmenId;
    private Gun gun;
    private Integer ogrenciId;
}
