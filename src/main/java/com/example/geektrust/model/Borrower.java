package com.example.geektrust.model;

import java.util.Objects;

public class Borrower {
    private String name;
    private String bankName;

    public Borrower(String name, String bankName) {
        this.name = name;
        this.bankName = bankName;
    }

    public String getName() {
        return name;
    }

    public String getBankName() {
        return bankName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrower borrower = (Borrower) o;
        return name.equals(borrower.name) &&
                bankName.equals(borrower.bankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bankName);
    }
}
