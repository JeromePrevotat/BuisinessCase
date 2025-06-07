package com.electricitybusiness.api.lieuutils;

import java.util.ArrayList;
import java.util.List;

import com.electricitybusiness.api.model.Borne;
import com.electricitybusiness.api.model.Lieu;

public class LieuUtils {
    private static List<Borne> getAllFreeBorneFromLieu(Lieu lieu) {
        List<Borne> freeBornes = new ArrayList<>();
        if (lieu == null || lieu.getBornes() == null) return freeBornes;
        for (Borne borne : lieu.getBornes()) if (!borne.getOccupee()) freeBornes.add(borne);
        return freeBornes;
    }
}
