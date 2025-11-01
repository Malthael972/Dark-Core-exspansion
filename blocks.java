package darkcore.content;

import mindustry.content.*;
import mindustry.world.*;
import mindustry.world.blocks.core.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.units.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mindustry.type.*;
import mindustry.entities.effect.*;
import mindustry.entities.pattern.*;
import mindustry.entities.bullet.*;
import mindustry.graphics.*;
import mindustry.gen.*;
import mindustry.game.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import arc.util.*;

import static mindustry.type.ItemStack.*;
import static mindustry.Vars.*;

public class DarkBlocks {
    // Cores
    public static Block
        darkCoreBastion, darkCoreCitadel, darkCoreAcropolis;
    
    // Power
    public static Block
        darkTurbineCondenser, darkBeamNode, darkBeamTower, darkBeamLink,
        darkChemicalCombustionChamber, darkPyrolysisGenerator,
        darkFluxReactor, darkNeoplasiaReactor;
    
    // Unit Fabricators
    public static Block
        darkTankFabricator, darkShipFabricator, darkMechFabricator;
    
    // Unit Refabricators
    public static Block
        darkTankRefabricator, darkShipRefabricator, darkMechRefabricator,
        darkPrimeRefabricator;
    
    // Unit Assemblers
    public static Block
        darkTankAssembler, darkShipAssembler, darkMechAssembler,
        darkBasicAssemblerModule;
    
    // Production
    public static Block
        darkSiliconArcFurnace, darkElectrolyzer, darkOxidationChamber,
        darkCarbideCrucible, darkSurgeCrucible, darkPhaseSynthesizer,
        darkAtmosphericConcentrator, darkCyanogenSynthesizer;
    
    // Walls
    public static Block
        darkBerylliumWall, darkBerylliumWallLarge,
        darkTungstenWall, darkTungstenWallLarge,
        darkCarbideWall, darkCarbideWallLarge;
    
    public static void load() {
        // Dark Core Blocks
        darkCoreBastion = new CoreBlock("dark-core-bastion") {{
            requirements(Category.effect, with(
                Items.graphite, 1200,
                Items.silicon, 1200,
                Items.beryllium, 1000
            ));
            
            isFirstTier = true;
            unitType = DarkUnits.darkEvoke;
            health = 5400;
            itemCapacity = 2500;
            size = 4;
            thrusterLength = 34f/4f;
            armor = 6f;
            incinerateNonBuildable = true;
            requiresCoreZone = true;
            unitCapModifier = 18;
            researchCostMultiplier = 0.07f;
            
            drawTeamOverlay = false;
        }};
        
        darkCoreCitadel = new CoreBlock("dark-core-citadel") {{
            requirements(Category.effect, with(
                Items.silicon, 4800,
                Items.beryllium, 4800,
                Items.tungsten, 3600,
                Items.oxide, 1200
            ));
            
            unitType = DarkUnits.darkIncite;
            health = 19200;
            itemCapacity = 3600;
            size = 5;
            thrusterLength = 40f/4f;
            armor = 12f;
            incinerateNonBuildable = true;
            requiresCoreZone = true;
            unitCapModifier = 18;
            researchCostMultiplier = 0.17f;
            
            drawTeamOverlay = false;
        }};
        
        darkCoreAcropolis = new CoreBlock("dark-core-acropolis") {{
            requirements(Category.effect, with(
                Items.beryllium, 7200,
                Items.silicon, 6000,
                Items.tungsten, 6000,
                Items.carbide, 3600,
                Items.oxide, 3600
            ));
            
            unitType = DarkUnits.darkEmanate;
            health = 36000;
            itemCapacity = 4800;
            size = 6;
            thrusterLength = 48f/4f;
            armor = 18f;
            incinerateNonBuildable = true;
            requiresCoreZone = true;
            unitCapModifier = 18;
            researchCostMultiplier = 0.1f;
            
            drawTeamOverlay = false;
        }};
        
        // Dark Power Blocks
        darkTurbineCondenser = new ThermalGenerator("dark-turbine-condenser") {{
            requirements(Category.power, with(Items.beryllium, 72));
            attribute = Attribute.steam;
            group = BlockGroup.liquids;
            displayEfficiencyScale = 1f / 9f;
            minEfficiency = 9f - 0.0001f;
            powerProduction = 4f / 9f;
            displayEfficiency = false;
            generateEffect = Fx.turbinegenerate;
            effectChance = 0.04f;
            size = 3;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.08f;
            
            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawBlurSpin("-rotator", 0.6f * 9f) {{
                    blurThresh = 0.01f;
                }}
            );
            
            hasLiquids = true;
            outputLiquid = new LiquidStack(Liquids.water, 6f / 60f / 9f);
            liquidCapacity = 24f;
            fogRadius = 3;
            researchCost = with(Items.beryllium, 20);
        }};
        
