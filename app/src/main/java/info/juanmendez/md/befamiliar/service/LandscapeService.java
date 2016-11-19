package info.juanmendez.md.befamiliar.service;

import java.util.ArrayList;

import info.juanmendez.md.befamiliar.R;
import info.juanmendez.md.befamiliar.model.Landscape;

/**
 * Created by Juan Mendez on 11/18/2016.
 * www.juanmendez.info
 * contact@juanmendez.info
 */

public class LandscapeService {

    public static ArrayList<Landscape> getData() {

        ArrayList<Landscape> dataList = new ArrayList<>();

        int[] images = {
                R.drawable.aerosmith, R.drawable.black_sabbath,
                R.drawable.deep_purple,
                R.drawable.guns_n_roses, R.drawable.motley_crue,
                R.drawable.pink_floyd, R.drawable.motorhead,
                R.drawable.queen, R.drawable.tesla, R.drawable.zz_top
        };

        String[] band_names = {
                "Aerosmith", "Black Sabbath", "Deep Purple",
                "Guns n' Roses", "Motley Crue", "Pink Floyd", "Motorhead",
                "Queen", "Tesla", "ZZ Top"
        };

        for (int i = 0; i < images.length; i++) {

            Landscape landscape = new Landscape();
            landscape.setImageID(images[i]);
            landscape.setTitle(band_names[i]);

            dataList.add(landscape);
        }

        return dataList;
    }
}
