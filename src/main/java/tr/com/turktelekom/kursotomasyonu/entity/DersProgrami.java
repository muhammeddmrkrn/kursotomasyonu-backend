package tr.com.turktelekom.kursotomasyonu.entity;

import lombok.*;
import tr.com.turktelekom.kursotomasyonu.enums.Ders;
import tr.com.turktelekom.kursotomasyonu.enums.Gun;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(schema = "kursotomasyonu")
public class DersProgrami {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private Ders dersAdi;
    private Integer baslangicSaati;
    private Integer bitisSaati;
    private Gun gun;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "ogretmen_id", referencedColumnName = "id")
    })
    private Ogretmen ogretmen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "ogrenci_id", referencedColumnName = "id")
    })
    private Ogrenci ogrenci;
}
