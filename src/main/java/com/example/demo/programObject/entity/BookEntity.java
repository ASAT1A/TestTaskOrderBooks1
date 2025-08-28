
package com.example.demo.programObject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BookEntity {

    @NotNull(message = "id cannot be null")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;
    @NotNull(message = "name cannot be null")
    @Size(min = 1, max = 100, message = "Name need be between 1 and 30")
    private String name;
    @NotNull(message = "author cannot be null")
    @Size(min = 1, max = 100, message = "Author need be between 1 and 30")
    private String author;
    @NotNull(message = "isbn cannot be null")
    @Size(min = 13, max = 13, message = "isbn need be 13")
    private String isbn;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LoanEntity> loans;

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", loans=" + (loans != null ? loans.size() + " loans" : "null") +
                '}';
    }
}