        darkBeamNode = new BeamNode("dark-beam-node") {{
            requirements(Category.power, with(Items.beryllium, 10));
            consumesPower = outputsPower = true;
            health = 108;
            range = 12;
            fogRadius = 1;
            researchCost = with(Items.beryllium, 8);
            
            consumePowerBuffered(1200f);
        }};
        
        darkBeamTower = new BeamNode("dark-beam-tower") {{
            requirements(Category.power, with(
                Items.beryllium, 36,
                Items.oxide, 12,
                Items.silicon, 12
            ));
            size = 3;
            consumesPower = outputsPower = true;
            range = 26;
            scaledHealth = 108;
            fogRadius = 2;
            
            consumePowerBuffered(48000f);
        }};
        
        darkBeamLink = new LongPowerNode("dark-beam-link") {{
            requirements(Category.power, with(
                Items.beryllium, 300,
                Items.silicon, 300,
                Items.oxide, 180,
                Items.carbide, 90,
                Items.surgeAlloy, 90,
                Items.phaseFabric, 90
            ));
            size = 3;
            maxNodes = 1;
            laserRange = 600f;
            laserColor2 = Color.valueOf("8a4a8a");
            laserScale = 0.8f;
            scaledHealth = 156;
        }};
        
        darkChemicalCombustionChamber = new ConsumeGenerator("dark-chemical-combustion-chamber") {{
            requirements(Category.power, with(
                Items.graphite, 48,
                Items.tungsten, 24,
                Items.oxide, 48,
                Items.silicon, 36
            ));
            powerProduction = 660f / 60f;
            consumeLiquids(LiquidStack.with(
                Liquids.ozone, 2.4f / 60f,
                Liquids.arkycite, 48f / 60f
            ));
            size = 3;
            
            drawer = new DrawMulti(
                new DrawRegion("-bottom"),
                new DrawPistons() {{
                    sinMag = 3f;
                    sinScl = 5f;
                }},
                new DrawRegion("-mid"),
                new DrawLiquidTile(Liquids.arkycite, 37f / 4f),
                new DrawDefault(),
                new DrawGlowRegion() {{
                    alpha = 1f;
                    glowScale = 5f;
                    color = Color.valueOf("9a5a9a");
                }}
            );
            
            generateEffect = Fx.none;
            liquidCapacity = 120f;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.08f;
        }};
        
        darkPyrolysisGenerator = new ConsumeGenerator("dark-pyrolysis-generator") {{
            requirements(Category.power, with(
                Items.graphite, 120,
                Items.carbide, 72,
                Items.oxide, 72,
                Items.silicon, 120
            ));
            powerProduction = 1680f / 60f;
            
            drawer = new DrawMulti(
                new DrawRegion("-bottom"),
                new DrawPistons() {{
                    sinMag = 2.75f;
                    sinScl = 5f;
                    sides = 8;
                    sideOffset = Mathf.PI / 2f;
                }},
                new DrawRegion("-mid"),
                new DrawLiquidTile(Liquids.arkycite, 38f / 4f),
                new DrawDefault(),
                new DrawGlowRegion() {{
                    alpha = 1f;
                    glowScale = 5f;
                    color = Color.valueOf("aa6aaa");
                }}
            );
            
            consumeLiquids(LiquidStack.with(
                Liquids.slag, 24f / 60f,
                Liquids.arkycite, 48f / 60f
            ));
            size = 3;
            liquidCapacity = 180f;
            outputLiquid = new LiquidStack(Liquids.water, 24f / 60f);
            generateEffect = Fx.none;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.08f;
        }};
        
        // Dark Unit Production
        darkTankFabricator = new UnitFactory("dark-tank-fabricator") {{
            requirements(Category.units, with(
                Items.silicon, 240,
                Items.beryllium, 180
            ));
            size = 3;
            configurable = false;
            plans.add(new UnitFactory.UnitPlan(DarkUnits.darkStell, 60f * 35f, with(
                Items.beryllium, 48,
                Items.silicon, 60
            )));
            regionSuffix = "-dark";
            fogRadius = 3;
            consumePower(1.8f);
        }};
        
