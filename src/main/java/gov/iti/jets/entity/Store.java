package gov.iti.jets.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "store", schema = "sakila", indexes = {
        @Index(name = "idx_unique_manager", columnList = "manager_staff_id", unique = true),
        @Index(name = "idx_fk_address_id", columnList = "address_id")
})
public class Store {
    @Id
    @Column(name = "store_id", columnDefinition = "TINYINT UNSIGNED not null")
    private Short id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_staff_id", nullable = false)
    private Staff managerStaff;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Staff getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(Staff managerStaff) {
        this.managerStaff = managerStaff;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}