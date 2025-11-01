package darkcore.content;

import mindustry.type.*;
import mindustry.graphics.*;
import arc.graphics.*;

public class DarkItems {
    public static Item
        darkBeryllium, darkGraphite, darkTungsten, darkSilicon,
        darkOxide, darkCarbide, darkSurgeAlloy, darkPhaseFabric,
        darkThorium;
    
    public static void load() {
        // Dark variants of Erekir materials
        darkBeryllium = new Item("dark-beryllium", Color.valueOf("2e3d47")) {{
            cost = 1.2f;
            hardness = 2;
        }};
        
        darkGraphite = new Item("dark-graphite", Color.valueOf("1a1a1a")) {{
            cost = 1.1f;
        }};
        
        darkTungsten = new Item("dark-tungsten", Color.valueOf("3d3948")) {{
            cost = 1.3f;
            hardness = 3;
        }};
        
        darkSilicon = new Item("dark-silicon", Color.valueOf("2b2535")) {{
            cost = 1.1f;
        }};
        
        darkOxide = new Item("dark-oxide", Color.valueOf("3a2e42")) {{
            cost = 1.5f;
        }};
        
        darkCarbide = new Item("dark-carbide", Color.valueOf("4a3d5e")) {{
            cost = 1.6f;
        }};
        
        darkSurgeAlloy = new Item("dark-surge-alloy", Color.valueOf("5e4a7a")) {{
            cost = 2.0f;
            charge = 0.8f;
        }};
        
        darkPhaseFabric = new Item("dark-phase-fabric", Color.valueOf("6e5a8a")) {{
            cost = 2.0f;
            radioactivity = 0.1f;
        }};
        
        darkThorium = new Item("dark-thorium", Color.valueOf("5a3e6a")) {{
            cost = 1.8f;
            radioactivity = 0.5f;
            hardness = 4;
        }};
    }
}
