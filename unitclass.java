package darkcore.content;

import mindustry.content.*;
import mindustry.type.*;
import mindustry.gen.*;
import mindustry.entities.bullet.*;
import mindustry.entities.abilities.*;
import mindustry.entities.part.*;
import mindustry.graphics.*;
import mindustry.type.weapons.*;
import mindustry.ai.types.*;
import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;

public class DarkUnits {
    // Tank units
    public static UnitType darkStell, darkLocus, darkPrecept, darkVanquish, darkConquer;
    
    // Ship units  
    public static UnitType darkElude, darkAvert, darkObviate, darkQuell, darkDisrupt;
    
    // Mech units
    public static UnitType darkMerui, darkCleroi, darkAnthicus, darkTecta, darkCollaris;
    
    // Core units
    public static UnitType darkEvoke, darkIncite, darkEmanate;
    
    public static void load() {
        // Tank Units - Dark variants
        darkStell = new TankUnitType("dark-stell") {{
            hitSize = 12f;
            treadPullOffset = 3;
            speed = 0.75f;
            rotateSpeed = 3.5f;
            health = 1000;
            armor = 8f;
            itemCapacity = 0;
            outlineColor = Pal.darkOutline;
            
            weapons.add(new Weapon("dark-stell-weapon") {{
                reload = 45f;
                shootY = 4.5f;
                recoil = 1f;
                rotate = true;
                rotateSpeed = 2.2f;
                mirror = false;
                x = 0f;
                y = -0.75f;
                heatColor = Color.valueOf("8a4a8a");
                cooldownTime = 30f;
                
                bullet = new BasicBulletType(4.5f, 50) {{
                    width = 6f;
                    height = 8f;
                    lifetime = 40f;
                    hitColor = backColor = trailColor = Color.valueOf("8a4a8a");
                    frontColor = Color.white;
                    trailWidth = 2f;
                    trailLength = 6;
                }};
            }});
        }};
        
        darkLocus = new TankUnitType("dark-locus") {{
            hitSize = 18f;
            treadPullOffset = 5;
            speed = 0.7f;
            rotateSpeed = 2.6f;
            health = 2500;
            armor = 10f;
            itemCapacity = 0;
            outlineColor = Pal.darkOutline;
            
            weapons.add(new Weapon("dark-locus-weapon") {{
                shootSound = Sounds.bolt;
                reload = 16f;
                shootY = 10f;
                recoil = 1f;
                rotate = true;
                rotateSpeed = 1.4f;
                mirror = false;
                x = 0f;
                y = 0f;
                heatColor = Color.valueOf("9a5a9a");
                
                bullet = new RailBulletType() {{
                    length = 180f;
                    damage = 60f;
                    hitColor = Color.valueOf("9a5a9a");
                    pierceDamageFactor = 0.8f;
                }};
            }});
        }};
        
        darkPrecept = new TankUnitType("dark-precept") {{
            hitSize = 24f;
            treadPullOffset = 5;
            speed = 0.64f;
            rotateSpeed = 1.5f;
            health = 6000;
            armor = 13f;
            itemCapacity = 0;
            outlineColor = Pal.darkOutline;
            immunities.addAll(StatusEffects.burning, StatusEffects.melting);
            
            weapons.add(new Weapon("dark-precept-weapon") {{
                shootSound = Sounds.dullExplosion;
                reload = 75f;
                shootY = 16f;
                recoil = 3f;
                rotate = true;
                rotateSpeed = 1.625f;
                mirror = false;
                x = 0f;
                y = -1f;
                heatColor = Color.valueOf("aa6aaa");
                
                bullet = new BasicBulletType(7.5f, 150) {{
                    width = 8.5f;
                    height = 14f;
                    lifetime = 28f;
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 2;
                    hitColor = backColor = trailColor = Color.valueOf("aa6aaa");
                    frontColor = Color.white;
                    trailWidth = 3f;
                    trailLength = 9;
                    hitEffect = despawnEffect = Fx.blastExplosion;
                    splashDamageRadius = 25f;
                    splashDamage = 60f;
                }};
            }});
        }};
        
        // Ship Units - Dark variants
        darkElude = new ErekirUnitType("dark-elude") {{
            hovering = true;
            shadowElevation = 0.1f;
            drag = 0.07f;
            speed = 1.8f;
            rotateSpeed = 5f;
            accel = 0.09f;
            health = 750;
            armor = 2f;
            hitSize = 11f;
            engineOffset = 7f;
            engineSize = 2f;
            itemCapacity = 0;
            useEngineElevation = false;
            outlineColor = Pal.darkOutline;
            
            abilities.add(new MoveEffectAbility(0f, -7f, Color.valueOf("8a4a8a"), Fx.missileTrailShort, 4f) {{
                teamColor = true;
            }});
            
            weapons.add(new Weapon("dark-elude-weapon") {{
                shootSound = Sounds.blaster;
                y = -2f;
                x = 4f;
                top = true;
                mirror = true;
                reload = 35f;
                
                bullet = new BasicBulletType(5.5f, 20) {{
                    homingPower = 0.2f;
                    width = 7f;
                    height = 12f;
                    lifetime = 30f;
                    hitColor = backColor = trailColor = Color.valueOf("8a4a8a");
                    frontColor = Color.white;
                    trailWidth = 2f;
                    trailLength = 6;
                }};
            }});
        }};
        
        darkAvert = new ErekirUnitType("dark-avert") {{
            lowAltitude = false;
            flying = true;
            drag = 0.08f;
            speed = 2f;
            rotateSpeed = 8f;
            accel = 0.09f;
            health = 1400;
            armor = 4f;
            hitSize = 12f;
            engineSize = 3f;
            itemCapacity = 0;
            outlineColor = Pal.darkOutline;
            
            weapons.add(new Weapon("dark-avert-weapon") {{
                shootSound = Sounds.blaster;
                reload = 30f;
                x = 0f;
                y = 6.5f;
                shootY = 5f;
                recoil = 1f;
                top = false;
                
                bullet = new BasicBulletType(6f, 42) {{
                    width = 8f;
                    height = 13f;
                    lifetime = 20f;
                    hitColor = backColor = trailColor = Color.valueOf("9a5a9a");
                    frontColor = Color.white;
                    trailWidth = 2f;
                    trailLength = 6;
                }};
            }});
        }};
        
        darkObviate = new ErekirUnitType("dark-obviate") {{
            flying = true;
            drag = 0.08f;
            speed = 1.8f;
            rotateSpeed = 2.5f;
            accel = 0.09f;
            health = 2800;
            armor = 7f;
            hitSize = 25f;
            engineSize = 4.3f;
            engineOffset = 54f / 4f;
            itemCapacity = 0;
            lowAltitude = true;
            outlineColor = Pal.darkOutline;
            
            weapons.add(new Weapon() {{
                shootSound = Sounds.shockBlast;
                x = 0f;
                y = -2f;
                shootY = 0f;
                reload = 120f;
                mirror = false;
                shake = 3f;
                
                bullet = new BasicBulletType(3f, 90) {{
                    sprite = "large-orb";
                    width = height = 15f;
                    lifetime = 60f;
                    backColor = Color.valueOf("aa6aaa");
                    frontColor = Color.valueOf("cc8acc");
                    trailColor = Color.valueOf("aa6aaa");
                    trailLength = 12;
                    trailWidth = 2.2f;
                    lightning = 8;
                    lightningLength = 10;
                    lightningColor = Color.valueOf("aa6aaa");
                    lightningDamage = 20;
                }};
            }});
        }};
        
        // Mech Units - Dark variants
        darkMerui = new ErekirUnitType("dark-merui") {{
            speed = 0.72f;
            drag = 0.11f;
            hitSize = 9f;
            rotateSpeed = 3f;
            health = 850;
            armor = 5f;
            legStraightness = 0.3f;
            stepShake = 0f;
            legCount = 6;
            legLength = 8f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -2f;
            legBaseOffset = 3f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            hovering = true;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            outlineColor = Pal.darkOutline;
            
            weapons.add(new Weapon("dark-merui-weapon") {{
                shootSound = Sounds.missile;
                mirror = false;
                x = 0f;
                y = 1f;
                shootY = 4f;
                reload = 55f;
                
                bullet = new ArtilleryBulletType(3.5f, 50) {{
                    collidesTiles = true;
                    backColor = hitColor = Color.valueOf("8a4a8a");
                    frontColor = Color.white;
                    lifetime = 46f;
                    width = height = 10f;
                    splashDamageRadius = 25f;
                    splashDamage = 40f;
                    trailLength = 27;
                    trailWidth = 2.5f;
                    trailColor = backColor;
                }};
            }});
        }};
        
        darkCleroi = new ErekirUnitType("dark-cleroi") {{
            speed = 0.6f;
            drag = 0.1f;
            hitSize = 14f;
            rotateSpeed = 3f;
            health = 1400;
            armor = 6f;
            stepShake = 0f;
            legCount = 4;
            legLength = 14f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -3f;
            legBaseOffset = 5f;
            hovering = true;
            shadowElevation = 0.2f;
            groundLayer = Layer.legUnit - 1f;
            outlineColor = Pal.darkOutline;
            
            weapons.add(new Weapon("dark-cleroi-weapon") {{
                shootSound = Sounds.blaster;
                x = 14f / 4f;
                y = 33f / 4f;
                reload = 28f;
                alternate = false;
                
                bullet = new BasicBulletType(4f, 38) {{
                    backColor = trailColor = hitColor = Color.valueOf("9a5a9a");
                    frontColor = Color.white;
                    width = 8f;
                    height = 11f;
                    lifetime = 40f;
                    trailWidth = 2.5f;
                    trailLength = 5;
                    splashDamageRadius = 35f;
                    splashDamage = 50f;
                }};
            }});
        }};
        
        darkAnthicus = new ErekirUnitType("dark-anthicus") {{
            speed = 0.65f;
            drag = 0.1f;
            hitSize = 21f;
            rotateSpeed = 3f;
            health = 3500;
            armor = 8f;
            fogRadius = 40f;
            stepShake = 0f;
            legCount = 6;
            legLength = 18f;
            legGroupSize = 3;
            lockLegBase = true;
            legContinuousMove = true;
            hovering = true;
            shadowElevation = 0.2f;
            groundLayer = Layer.legUnit - 1f;
            outlineColor = Pal.darkOutline;
            
            weapons.add(new Weapon("dark-anthicus-weapon") {{
                shootSound = Sounds.missileLarge;
                x = 29f / 4f;
                y = -11f / 4f;
                shootY = 1.5f;
                reload = 110f;
                rotationLimit = 70f;
                rotateSpeed = 2f;
                rotate = true;
                
                bullet = new MissileBulletType(4f, 180) {{
                    width = 8f;
                    height = 8f;
                    lifetime = 90f;
                    homingPower = 0.1f;
                    splashDamageRadius = 35f;
                    splashDamage = 160f;
                    hitColor = backColor = trailColor = Color.valueOf("aa6aaa");
                    frontColor = Color.white;
                    trailWidth = 4.5f;
                    trailLength = 29;
                }};
            }});
        }};
        
        // Assembler units
        darkVanquish = new TankUnitType("dark-vanquish") {{
            hitSize = 28f;
            treadPullOffset = 4;
            speed = 0.63f;
            health = 13000;
            armor = 22f;
            itemCapacity = 0;
            crushDamage = 3f;
            immunities.addAll(StatusEffects.burning, StatusEffects.melting);
            outlineColor = Pal.darkOutline;
            
            weapons.add(new Weapon("dark-vanquish-weapon") {{
                shootSound = Sounds.mediumCannon;
                reload = 65f;
                shootY = 71f / 4f;
                shake = 5f;
                recoil = 4f;
                rotate = true;
                rotateSpeed = 1f;
                mirror = false;
                x = 0f;
                y = 0;
                shadow = 28f;
                heatColor = Color.valueOf("ba7aba");
                
                bullet = new BasicBulletType(8.5f, 220) {{
                    sprite = "missile-large";
                    width = 10f;
                    height = 14f;
                    lifetime = 18f;
                    pierce = true;
                    pierceBuilding = true;
                    pierceCap = 2;
                    hitColor = backColor = trailColor = Color.valueOf("ba7aba");
                    frontColor = Color.white;
                    trailWidth = 3.5f;
                    trailLength = 9;
                    hitEffect = despawnEffect = Fx.blastExplosion;
                    splashDamageRadius = 25f;
                    splashDamage = 60f;
                    
                    fragBullets = 5;
                    fragVelocityMin = 1f;
                    fragBullet = new BasicBulletType(8f, 40) {{
                        sprite = "missile-large";
                        width = 8f;
                        height = 12f;
                        lifetime = 15f;
                        hitColor = backColor = trailColor = Color.valueOf("ba7aba");
                        frontColor = Color.white;
                        trailWidth = 2.8f;
                        trailLength = 6;
                        splashDamageRadius = 15f;
                        splashDamage = 25f;
                    }};
                }};
            }});
        }};
        
        darkConquer = new TankUnitType("dark-conquer") {{
            hitSize = 46f;
            treadPullOffset = 1;
            speed = 0.48f;
            health = 26000;
            armor = 28f;
            crushDamage = 5f;
            rotateSpeed = 0.8f;
            immunities.addAll(StatusEffects.burning, StatusEffects.melting);
            outlineColor = Pal.darkOutline;
            
            weapons.add(new Weapon("dark-conquer-weapon") {{
                shootSound = Sounds.largeCannon;
                reload = 95f;
                shootY = 32.5f;
                shake = 5f;
                recoil = 5f;
                rotate = true;
                rotateSpeed = 0.6f;
                mirror = false;
                x = 0f;
                y = -2f;
                shadow = 50f;
                heatColor = Color.valueOf("ca8aca");
                
                bullet = new BasicBulletType(12f, 400) {{
                    sprite = "missile-large";
                    width = 15f;
                    height = 21f;
                    lifetime = 35f;
                    pierce = true;
                    pierceBuilding = true;
                    hitColor = backColor = trailColor = Color.valueOf("ca8aca");
                    frontColor = Color.white;
                    trailWidth = 4f;
                    trailLength = 11;
                    hitEffect = despawnEffect = Fx.massiveExplosion;
                    
                    fragBullets = 12;
                    fragBullet = new ArtilleryBulletType(0.5f, 60) {{
                        width = 8f;
                        height = 12f;
                        lifetime = 50f;
                        splashDamageRadius = 25f;
                        splashDamage = 60f;
                        backColor = frontColor = hitColor = Color.valueOf("ca8aca");
                    }};
                }};
            }});
        }};
        
        darkQuell = new ErekirUnitType("dark-quell") {{
            aiController = FlyingFollowAI::new;
            lowAltitude = false;
            flying = true;
            drag = 0.06f;
            speed = 1.1f;
            rotateSpeed = 3.2f;
            accel = 0.1f;
            health = 7200;
            armor = 5f;
            hitSize = 36f;
            payloadCapacity = Mathf.sqr(3f) * Vars.tilePayload;
            targetAir = false;
            engineSize = 4.8f;
            engineOffset = 61 / 4f;
            range = 280f;
            outlineColor = Pal.darkOutline;
            
            abilities.add(new SuppressionFieldAbility() {{
                reload = 60f * 8f;
                orbRadius = 5.3f;
                y = 1f;
                color = particleColor = effectColor = Color.valueOf("ba7aba");
            }});
            
            weapons.add(new Weapon("dark-quell-weapon") {{
                shootSound = Sounds.missileSmall;
                x = 51 / 4f;
                y = 5 / 4f;
                rotate = true;
                rotateSpeed = 2f;
                reload = 50f;
                
                bullet = new MissileBulletType(4.5f, 85) {{
                    width = 12f;
                    height = 22f;
                    lifetime = 70f;
                    hitColor = backColor = trailColor = Color.valueOf("ba7aba");
                    frontColor = Color.white;
                    trailWidth = 3f;
                    trailLength = 12;
                    homingPower = 0.08f;
                    splashDamageRadius = 30f;
                    splashDamage = 120f;
                }};
            }});
        }};
        
        darkDisrupt = new ErekirUnitType("dark-disrupt") {{
            aiController = FlyingFollowAI::new;
            lowAltitude = false;
            flying = true;
            drag = 0.07f;
            speed = 1f;
            rotateSpeed = 2f;
            accel = 0.1f;
            health = 14000;
            armor = 10f;
            hitSize = 46f;
            payloadCapacity = Mathf.sqr(6f) * Vars.tilePayload;
            targetAir = false;
            engineSize = 6f;
            engineOffset = 25.25f;
            outlineColor = Pal.darkOutline;
            
            abilities.add(new SuppressionFieldAbility() {{
                reload = 60 * 15f;
                range = 320f;
                orbRadius = 5f;
                particleSize = 3f;
                y = 10f;
                particles = 10;
                color = particleColor = effectColor = Color.valueOf("ca8aca");
            }});
            
            weapons.add(new Weapon("dark-disrupt-weapon") {{
                shootSound = Sounds.missileLarge;
                x = 78f / 4f;
                y = -10f / 4f;
                mirror = true;
                rotate = true;
                rotateSpeed = 0.4f;
                reload = 65f;
                
                bullet = new MissileBulletType(5f, 170) {{
                    width = 10f;
                    height = 14f;
                    lifetime = 80f;
                    homingPower = 0.1f;
                    splashDamageRadius = 40f;
                    splashDamage = 180f;
                    hitColor = backColor = trailColor = Color.valueOf("ca8aca");
                    frontColor = Color.white;
                    trailWidth = 4f;
                    trailLength = 15;
                    suppressionRange = 140f;
                }};
            }});
        }};
        
        darkTecta = new ErekirUnitType("dark-tecta") {{
            drag = 0.1f;
            speed = 0.6f;
            hitSize = 30f;
            health = 7800;
            armor = 6f;
            lockLegBase = true;
            legContinuousMove = true;
            legGroupSize = 3;
            legStraightness = 0.4f;
            rotateSpeed = 2.1f;
            legCount = 6;
            legLength = 15f;
            legForwardScl = 0.45f;
            legMoveSpace = 1.4f;
            hovering = true;
            shadowElevation = 0.65f;
            groundLayer = Layer.legUnit;
            outlineColor = Pal.darkOutline;
            
            abilities.add(new ShieldArcAbility() {{
                region = "dark-tecta-shield";
                radius = 48f;
                angle = 82f;
                regen = 45f / 60f;
                cooldown = 60f * 8f;
                max = 2600f;
                y = -20f;
                width = 8f;
            }});
            
            weapons.add(new Weapon("dark-tecta-weapon") {{
                shootSound = Sounds.malignShoot;
                mirror = true;
                top = false;
                x = 62/4f;
                y = 1f;
                shootY = 47 / 4f;
                recoil = 3f;
                reload = 38f;
                shake = 3f;
                
                bullet = new MissileBulletType(4.5f, 75) {{
                    homingPower = 0.2f;
                    width = height = 11f;
                    lifetime = 55f;
                    splashDamage = 80f;
                    splashDamageRadius = 35f;
                    hitColor = backColor = trailColor = Color.valueOf("ba7aba");
                    frontColor = Color.white;
                    trailWidth = 3f;
                    trailLength = 20;
                }};
            }});
        }};
        
        darkCollaris = new ErekirUnitType("dark-collaris") {{
            drag = 0.1f;
            speed = 1.1f;
            hitSize = 44f;
            health = 21000;
            armor = 10f;
            rotateSpeed = 1.6f;
            lockLegBase = true;
            legContinuousMove = true;
            legCount = 8;
            legLength = 30f;
            legForwardScl = 2.1f;
            legMoveSpace = 1.05f;
            hovering = true;
            shadowElevation = 0.95f;
            groundLayer = Layer.legUnit;
            targetAir = false;
            alwaysShootWhenMoving = true;
            outlineColor = Pal.darkOutline;
            
            weapons.add(new Weapon("dark-collaris-weapon") {{
                shootSound = Sounds.pulseBlast;
                mirror = true;
                rotationLimit = 30f;
                rotateSpeed = 0.4f;
                rotate = true;
                x = 48 / 4f;
                y = -28f / 4f;
                shootY = 64f / 4f;
                recoil = 4f;
                reload = 120f;
                shake = 7f;
                
                bullet = new ArtilleryBulletType(3.5f, 320) {{
                    collidesTiles = true;
                    lifetime = 80f;
                    shootEffect = Fx.shootBigColor;
                    width = 20f;
                    height = 26f;
                    hitColor = backColor = trailColor = Color.valueOf("ca8aca");
                    frontColor = Color.white;
                    trailWidth = 5f;
                    trailLength = 20;
                    splashDamageRadius = 45f;
                    splashDamage = 140f;
                    
                    fragBullets = 20;
                    fragVelocityMin = 0.5f;
                    fragVelocityMax = 1.2f;
                    fragBullet = new BasicBulletType(6f, 45) {{
                        pierceCap = 2;
                        pierceBuilding = true;
                        homingPower = 0.09f;
                        lifetime = 40f;
                        width = 12f;
                        height = 20f;
                        hitColor = backColor = trailColor = Color.valueOf("ca8aca");
                        frontColor = Color.white;
                        trailWidth = 2.5f;
                        trailLength = 7;
                        splashDamage = 40f;
                        splashDamageRadius = 35f;
                    }};
                }};
            }});
        }};
        
        // Core units
        darkEvoke = new ErekirUnitType("dark-evoke") {{
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, 500f);
            isEnemy = false;
            lowAltitude = false;
            flying = true;
            mineSpeed = 7f;
            mineTier = 3;
            buildSpeed = 1.5f;
            drag = 0.08f;
            speed = 6f;
            rotateSpeed = 8f;
            accel = 0.09f;
            itemCapacity = 70;
            health = 400f;
            armor = 2f;
            hitSize = 10f;
            engineSize = 3f;
            payloadCapacity = 2f * 2f * Vars.tilesize * Vars.tilesize;
            pickupUnits = false;
            vulnerableWithPayloads = true;
            fogRadius = 0f;
            targetable = false;
            hittable = false;
            outlineColor = Pal.darkOutline;
            
            weapons.add(new RepairBeamWeapon() {{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 0f;
                y = 6.5f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                repairSpeed = 3.5f;
                fractionRepairSpeed = 0.06f;
                aimDst = 0f;
                shootCone = 15f;
                mirror = false;
                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Color.valueOf("8a4a8a");
                healColor = Color.valueOf("8a4a8a");
                
                bullet = new BulletType() {{
                    maxRange = 65f;
                }};
            }});
        }};
        
