package GameMechanic.Objects.Grounds;

import static ServerMechanic.ServerMainGUIVariables.*;

public class GroundWater extends Ground {
    public GroundWater(int x, int y) {
        super(x, y);
        icon = ICON_GROUND_WATER;
        name = "WaterGround";
    }

    @Override
    public void recovery() {
        icon = ICON_GROUND_WATER;
    }
}