        darkShipFabricator = new UnitFactory("dark-ship-fabricator") {{
            requirements(Category.units, with(
                Items.silicon, 300,
                Items.beryllium, 240
            ));
            size = 3;
            configurable = false;
            plans.add(new UnitFactory.UnitPlan(DarkUnits.darkElude, 60f * 40f, with(
                Items.graphite, 60,
                Items.silicon, 84
            )));
            regionSuffix = "-dark";
            fogRadius = 3;
            consumePower(1.8f);
        }};
        
        darkMechFabricator = new UnitFactory("dark-mech-fabricator") {{
            requirements(Category.units, with(
                Items.silicon, 240,
                Items.beryllium, 300,
                Items.tungsten, 12
            ));
            size = 3;
            configurable = false;
            plans.add(new UnitFactory.UnitPlan(DarkUnits.darkMerui, 60f * 40f, with(
                Items.beryllium, 60,
                Items.silicon, 84
            )));
            regionSuffix = "-dark";
            fogRadius = 3;
            consumePower(1.8f);
        }};
        
        darkTankRefabricator = new Reconstructor("dark-tank-refabricator") {{
            requirements(Category.units, with(
                Items.beryllium, 240,
                Items.tungsten, 96,
                Items.silicon, 120
            ));
            regionSuffix = "-dark";
            size = 3;
            consumePower(3.6f);
            consumeLiquid(Liquids.hydrogen, 3.6f / 60f);
            consumeItems(with(Items.silicon, 48, Items.tungsten, 36));
            constructTime = 60f * 30f;
            
            upgrades.addAll(
                new UnitType[]{DarkUnits.darkStell, DarkUnits.darkLocus}
            );
        }};
        
        darkShipRefabricator = new Reconstructor("dark-ship-refabricator") {{
            requirements(Category.units, with(
                Items.beryllium, 300,
                Items.tungsten, 144,
                Items.silicon, 180,
                Items.oxide, 18
            ));
            regionSuffix = "-dark";
            size = 3;
            consumePower(3f);
            consumeLiquid(Liquids.hydrogen, 3.6f / 60f);
            consumeItems(with(Items.silicon, 72, Items.tungsten, 48));
            constructTime = 60f * 50f;
            
            upgrades.addAll(
                new UnitType[]{DarkUnits.darkElude, DarkUnits.darkAvert}
            );
        }};
        
        darkMechRefabricator = new Reconstructor("dark-mech-refabricator") {{
            requirements(Category.units, with(
                Items.beryllium, 300,
                Items.tungsten, 210,
                Items.silicon, 180
            ));
            regionSuffix = "-dark";
            size = 3;
            consumePower(3f);
            consumeLiquid(Liquids.hydrogen, 3.6f / 60f);
            consumeItems(with(Items.silicon, 60, Items.tungsten, 48));
            constructTime = 60f * 45f;
            
            upgrades.addAll(
                new UnitType[]{DarkUnits.darkMerui, DarkUnits.darkCleroi}
            );
        }};
        
        darkPrimeRefabricator = new Reconstructor("dark-prime-refabricator") {{
            requirements(Category.units, with(
                Items.thorium, 300,
                Items.oxide, 240,
                Items.tungsten, 240,
                Items.silicon, 480
            ));
            regionSuffix = "-dark";
            size = 5;
            consumePower(5.4f);
            consumeLiquid(Liquids.nitrogen, 12f / 60f);
            consumeItems(with(Items.thorium, 96, Items.silicon, 120));
            constructTime = 60f * 60f;
            
            upgrades.addAll(
                new UnitType[]{DarkUnits.darkLocus, DarkUnits.darkPrecept},
                new UnitType[]{DarkUnits.darkCleroi, DarkUnits.darkAnthicus},
                new UnitType[]{DarkUnits.darkAvert, DarkUnits.darkObviate}
            );
        }};
        
        darkTankAssembler = new UnitAssembler("dark-tank-assembler") {{
            requirements(Category.units, with(
                Items.thorium, 600,
                Items.oxide, 180,
                Items.carbide, 96,
                Items.silicon, 780
            ));
            regionSuffix = "-dark";
            size = 5;
            plans.add(
                new UnitAssembler.AssemblerUnitPlan(DarkUnits.darkVanquish, 60f * 50f, PayloadStack.list(DarkUnits.darkStell, 4, Blocks.tungstenWallLarge, 12)),
                new UnitAssembler.AssemblerUnitPlan(DarkUnits.darkConquer, 60f * 60f * 3f, PayloadStack.list(DarkUnits.darkLocus, 6, Blocks.carbideWallLarge, 24))
            );
            areaSize = 15;
            consumePower(3f);
            consumeLiquid(Liquids.cyanogen, 10.8f / 60f);
        }};
        
