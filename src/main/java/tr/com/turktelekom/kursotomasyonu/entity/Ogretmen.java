package tr.com.turktelekom.kursotomasyonu.entity;

import lombok.*;
import tr.com.turktelekom.kursotomasyonu.enums.Ders;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(schema = "kursotomasyonu")
public class Ogretmen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String adi;
    private String soyadi;
    private Ders ders;
}
