package com.example.demo.programObject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class LoanEntity {

    @NotNull(message = "id cannot be null")
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    private LocalDate loanDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    @Override
    public String toString() {
        return "LoanEntity{" +
                "id=" + id +
                ", loanDate=" + loanDate +
                ", book=" + (book != null ? book.getId() + " (" + book.getName() + ")" : "null") +
                ", client=" + (client != null ? client.getId() + " (" + client.getName() + ")" : "null") +
                '}';
    }
}