        darkShipAssembler = new UnitAssembler("dark-ship-assembler") {{
            requirements(Category.units, with(
                Items.carbide, 120,
                Items.oxide, 240,
                Items.tungsten, 660,
                Items.silicon, 1080,
                Items.thorium, 480
            ));
            regionSuffix = "-dark";
            size = 5;
            plans.add(
                new UnitAssembler.AssemblerUnitPlan(DarkUnits.darkQuell, 60f * 60f, PayloadStack.list(DarkUnits.darkElude, 4, Blocks.berylliumWallLarge, 14)),
                new UnitAssembler.AssemblerUnitPlan(DarkUnits.darkDisrupt, 60f * 60f * 3f, PayloadStack.list(DarkUnits.darkAvert, 6, Blocks.carbideWallLarge, 24))
            );
            areaSize = 15;
            consumePower(3f);
            consumeLiquid(Liquids.cyanogen, 14.4f / 60f);
        }};
        
        darkMechAssembler = new UnitAssembler("dark-mech-assembler") {{
            requirements(Category.units, with(
                Items.carbide, 240,
                Items.thorium, 720,
                Items.oxide, 240,
                Items.tungsten, 660,
                Items.silicon, 1200
            ));
            regionSuffix = "-dark";
            size = 5;
            plans.add(
                new UnitAssembler.AssemblerUnitPlan(DarkUnits.darkTecta, 60f * 70f, PayloadStack.list(DarkUnits.darkMerui, 5, Blocks.tungstenWallLarge, 14)),
                new UnitAssembler.AssemblerUnitPlan(DarkUnits.darkCollaris, 60f * 60f * 3f, PayloadStack.list(DarkUnits.darkCleroi, 6, Blocks.carbideWallLarge, 24))
            );
            areaSize = 15;
            consumePower(3.6f);
            consumeLiquid(Liquids.cyanogen, 14.4f / 60f);
        }};
        
        darkBasicAssemblerModule = new UnitAssemblerModule("dark-basic-assembler-module") {{
            requirements(Category.units, with(
                Items.carbide, 360,
                Items.thorium, 600,
                Items.oxide, 300,
                Items.phaseFabric, 480
            ));
            consumePower(4.2f);
            regionSuffix = "-dark";
            size = 5;
        }};
        
        // Dark Production Blocks
        darkSiliconArcFurnace = new GenericCrafter("dark-silicon-arc-furnace") {{
            requirements(Category.crafting, with(
                Items.beryllium, 84,
                Items.graphite, 96
            ));
            craftEffect = Fx.none;
            outputItem = new ItemStack(Items.silicon, 5);
            craftTime = 50f;
            size = 3;
            hasPower = true;
            hasLiquids = false;
            itemCapacity = 36;
            
            drawer = new DrawMulti(
                new DrawRegion("-bottom"),
                new DrawArcSmelt(),
                new DrawDefault()
            );
            
            fogRadius = 3;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.14f;
            
            consumeItems(with(Items.graphite, 1, Items.sand, 5));
            consumePower(6f);
        }};
        
        darkElectrolyzer = new GenericCrafter("dark-electrolyzer") {{
            requirements(Category.crafting, with(
                Items.silicon, 60,
                Items.graphite, 48,
                Items.beryllium, 156,
                Items.tungsten, 96
            ));
            size = 3;
            craftTime = 10f;
            rotate = true;
            invertFlip = true;
            group = BlockGroup.liquids;
            itemCapacity = 0;
            liquidCapacity = 60f;
            
            consumeLiquid(Liquids.water, 12f / 60f);
            consumePower(1.2f);
            
            drawer = new DrawMulti(
                new DrawRegion("-bottom"),
                new DrawLiquidTile(Liquids.water, 2f),
                new DrawBubbles(Color.valueOf("7693e3")) {{
                    sides = 10;
                    recurrence = 3f;
                    spread = 6;
                    radius = 1.5f;
                    amount = 20;
                }},
                new DrawRegion(),
                new DrawLiquidOutputs(),
                new DrawGlowRegion() {{
                    alpha = 0.7f;
                    color = Color.valueOf("8a4a8a");
                    glowIntensity = 0.3f;
                    glowScale = 6f;
                }}
            );
            
            ambientSound = Sounds.electricHum;
            ambientSoundVolume = 0.1f;
            regionRotated1 = 3;
            outputLiquids = LiquidStack.with(Liquids.ozone, 4.8f / 60f, Liquids.hydrogen, 7.2f / 60f);
            liquidOutputDirections = new int[]{1, 3};
        }};
        
