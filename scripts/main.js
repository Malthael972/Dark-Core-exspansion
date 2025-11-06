// Set constructors for tank units
const tankUnits = ["dark-stell", "dark-locus", "dark-precept", "dark-vanquish", "dark-conquer"];

tankUnits.forEach(name => {
    const unit = Vars.content.getByName(ContentType.unit, "dark-core-expansion-" + name);
    if(unit != null){
        unit.constructor = prov(() => new TankUnit(unit));
    }
});
