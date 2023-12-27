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
public class Volunteer {
    private UUID idVolunteer;
    private Personal relawan;
    private Kampanye kampanye;

    public Volunteer(UUID idVolunteer, Personal relawan, Kampanye kampanye) {
        this.idVolunteer = idVolunteer;
        this.relawan = relawan;
        this.kampanye = kampanye;
    }

    public Volunteer(Personal relawan, Kampanye kampanye) {
        UUID uuid = UUID.randomUUID();
        setIdVolunteer(uuid);
        this.relawan = relawan;
        this.kampanye = kampanye;
    }

    public UUID getIdVolunteer() {
        return idVolunteer;
    }

    private void setIdVolunteer(UUID idVolunteer) {
        this.idVolunteer = idVolunteer;
    }

    public Personal getRelawan() {
        return relawan;
    }

    public void setRelawan(Personal relawan) {
        this.relawan = relawan;
    }

    public Kampanye getKampanye() {
        return kampanye;
    }

    public void setKampanye(Kampanye kampanye) {
        this.kampanye = kampanye;
    }
}
