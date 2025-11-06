const tankConstructor = () => extend(TankUnit, {});

Events.on(ContentInitEvent, () => {
    Vars.content.units().each(unit => {
        if(unit instanceof TankUnitType){
            unit.constructor = tankConstructor;
        }
    });
});
