package GameMechanic.WorldGeneration.Biomes;

import GameMechanic.Objects.Grounds.Ground;

import java.util.ArrayList;

public class BiomeForest extends Biome {
    public BiomeForest(ArrayList<Ground> listOfGrounds) {
        super(listOfGrounds);
        typicalGround = "GrassGround";
    }
}
