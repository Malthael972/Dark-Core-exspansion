package darkcore.content;

import mindustry.type.*;
import mindustry.content.*;
import arc.graphics.*;

public class DarkLiquids {
    public static Liquid
        darkHydrogen, darkNitrogen, darkOzone,
        darkCyanogen, darkNeoplasm, darkArkycite, darkSlag;
    
    public static void load() {
        // Dark variants of Erekir liquids
        darkHydrogen = new Liquid("dark-hydrogen", Color.valueOf("2e3a4a")) {{
            gas = true;
            flammability = 0.6f;
            explosiveness = 0.3f;
        }};
        
        darkNitrogen = new Liquid("dark-nitrogen", Color.valueOf("1e2a3a")) {{
            gas = true;
        }};
        
        darkOzone = new Liquid("dark-ozone", Color.valueOf("3e3a5a")) {{
            gas = true;
            effect = StatusEffects.freezing;
        }};
        
        darkCyanogen = new Liquid("dark-cyanogen", Color.valueOf("4a5e6a")) {{
            gas = true;
            flammability = 0.4f;
        }};
        
        darkNeoplasm = new Liquid("dark-neoplasm", Color.valueOf("5a4a6a")) {{
            viscosity = 0.8f;
            effect = StatusEffects.corroded;
            heatCapacity = 0.6f;
        }};
        
        darkArkycite = new Liquid("dark-arkycite", Color.valueOf("3a2e4a")) {{
            viscosity = 0.7f;
            effect = StatusEffects.slow;
        }};
        
        darkSlag = new Liquid("dark-slag", Color.valueOf("4a3a2a")) {{
            viscosity = 0.9f;
            temperature = 1.5f;
            effect = StatusEffects.melting;
            lightColor = Color.valueOf("6a4a3a");
        }};
    }
}
