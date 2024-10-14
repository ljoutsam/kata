package fr.olympp.kata.services;

public class ClanNotFoundException extends RuntimeException {
    public ClanNotFoundException(String s) {
        super(s);
    }
}
