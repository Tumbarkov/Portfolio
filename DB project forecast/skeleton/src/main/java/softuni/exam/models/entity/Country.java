package softuni.exam.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "countries")
public class Country extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Size(min = 2, max = 60)
    private String countryName;

    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String currency;
}
