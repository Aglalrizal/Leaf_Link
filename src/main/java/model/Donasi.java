/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.util.UUID;

/**
 *
 * @author aglalrizal
 */
public class Donasi {
    private UUID idDonasi;
    private Kampanye kampanye;
    private Personal person;
    private long jml_sumbangan;

    public Donasi(UUID idDonasi, Kampanye kampanye, Personal person, long jml_sumbangan) {
        this.idDonasi = idDonasi;
        this.kampanye = kampanye;
        this.person = person;
        this.jml_sumbangan = jml_sumbangan;
    }

    public Donasi(Kampanye kampanye, Personal person, long jml_sumbangan) {
        UUID uuid = UUID.randomUUID();
        this.idDonasi = uuid;
        this.kampanye = kampanye;
        this.person = person;
        this.jml_sumbangan = jml_sumbangan;
    }

    public long getJml_sumbangan() {
        return jml_sumbangan;
    }

    public void setJml_sumbangan(long jml_sumbangan) {
        this.jml_sumbangan = jml_sumbangan;
    }

    public UUID getIdDonasi() {
        return idDonasi;
    }

    public void setIdDonasi(UUID idDonasi) {
        this.idDonasi = idDonasi;
    }

    public Kampanye getKampanye() {
        return kampanye;
    }

    public void setKampanye(Kampanye kampanye) {
        this.kampanye = kampanye;
    }

    public Personal getPerson() {
        return person;
    }

    public void setPerson(Personal person) {
        this.person = person;
    }
    
    @Override
    public String toString(){
        return  "Nama Kampanye: "+ getKampanye().getNama()+
                "\nJumlah Donasi: Rp."+ getJml_sumbangan()+"\n";
    }
}
