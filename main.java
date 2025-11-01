package darkcore;

import arc.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import darkcore.content.*;

public class DarkCoreExpansion extends Mod {
    
    public DarkCoreExpansion() {
        Log.info("Loaded Dark Core Expansion constructor.");
        
        Events.on(ClientLoadEvent.class, e -> {
            Log.info("Dark Core Expansion loaded successfully!");
        });
    }
    
    @Override
    public void loadContent() {
        Log.info("Loading Dark Core Expansion content...");
        
        DarkItems.load();
        DarkLiquids.load();
        DarkUnits.load();
        DarkBlocks.load();
        DarkTechTree.load();
        
        Log.info("Dark Core Expansion content loaded!");
    }
}