        darkOxidationChamber = new HeatProducer("dark-oxidation-chamber") {{
            requirements(Category.crafting, with(
                Items.tungsten, 144,
                Items.graphite, 96,
                Items.silicon, 120,
                Items.beryllium, 144
            ));
            size = 3;
            outputItem = new ItemStack(Items.oxide, 1);
            consumeLiquid(Liquids.ozone, 2.4f / 60f);
            consumeItem(Items.beryllium);
            consumePower(0.6f);
            rotateDraw = false;
            
            drawer = new DrawMulti(
                new DrawRegion("-bottom"),
                new DrawLiquidRegion(),
                new DrawDefault(),
                new DrawHeatOutput()
            );
            
            ambientSound = Sounds.extractLoop;
            ambientSoundVolume = 0.1f;
            regionRotated1 = 2;
            craftTime = 60f * 2f;
            liquidCapacity = 36f;
            heatOutput = 6f;
        }};
        
        darkCarbideCrucible = new HeatCrafter("dark-carbide-crucible") {{
            requirements(Category.crafting, with(
                Items.tungsten, 132,
                Items.thorium, 180,
                Items.oxide, 72
            ));
            craftEffect = Fx.none;
            outputItem = new ItemStack(Items.carbide, 1);
            craftTime = 60f * 2.25f;
            size = 3;
            itemCapacity = 24;
            hasPower = hasItems = true;
            
            drawer = new DrawMulti(
                new DrawRegion("-bottom"),
                new DrawCrucibleFlame(),
                new DrawDefault(),
                new DrawHeatInput()
            );
            
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.11f;
            heatRequirement = 12f;
            
            consumeItems(with(Items.tungsten, 2, Items.graphite, 4));
            consumePower(2.4f);
        }};
        
        darkSurgeCrucible = new HeatCrafter("dark-surge-crucible") {{
            requirements(Category.crafting, with(
                Items.silicon, 120,
                Items.graphite, 96,
                Items.tungsten, 96,
                Items.oxide, 96
            ));
            size = 3;
            itemCapacity = 24;
            heatRequirement = 12f;
            craftTime = 60f * 3f;
            liquidCapacity = 96f * 5;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 1.1f;
            outputItem = new ItemStack(Items.surgeAlloy, 1);
            
            craftEffect = new RadialEffect(Fx.surgeCruciSmoke, 4, 90f, 5f);
            
            drawer = new DrawMulti(
                new DrawRegion("-bottom"),
                new DrawCircles() {{
                    color = Color.valueOf("aa6aaa").a(0.24f);
                    strokeMax = 2.5f;
                    radius = 10f;
                    amount = 3;
                }},
                new DrawLiquidRegion(Liquids.slag),
                new DrawDefault(),
                new DrawHeatInput(),
                new DrawHeatRegion() {{
                    color = Color.valueOf("ca8aca");
                }},
                new DrawHeatRegion("-vents") {{
                    color.a = 1f;
                }}
            );
            
            consumeItem(Items.silicon, 4);
            consumeLiquid(Liquids.slag, 48f / 60f);
            consumePower(1.8f);
        }};
        
        darkPhaseSynthesizer = new HeatCrafter("dark-phase-synthesizer") {{
            requirements(Category.crafting, with(
                Items.carbide, 108,
                Items.silicon, 120,
                Items.thorium, 120,
                Items.tungsten, 240
            ));
            size = 3;
            itemCapacity = 48;
            heatRequirement = 10f;
            craftTime = 60f * 2f;
            liquidCapacity = 12f * 4;
            ambientSound = Sounds.techloop;
            ambientSoundVolume = 0.05f;
            outputItem = new ItemStack(Items.phaseFabric, 1);
            
            drawer = new DrawMulti(
                new DrawRegion("-bottom"),
                new DrawSpikes() {{
                    color = Color.valueOf("aa6aaa");
                    stroke = 1.5f;
                    layers = 2;
                    amount = 12;
                    rotateSpeed = 0.5f;
                    layerSpeed = -0.9f;
                }},
                new DrawMultiWeave() {{
                    glowColor = new Color(0.8f, 0.3f, 0.8f, 0.8f);
                }},
                new DrawDefault(),
                new DrawHeatInput(),
                new DrawHeatRegion("-vents") {{
                    color = new Color(0.8f, 0.3f, 0.7f, 1f);
                }}
            );
            
            consumeItems(with(Items.thorium, 2, Items.sand, 7));
            consumeLiquid(Liquids.ozone, 2.4f / 60f);
            consumePower(9.6f);
        }};
        
