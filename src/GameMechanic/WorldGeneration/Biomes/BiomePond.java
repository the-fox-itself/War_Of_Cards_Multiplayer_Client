package GameMechanic.WorldGeneration.Biomes;

import GameMechanic.Objects.Grounds.Ground;

import java.util.ArrayList;

public class BiomePond extends Biome {
    public BiomePond(ArrayList<Ground> listOfGrounds) {
        super(listOfGrounds);
        typicalGround = "WaterGround";
    }
}