        darkIncite = new ErekirUnitType("dark-incite") {{
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, 500f);
            isEnemy = false;
            lowAltitude = false;
            flying = true;
            mineSpeed = 9f;
            mineTier = 3;
            buildSpeed = 1.7f;
            drag = 0.08f;
            speed = 7.5f;
            rotateSpeed = 9f;
            accel = 0.09f;
            itemCapacity = 100;
            health = 650f;
            armor = 3f;
            hitSize = 12f;
            payloadCapacity = 2f * 2f * Vars.tilesize * Vars.tilesize;
            pickupUnits = false;
            vulnerableWithPayloads = true;
            fogRadius = 0f;
            targetable = false;
            hittable = false;
            engineOffset = 7.2f;
            engineSize = 3.5f;
            outlineColor = Pal.darkOutline;
            
            weapons.add(new RepairBeamWeapon() {{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 0f;
                y = 7.5f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.8f;
                repairSpeed = 3.8f;
                fractionRepairSpeed = 0.06f;
                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Color.valueOf("9a5a9a");
                healColor = Color.valueOf("9a5a9a");
                
                bullet = new BulletType() {{
                    maxRange = 70f;
                }};
            }});
        }};
        
        darkEmanate = new ErekirUnitType("dark-emanate") {{
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, 500f);
            isEnemy = false;
            lowAltitude = false;
            flying = true;
            mineSpeed = 10f;
            mineTier = 3;
            buildSpeed = 2f;
            drag = 0.08f;
            speed = 8f;
            rotateSpeed = 9f;
            accel = 0.08f;
            itemCapacity = 130;
            health = 900f;
            armor = 4f;
            hitSize = 14f;
            buildBeamOffset = 8f;
            payloadCapacity = 2f * 2f * Vars.tilesize * Vars.tilesize;
            pickupUnits = false;
            vulnerableWithPayloads = true;
            fogRadius = 0f;
            targetable = false;
            hittable = false;
            engineOffset = 7.5f;
            engineSize = 3.8f;
            outlineColor = Pal.darkOutline;
            
            weapons.add(new RepairBeamWeapon() {{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 19f/4f;
                y = 19f/4f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.9f;
                repairSpeed = 4f / 2f;
                fractionRepairSpeed = 0.03f;
                mirror = true;
                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Color.valueOf("aa6aaa");
                healColor = Color.valueOf("aa6aaa");
                
                bullet = new BulletType() {{
                    maxRange = 75f;
                }};
            }});
        }};
    }
}