        darkAtmosphericConcentrator = new HeatCrafter("dark-atmospheric-concentrator") {{
            requirements(Category.crafting, with(
                Items.oxide, 72,
                Items.beryllium, 216,
                Items.silicon, 180
            ));
            size = 3;
            hasLiquids = true;
            
            drawer = new DrawMulti(
                new DrawRegion("-bottom"),
                new DrawLiquidTile(Liquids.nitrogen, 4.1f),
                new DrawDefault(),
                new DrawHeatInput(),
                new DrawParticles() {{
                    color = Color.valueOf("8a9aca");
                    alpha = 0.6f;
                    particleSize = 4f;
                    particles = 10;
                    particleRad = 12f;
                    particleLife = 140f;
                }}
            );
            
            itemCapacity = 0;
            liquidCapacity = 72f;
            consumePower(2.4f);
            ambientSound = Sounds.extractLoop;
            ambientSoundVolume = 0.07f;
            heatRequirement = 7f;
            outputLiquid = new LiquidStack(Liquids.nitrogen, 4.8f / 60f);
        }};
        
        darkCyanogenSynthesizer = new HeatCrafter("dark-cyanogen-synthesizer") {{
            requirements(Category.crafting, with(
                Items.carbide, 60,
                Items.silicon, 96,
                Items.beryllium, 108
            ));
            heatRequirement = 6f;
            
            drawer = new DrawMulti(
                new DrawRegion("-bottom"),
                new DrawLiquidTile(Liquids.cyanogen),
                new DrawParticles() {{
                    color = Color.valueOf("6a8a7a");
                    alpha = 0.5f;
                    particleSize = 3f;
                    particles = 10;
                    particleRad = 9f;
                    particleLife = 200f;
                    reverse = true;
                    particleSizeInterp = Interp.one;
                }},
                new DrawDefault(),
                new DrawHeatInput(),
                new DrawHeatRegion("-heat-top")
            );
            
            size = 3;
            ambientSound = Sounds.extractLoop;
            ambientSoundVolume = 0.1f;
            liquidCapacity = 96f;
            outputLiquid = new LiquidStack(Liquids.cyanogen, 3.6f / 60f);
            
            consumeLiquid(Liquids.arkycite, 48f / 60f);
            consumeItem(Items.graphite);
            consumePower(2.4f);
        }};
        
        // Dark Walls
        darkBerylliumWall = new Wall("dark-beryllium-wall") {{
            requirements(Category.defense, with(Items.beryllium, 7));
            health = 156 * 4;
            armor = 3f;
            buildCostMultiplier = 9.6f;
        }};
        
        darkBerylliumWallLarge = new Wall("dark-beryllium-wall-large") {{
            requirements(Category.defense, ItemStack.mult(darkBerylliumWall.requirements, 4));
            health = 156 * 4 * 4;
            armor = 3f;
            buildCostMultiplier = 6f;
            size = 2;
        }};
        
        darkTungstenWall = new Wall("dark-tungsten-wall") {{
            requirements(Category.defense, with(Items.tungsten, 7));
            health = 216 * 4;
            armor = 17f;
            buildCostMultiplier = 9.6f;
        }};
        
        darkTungstenWallLarge = new Wall("dark-tungsten-wall-large") {{
            requirements(Category.defense, ItemStack.mult(darkTungstenWall.requirements, 4));
            health = 216 * 4 * 4;
            armor = 17f;
            buildCostMultiplier = 6f;
            size = 2;
        }};
        
        darkCarbideWall = new Wall("dark-carbide-wall") {{
            requirements(Category.defense, with(Items.thorium, 7, Items.carbide, 7));
            health = 324 * 4;
            armor = 19f;
        }};
        
        darkCarbideWallLarge = new Wall("dark-carbide-wall-large") {{
            requirements(Category.defense, ItemStack.mult(darkCarbideWall.requirements, 4));
            health = 324 * 4 * 4;
            armor = 19f;
            size = 2;
        }};
    }
}
