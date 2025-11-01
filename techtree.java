package darkcore.content;

import mindustry.content.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;
import arc.struct.*;

import static mindustry.content.TechTree.*;
import static darkcore.content.DarkBlocks.*;
import static darkcore.content.DarkUnits.*;

public class DarkTechTree {
    
    public static void load() {
        // Dark Core Tech Tree
        Planets.erekir.techTree.children.add(
            node(darkCoreBastion, Seq.with(new Research(Blocks.coreBastion)), () -> {
                
                // Power Infrastructure
                node(darkTurbineCondenser, () -> {
                    node(darkBeamNode, () -> {
                        node(darkBeamTower, () -> {
                            node(darkBeamLink);
                        });
                    });
                    
                    node(darkChemicalCombustionChamber, () -> {
                        node(darkPyrolysisGenerator);
                    });
                });
                
                // Production
                node(darkSiliconArcFurnace, () -> {
                    node(darkElectrolyzer, () -> {
                        node(darkOxidationChamber, () -> {
                            node(darkSurgeCrucible);
                        });
                    });
                    
                    node(darkCarbideCrucible, () -> {
                        node(darkPhaseSynthesizer);
                    });
                    
                    node(darkAtmosphericConcentrator, () -> {
                        node(darkCyanogenSynthesizer);
                    });
                });
                
                // Unit Production - Fabricators
                node(darkTankFabricator, () -> {
                    node(darkStell);
                    
                    node(darkTankRefabricator, () -> {
                        node(darkLocus);
                        
                        node(darkPrimeRefabricator, () -> {
                            node(darkPrecept);
                        });
                        
                        node(darkTankAssembler, Seq.with(new Research(darkCarbideCrucible)), () -> {
                            node(darkVanquish);
                            node(darkConquer, Seq.with(new Research(darkPhaseSynthesizer)));
                            node(darkBasicAssemblerModule);
                        });
                    });
                });
                
                node(darkShipFabricator, () -> {
                    node(darkElude);
                    
                    node(darkShipRefabricator, () -> {
                        node(darkAvert);
                        
                        node(darkObviate, Seq.with(new Research(darkPrimeRefabricator)));
                        
                        node(darkShipAssembler, Seq.with(new Research(darkCarbideCrucible)), () -> {
                            node(darkQuell);
                            node(darkDisrupt, Seq.with(new Research(darkPhaseSynthesizer)));
                        });
                    });
                });
                
                node(darkMechFabricator, () -> {
                    node(darkMerui);
                    
                    node(darkMechRefabricator, () -> {
                        node(darkCleroi);
                        
                        node(darkAnthicus, Seq.with(new Research(darkPrimeRefabricator)));
                        
                        node(darkMechAssembler, Seq.with(new Research(darkCarbideCrucible)), () -> {
                            node(darkTecta);
                            node(darkCollaris, Seq.with(new Research(darkPhaseSynthesizer)));
                        });
                    });
                });
                
                // Walls
                node(darkBerylliumWall, () -> {
                    node(darkBerylliumWallLarge);
                    
                    node(darkTungstenWall, () -> {
                        node(darkTungstenWallLarge);
                        
                        node(darkCarbideWall, Seq.with(new Research(darkCarbideCrucible)), () -> {
                            node(darkCarbideWallLarge);
                        });
                    });
                });
                
                // Higher Tier Cores
                node(darkCoreCitadel, Seq.with(new Research(darkOxidationChamber)), () -> {
                    node(darkIncite);
                    
                    node(darkCoreAcropolis, Seq.with(new Research(darkPhaseSynthesizer)), () -> {
                        node(darkEmanate);
                    });
                });
            })
        );
    }
}
