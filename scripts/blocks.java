Block tankFabricator;

tankFabricator = new UnitFactory("tank-fabricator"){{
    requirements(Category.units, with(Items.silicon, 200, Items.beryllium, 150));
    size = 3;
    configurable = false;
    plans.add(new UnitPlan(darkstell, 60f * 35f, with(Items.beryllium, 40, Items.silicon, 50)));
    researchCost = with(Items.beryllium, 200, Items.graphite, 80, Items.silicon, 80);
    regionSuffix = "-dark";
    fogRadius = 3;
    consumePower(1.5f);
}};
